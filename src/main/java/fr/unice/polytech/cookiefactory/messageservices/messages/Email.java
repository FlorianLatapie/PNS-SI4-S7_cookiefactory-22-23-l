package fr.unice.polytech.cookiefactory.messageservices.messages;

public class Email extends Message {

    String objet;
    String contenu;

    public Email(String expediteur, String destinataire, String objet, String contenu) {
        super(expediteur, destinataire);
        this.objet = objet;
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return getMessage();
    }

    public String getMessage() {
        return "De: " + expediteur + System.lineSeparator()
                + "A: " + destinataire + System.lineSeparator()
                + System.lineSeparator()
                + "Objet: " + objet + System.lineSeparator()
                + System.lineSeparator()
                + "Contenu: " + contenu + System.lineSeparator();
    }
}
