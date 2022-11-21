package fr.unice.polytech.cookiefactory.messageservices.messages;

public class SMS extends Message {

    final String contenu;

    public SMS(String expediteur, String destinataire, String contenu) {
        super(expediteur, destinataire);
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
                + "Contenu: " + contenu + System.lineSeparator();
    }
}
