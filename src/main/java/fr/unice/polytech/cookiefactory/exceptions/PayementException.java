package fr.unice.polytech.cookiefactory.exceptions;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.divers.Prix;

public class PayementException extends RuntimeException {

    public PayementException(Invite client, Prix valeur) {
        super("Le client " + client.getNom() + " n'a pas assez d'argent pour payer " + valeur);
    }
}
