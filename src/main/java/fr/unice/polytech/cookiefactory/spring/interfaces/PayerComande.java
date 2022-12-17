package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;

public interface PayerComande {

    Commande payer(Invite invite);
}
