package fr.unice.polytech.cookiefactory.clientelle;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class Invite {
    InformationClient informationClient;

    public Invite(String nom, String prenom, String mail, String numeroDeTelephone) {
        this.informationClient = new InformationClient(nom, prenom, mail, numeroDeTelephone);
    }

    public void enregistrerEnClient() {
        //TODO
    }

    public void consulterCommande() {
        //TODO
    }

    public void annulerCommande(Commande commande) {
        //TODO
    }
}
