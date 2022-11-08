package fr.unice.polytech.cookiefactory.messageservices;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public interface MessageService {
    void send(Commande commande);
}
