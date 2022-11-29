package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class MessageServices {

    private static MessageServices instance;
    private final EmailMessageMessageService emailMessageService;
    private final SMSMessageMessageService smsMessageMessageService;
    private final TooGoodToGoMessageService tooGoodToGoMessageService;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    private MessageServices() {
        emailMessageService = new EmailMessageMessageService();
        smsMessageMessageService = new SMSMessageMessageService();
        tooGoodToGoMessageService = new TooGoodToGoMessageService();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public static MessageServices getInstance() {
        if (instance == null) {
            instance = new MessageServices();
        }
        return instance;
    }

    public void envoyerAvecTousLesServicesClientelle(Commande commande) {
        emailMessageService.envoyer(commande);
        smsMessageMessageService.envoyer(commande);
    }

    public void envoyerAvecTousLesServicesPartenaire(Commande commande) {
        tooGoodToGoMessageService.envoyer(commande);
    }
}
