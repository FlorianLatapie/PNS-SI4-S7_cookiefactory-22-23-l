package fr.unice.polytech.cookiefactory.messageservices.messages;

public abstract class Message {

    protected final String expediteur;
    protected final String destinataire;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    protected Message(String expediteur, String destinataire) {
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }
}
