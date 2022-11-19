package fr.unice.polytech.cookiefactory.messageservices.messages;

public class TooGoodToGoMessage extends Message {
    String typeRequete;

    String magasin;
    double prix;
    String description;

    public TooGoodToGoMessage(String expediteur, String destinataire, String typeRequete, String magasin, double prix, String description) {
        super(expediteur, destinataire);
        this.typeRequete = typeRequete;
        this.magasin = magasin;
        this.prix = prix;
        this.description = description;
    }

    @Override
    public String toString() {
        return getMessage();
    }

    public String getMessage() {
        return typeRequete + " URL: " + destinataire + System.lineSeparator()
                + "BODY: " + System.lineSeparator()
                + "{" + System.lineSeparator()
                + "  \"magasin\": \"" + magasin + "\"," + System.lineSeparator()
                + "  \"prix\": " + prix + "," + System.lineSeparator()
                + "  \"description\": \"" + description + "\"" + System.lineSeparator()
                + "}" + System.lineSeparator();

    }
}
