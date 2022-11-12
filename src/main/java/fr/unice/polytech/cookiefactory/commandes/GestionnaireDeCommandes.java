package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteurs.clients.Client;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.messageservices.MessageServices;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireDeCommandes {
    private final List<Commande> commandes = new ArrayList<>();
    private Magasin magasin;

    public GestionnaireDeCommandes() {
        this.magasin = new Magasin();
    }

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
        this.commandes.remove(commande);
        changerStatut(commande, Etat.RECEPTIONNEE);
    }

    public void changerStatut(Commande commande, Etat etat) {
        commande.changerStatut(etat);
        if (needToSendMessage(commande)) MessageServices.getInstance().sendMessage(commande);

    }

    public void ajouterCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public void ajouterCommande(List<Commande> commandes) {
        this.commandes.addAll(commandes);
    }

    public Commande obtenirCommandeInvite(String prenom, String nom) {
        return this.voirCommandesEnAttenteDeReception()
                .stream()
                .filter(c -> c.getInvite().getInformationClient().getPrenom().equals(prenom)
                        &&
                        c.getInvite().getInformationClient().getNom().equals(nom)
                ).findFirst().get();
    }

    public void payerCommande(Commande commande, Client client) {
        if (commande.getEtat() != Etat.EN_COURS_DE_PAIEMENT) return;
        if (client.getSolde().getPrixEnCentimes() >= commande.getPrixAvecTaxe(commande.getPrix()).getPrixEnCentimes()) {
            changerStatut(commande, Etat.EN_COURS_DE_PREPARATION);
            client.payer(commande);
        } else {
            changerStatut(commande, Etat.ANNULEE);
            throw new IllegalArgumentException("Le client n'a pas assez d'argent");
        }
    }

    private void envoyerMessage(Commande commande) {
        MessageServices.getInstance().sendMessage(commande);
    }

    private boolean needToSendMessage(Commande commande) {
        return commande.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT || commande.getEtat() == Etat.RECEPTIONNEE;
    }
}
