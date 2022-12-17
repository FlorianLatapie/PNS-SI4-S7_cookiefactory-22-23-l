package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.spring.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService implements Notifier{

    private NotifierTooGoodToGo notifierTooGoodToGo;
    private NotifierEmail notifierEmail;
    private NotifierSMS notifierSMS;

    private TrouverClient trouverClient;

    @Autowired
    public MessageService(NotifierTooGoodToGo notifierTooGoodToGo, NotifierEmail notifierEmail, NotifierSMS notifierSMS){
        this.notifierTooGoodToGo = notifierTooGoodToGo;
        this.notifierEmail = notifierEmail;
        this.notifierSMS = notifierSMS;
    }
}
