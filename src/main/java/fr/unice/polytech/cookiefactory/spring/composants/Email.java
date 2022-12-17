package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.EmailMessageFactory;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.MessageFactory;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierEmail;
import org.springframework.stereotype.Service;

@Service
public class Email implements NotifierEmail {
    private static final MessageFactory MESSAGE_FACTORY = new EmailMessageFactory();

    @Override
    public void envoyer(Commande commande) {
        System.out.println(MESSAGE_FACTORY.buildMessage(commande));
    }
}
