package fr.unice.polytech.cookiefactory.messageservices.messages.builder;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.messageservices.messages.Message;

public abstract class MessageFactory {
    protected String buildContenu(Commande commande) {
        StringBuilder contenu = new StringBuilder(
                "Bonjour " + commande.getCompte() + ", la commande contenant " + commande.getPanier() + " est "
        );
        switch (commande.getEtat()) {
            case RECEPTIONNEE -> contenu.append("receptionnée");
            case EN_ATTENTE_DE_RETRAIT -> contenu.append("en attente de reception");
            default -> throw new IllegalStateException("Unexpected value: " + commande.getEtat());
        }
        return contenu.toString();
    }

    public abstract Message buildMessage(Commande commande);
}
