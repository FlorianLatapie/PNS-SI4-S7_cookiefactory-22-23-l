package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.MessageFactory;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.SMSMessageFactory;

public class SMSMessageMessageService implements MessageService {
    private static final MessageFactory MESSAGE_FACTORY = new SMSMessageFactory();

    @Override
    public void envoyer(Commande commande) {
        System.out.println(MESSAGE_FACTORY.buildMessage(commande));
    }
}
