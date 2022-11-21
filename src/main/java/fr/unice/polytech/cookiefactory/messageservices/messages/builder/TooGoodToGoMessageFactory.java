package fr.unice.polytech.cookiefactory.messageservices.messages.builder;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.Message;
import fr.unice.polytech.cookiefactory.messageservices.messages.TooGoodToGoMessage;

public class TooGoodToGoMessageFactory extends MessageFactory {
    @Override
    public Message buildMessage(Commande commande) {
        return new TooGoodToGoMessage(
                "https://theCookieFactory.com/",
                "https://api.toogoodtogo.com/api/auth/v1/login",
                "POST",
                commande.getGestionnaireDeCommandes().getMagasin().getNom(),
                commande.getPrixHorsTaxe().getPrixEnCentimes() / 100.0,
                commande.getPanier().getLignesCommande().toString()
        );
    }
}
