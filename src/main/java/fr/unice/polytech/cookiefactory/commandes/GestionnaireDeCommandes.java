package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteurs.clients.Client;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.services.ServiceDEnvoi;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireDeCommandes {
    private final List<Commande> commandes = new ArrayList<>();
    private ServiceDEnvoi MailService;
    private ServiceDEnvoi SMSService;

    public List<Commande> getCommandes() {
        return commandes;
    }

    public List<Commande> voirCommandesEnAttenteDeReception() {
        return this.commandes.stream().filter(c -> c.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT).toList();
    }

    public void commandeReceptionnee(Commande commande) {
        this.commandes.remove(commande);
        commande.changerStatut(Etat.RECEPTIONNEE);
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
        if (commande.getEtat() != Etat.EN_COURS_DE_PAYMENT) return;
        if (client.getSolde().value() >= commande.getPrix().value()) {
            commande.changerStatut(Etat.EN_COURS_DE_PREPARATION);
            client.payer(commande);
        } else {
            commande.changerStatut(Etat.ANNULEE);
            throw new IllegalArgumentException("Le client n'a pas assez d'argent");
        }
    }
}
