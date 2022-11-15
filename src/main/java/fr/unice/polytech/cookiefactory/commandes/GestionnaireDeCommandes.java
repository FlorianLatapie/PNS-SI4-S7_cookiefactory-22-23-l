package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.messageservices.MessageServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionnaireDeCommandes {
    private final List<Commande> commandes = new ArrayList<>();
    private final Magasin magasin;

    public GestionnaireDeCommandes(Magasin magasin) {
        this.magasin = magasin;
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
        if (besoinDEnvoyerMessage(commande)) MessageServices.getInstance().sendMessage(commande);
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
            commande.changerStatut(Etat.EN_COURS_DE_PREPARATION);
            if (compte.getClass().equals(Membre.class)) {
                ((Membre) compte).ajouterPointsFidelite(commande.getPanier().getNbCookies());
            }
        } else {
            commande.changerStatut(Etat.ANNULEE);
        }
    }

    private boolean besoinDEnvoyerMessage(Commande commande) {
        return commande.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT || commande.getEtat() == Etat.RECEPTIONNEE;
    }
}
