package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.commandes.oubliees.GestionnaireDeCommandesOubliees;
import fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy.ConcatenantionGenerationPanierStrategy;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.divers.IClasseTempsReel;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.messageservices.MessageServices;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionnaireDeCommandes implements IClasseTempsReel {
    private final List<Commande> commandes = new ArrayList<>();
    private final Magasin magasin;
    private final GestionnaireDeCommandesOubliees gestionnaireCommandesOubliees;

    public GestionnaireDeCommandes(Magasin magasin) {
        this.magasin = magasin;
        this.gestionnaireCommandesOubliees = new GestionnaireDeCommandesOubliees(magasin.getDate(), new ConcatenantionGenerationPanierStrategy());
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public List<Commande> voirCommandesEnAttenteDeReception() {
        return this.commandes.stream().filter(c -> c.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT).toList();
    }

    public void commandeReceptionnee(Commande commande) {
        changerStatut(commande, Etat.RECEPTIONNEE);
        this.commandes.remove(commande);
    }

    public void changerStatut(Commande commande, Etat etat) {
        commande.changerStatut(etat);
        if (besoinDEnvoyerMessage(commande))
            MessageServices.getInstance().envoyerAvecTousLesServicesClientelle(commande);
    }

    public void ajouterCommande(Commande commande) {
        commande.setGestionnaireDeCommandes(this);
        this.commandes.add(commande);
    }

    public void annulerCommande(Commande commande) {
        if(commandeAppartientAuGestionnaire(commande)) {
            Compte compteAvecCommande;
            if (commande.getEtat() == Etat.CONFIRMEE) {
                compteAvecCommande = commande.getCompte(); //TODO rembourser client
                Cuisinier cuisinier = obtenirCuisinierPreparantCommande(commande);
                cuisinier.annulerCommande(commande); //désassigner le cuisinier
                                                     //TODO remettre en stock les ingrédients
                this.enleverCommande(commande);      //enlever commande du gestionnaire
            }
            else {
                throw new IllegalArgumentException("Vous ne pouvez pas annuler votre commande maintenant.");
            }
        }
        else {
            throw new IllegalArgumentException("Vous ne pouvez pas annuler une commande qui n'appartient pas au gestionnaire. ");
        }
    }

    public Cuisinier obtenirCuisinierPreparantCommande(Commande commande) {
        return magasin.getGestionnaireDeCuisiniers().getCuisiniers().stream().filter(cuisinier -> cuisinier.getGestionnaireDeCommandes().commandeAppartientAuGestionnaire(commande)).findFirst().get();
    }

    public boolean commandeAppartientAuGestionnaire(Commande commande) {
        return this.commandes.contains(commande);
    }
    public void enleverCommande(Commande commande) {
        if(commandeAppartientAuGestionnaire(commande)) {
            this.commandes.remove(commande);
            commande.changerStatut(Etat.ANNULEE);
        }
        else {
            throw new IllegalArgumentException("Erreur: la commande n'est pas dans le gestionnaire de commande. ");
        }
    }
    public void ajouterCommande(List<Commande> commandes) {
        this.commandes.addAll(commandes);
    }

    public Optional<Commande> obtenirCommandeCompte(String prenom, String nom) {
        return this.voirCommandesEnAttenteDeReception()
                .stream()
                .filter(c -> c.getCompte().getNom().equals(nom) && c.getCompte().getPrenom().equals(prenom))
                .findFirst();
    }

    public boolean verifierCommande(Commande commande) {
        return magasin.verifierCommande(commande);
    }

    public Prix payerCommande(Commande commande, Compte compte, boolean paiementAccepte) {
        Prix prix = Prix.ZERO;
        if (paiementAccepte) {
            if (compte.getClass().equals(Membre.class)) {
                Membre membre = (Membre) compte;
                membre.ajouterPointsFidelite(commande.getPanier().getNbCookies());
                if (membre.aReduction()) {
                    commande.appliquerRemise();
                }
            }
            prix = commande.getPrixAvecTaxe();
            commande.changerStatut(Etat.EN_COURS_DE_PREPARATION);
            System.out.println("Vous avez Payé: " + prix);
            System.out.println("Pour: " + commande.getPanier());
            if (!prix.equals(commande.getPrixHorsTaxe()))
                System.out.println("Réduction de " + Commande.REDUCTION + "%: " + commande.getPrixHorsTaxe().multiplier(0.9));
        } else {
            commande.changerStatut(Etat.ANNULEE);
        }
        return prix;
    }

    public void reserverCommande(Commande commande) {
        magasin.resreverIngredients(commande);
    }

    private boolean besoinDEnvoyerMessage(Commande commande) {
        return commande.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT || commande.getEtat() == Etat.RECEPTIONNEE;
    }

    public void updateHeure(ZonedDateTime zonedDateTime) {
        this.commandes.forEach(commande -> commande.updateHeure(zonedDateTime));
        this.gestionnaireCommandesOubliees.ajouterCommandesOubliees(this.commandes.stream().filter(c -> c.getEtat() == Etat.OUBLIEE).toList());
        this.gestionnaireCommandesOubliees.updateHeure(zonedDateTime);
    }

    public GestionnaireDeCommandesOubliees getGestionnaireCommandesOubliees() {
        return gestionnaireCommandesOubliees;
    }

    public Prix ajouterTaxe(Prix p) {
        double prix = p.getPrixEnCentimes();
        double prixAvecTaxe = prix * (1 + getMagasin().getValeurTaxe());
        return new Prix((int) prixAvecTaxe);
    }
}
