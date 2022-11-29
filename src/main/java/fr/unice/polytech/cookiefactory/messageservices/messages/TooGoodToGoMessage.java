package fr.unice.polytech.cookiefactory.messageservices.messages;

public class TooGoodToGoMessage extends Message {
    final String typeRequete;

    final String magasin;
    final double prix;
    final String description;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public TooGoodToGoMessage(String expediteur, String destinataire, String typeRequete, String magasin, double prix, String description) {
        super(expediteur, destinataire);
        this.typeRequete = typeRequete;
        this.magasin = magasin;
        this.prix = prix;
        this.description = description;
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public String getMessage() {
        return typeRequete + " URL: " + destinataire + System.lineSeparator()
                + "BODY: " + System.lineSeparator()
                + "{" + System.lineSeparator()
                + "  \"magasin\": \"" + magasin + "\"," + System.lineSeparator()
                + "  \"prix\": " + prix + "," + System.lineSeparator()
                + "  \"description\": \"" + description + "\"" + System.lineSeparator()
                + "}" + System.lineSeparator();

    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */

    @Override
    public String toString() {
        return getMessage();
    }

}
