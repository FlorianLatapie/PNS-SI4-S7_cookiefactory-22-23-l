package fr.unice.polytech.cookiefactory.clientelle;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class Invite {
    private InformationClient informationClient;

    public Invite() {
    }

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
        //TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void consulterCommande() {
        //TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void annulerCommande(Commande commande) {
        //TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public String toString() {
        return informationClient.getNom() + " " + informationClient.getPrenom();
    }
}
