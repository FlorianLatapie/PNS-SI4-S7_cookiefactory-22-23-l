package fr.unice.polytech.cookiefactory.clientelle;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class Invite {
    private final InformationClient informationClient;

    public Invite(String nom, String prenom, String mail, String numeroDeTelephone) {
        this.informationClient = new InformationClient(nom, prenom, mail, numeroDeTelephone);
    }

    public Invite(String nom, String prenom) {
        this.informationClient = new InformationClient(nom, prenom);
    }

    public InformationClient getInformationClient() {
        return informationClient;
    }

    public void enregistrerEnClient() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void consulterCommande() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void annulerCommande(Commande commande) {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
