package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierEmail;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierTooGoodToGo;
import org.springframework.stereotype.Service;

@Service
public class Email implements NotifierEmail {
    @Override
    public void envoyer(Commande commande) {
        throw new RuntimeException("Not implemented yet");
    }
}
