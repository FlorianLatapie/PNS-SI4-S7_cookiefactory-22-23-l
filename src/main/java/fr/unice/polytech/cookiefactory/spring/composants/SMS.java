package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierSMS;
import fr.unice.polytech.cookiefactory.spring.interfaces.NotifierTooGoodToGo;
import org.springframework.stereotype.Service;

@Service
public class SMS implements NotifierSMS {
    @Override
    public void envoyer(Commande commande) {
        throw new RuntimeException("Not implemented yet");
    }
}
