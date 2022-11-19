package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.EmailMessageFactory;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.MessageFactory;

public class EmailMessageMessageService implements MessageService {
    private static final MessageFactory MESSAGE_FACTORY = new EmailMessageFactory();

    @Override
    public void envoyer(Commande commande) {
        System.out.println(MESSAGE_FACTORY.buildMessage(commande));
    }
}
