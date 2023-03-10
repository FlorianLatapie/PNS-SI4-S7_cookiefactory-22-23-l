package fr.unice.polytech.cookiefactory.messageservices.messages.builder;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.Message;
import fr.unice.polytech.cookiefactory.messageservices.messages.SMS;

public class SMSMessageFactory extends MessageFactory {
    public static final String MARQUE_TEL = "01 23 45 67 89";

    @Override
    public Message buildMessage(Commande commande) {
        return new SMS(MARQUE_TEL, commande.getCompte().getTelephone(), buildContenu(commande));
    }
}
