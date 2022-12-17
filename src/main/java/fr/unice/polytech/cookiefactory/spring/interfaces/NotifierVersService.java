package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public interface NotifierVersService {
    void envoyer(Commande commande);
}
