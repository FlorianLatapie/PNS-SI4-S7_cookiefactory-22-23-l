package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.services.ServiceDEnvoi;

import java.util.List;

public class GestionnaireDeCommandes {
    private ServiceDEnvoi MailService;
    private ServiceDEnvoi SMSService;
    private List<Commande> commandes;

    public void voirCommandesEnAttenteDeReception() {
        // TODO implement here
    }

    public void commandeReceptionnee(Commande commande) {
        // TODO implement here
    }
}
