package fr.unice.polytech.cookiefactory.messageservices.messages.builder;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.Email;
import fr.unice.polytech.cookiefactory.messageservices.messages.Message;

public class EmailMessageBuilder extends MessageFactory {
    public static final String MARQUE_MAIL = "cookiefactory@pns.fr";

    @Override
    public Message buildMessage(Commande commande) {
        return new Email(MARQUE_MAIL, commande.getCompte().getEmail(), buildObjet(commande), buildContenu(commande));
    }

    private String buildObjet(Commande commande) {
        StringBuilder objet = new StringBuilder("Votre commande est ");
        switch (commande.getEtat()) {
            case EN_ATTENTE_DE_RETRAIT -> objet.append("en attente de réception");
            case RECEPTIONNEE -> objet.append("recéptionnée");
            default -> throw new IllegalStateException("Unexpected value: " + commande.getEtat());
        }
        return objet.toString();
    }
}
