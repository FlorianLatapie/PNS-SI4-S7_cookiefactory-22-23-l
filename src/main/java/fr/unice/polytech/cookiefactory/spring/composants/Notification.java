package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.spring.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification implements Notifier{

    private NotifierTooGoodToGo notifierTooGoodToGo;
    private NotifierEmail notifierEmail;
    private NotifierSMS notifierSMS;

    private ObtenirClient trouverClient;

    @Autowired
    public Notification(NotifierTooGoodToGo notifierTooGoodToGo, NotifierEmail notifierEmail, NotifierSMS notifierSMS){
        this.notifierTooGoodToGo = notifierTooGoodToGo;
        this.notifierEmail = notifierEmail;
        this.notifierSMS = notifierSMS;
    }
}
