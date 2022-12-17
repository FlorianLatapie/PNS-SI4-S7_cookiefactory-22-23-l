package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.MessageFactory;
import fr.unice.polytech.cookiefactory.messageservices.messages.builder.TooGoodToGoMessageFactory;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierTooGoodToGo;
import org.springframework.stereotype.Service;


@Service
public class TooGoodToGo implements NotifierTooGoodToGo {
    private static final MessageFactory MESSAGE_FACTORY = new TooGoodToGoMessageFactory();

    @Override
    public void envoyer(Commande commande) {
        System.out.println(MESSAGE_FACTORY.buildMessage(commande));
    }
}
