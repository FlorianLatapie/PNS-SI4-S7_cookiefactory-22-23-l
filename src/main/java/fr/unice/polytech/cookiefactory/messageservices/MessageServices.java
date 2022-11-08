package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class MessageServices {

    private static MessageServices instance;
    private final EmailMessageMessageService emailMessageService;
    private final SMSMessageMessageService SMSMessageService;

    private MessageServices() {
        emailMessageService = new EmailMessageMessageService();
        SMSMessageService = new SMSMessageMessageService();
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

    public SMSMessageMessageService getSMSMessageService() {
        return SMSMessageService;
    }

    public void sendMessage(Commande commande) {
        emailMessageService.send(commande);
        SMSMessageService.send(commande);
    }
}
