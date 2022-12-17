package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.spring.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification implements Notifier {

    private NotifierTooGoodToGo notifierTooGoodToGo;
    private NotifierEmail notifierEmail;
    private NotifierSMS notifierSMS;

    private ObtenirClient obtenirClient;

    @Autowired
    public Notification(NotifierTooGoodToGo notifierTooGoodToGo, NotifierEmail notifierEmail, NotifierSMS notifierSMS, ObtenirClient obtenirClient) {
        this.notifierTooGoodToGo = notifierTooGoodToGo;
        this.notifierEmail = notifierEmail;
        this.notifierSMS = notifierSMS;
        this.obtenirClient = obtenirClient;
    }

    @Override
    public void envoyerAvecTousLesServicesClientelle(Commande commande) {
        notifierEmail.envoyer(commande);
        notifierSMS.envoyer(commande);
    }

    @Override
    public void envoyerAvecTousLesServicesPartenaire(Commande commande) {
        notifierTooGoodToGo.envoyer(commande);
    }
}