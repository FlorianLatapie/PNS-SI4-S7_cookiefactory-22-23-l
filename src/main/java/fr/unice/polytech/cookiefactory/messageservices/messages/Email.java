package fr.unice.polytech.cookiefactory.messageservices.messages;

public class Email extends Message {
    final String objet;
    final String contenu;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Email(String expediteur, String destinataire, String objet, String contenu) {
        super(expediteur, destinataire);
        this.objet = objet;
        this.contenu = contenu;
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public String getMessage() {
        return "De: " + expediteur + System.lineSeparator()
                + "A: " + destinataire + System.lineSeparator()
                + System.lineSeparator()
                + "Objet: " + objet + System.lineSeparator()
                + System.lineSeparator()
                + "Contenu: " + contenu + System.lineSeparator();
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */

    @Override
    public String toString() {
        return getMessage();
    }


}
