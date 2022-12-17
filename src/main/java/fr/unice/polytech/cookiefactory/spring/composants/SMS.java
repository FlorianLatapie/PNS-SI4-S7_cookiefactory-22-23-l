package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.MessageFactory;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.SMSMessageFactory;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierSMS;
import org.springframework.stereotype.Service;

@Service
public class SMS implements NotifierSMS {
    private static final MessageFactory MESSAGE_FACTORY = new SMSMessageFactory();

    @Override
    public void envoyer(Commande commande) {
        System.out.println(MESSAGE_FACTORY.buildMessage(commande));
    }
}
