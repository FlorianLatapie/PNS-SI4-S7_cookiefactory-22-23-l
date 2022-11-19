package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.commandes.oubliees.GestionnaireDeCommandesOubliees;
import fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy.ConcatenantionGenerationPanierStrategy;
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
        this.commandes.add(commande);
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

    public void payerCommande(Commande commande, Compte compte, boolean paiementAccepte) {
        if (paiementAccepte) {
            Prix prix = commande.getPrix();
            if (compte.getClass().equals(Membre.class)) {
                Membre membre = (Membre) compte;
                membre.ajouterPointsFidelite(commande.getPanier().getNbCookies());
                if (membre.getPointsFidelite() >= Membre.QUOTA) {
                    membre.setPointsFidelite(membre.getPointsFidelite() % Membre.QUOTA);
                    prix = prix.multiplier(0.9);
                }
            }
            commande.changerStatut(Etat.EN_COURS_DE_PREPARATION);
            System.out.println("Vous avez Payé: " + prix);
            System.out.println("Pour: " + commande.getPanier());
            if (!prix.equals(commande.getPrix()))
                System.out.println("Réduction de 10%: " + commande.getPrix().multiplier(0.9));
        } else {
            commande.changerStatut(Etat.ANNULEE);
        }
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
}
