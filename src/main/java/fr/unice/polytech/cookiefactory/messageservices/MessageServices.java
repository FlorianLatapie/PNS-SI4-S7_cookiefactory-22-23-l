package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class MessageServices {

    private static MessageServices instance;
    private final EmailMessageMessageService emailMessageService;
    private final SMSMessageMessageService smsMessageMessageService;

    private MessageServices() {
        emailMessageService = new EmailMessageMessageService();
        smsMessageMessageService = new SMSMessageMessageService();
    }

    public static MessageServices getInstance() {
        if (instance == null) {
            instance = new MessageServices();
        }
        return instance;
    }

    public EmailMessageMessageService getEmailService() {
        return emailMessageService;
    }

    public SMSMessageMessageService getSmsMessageMessageService() {
        return smsMessageMessageService;
    }

    public void sendMessage(Commande commande) {
        emailMessageService.send(commande);
        smsMessageMessageService.send(commande);
    }
}
