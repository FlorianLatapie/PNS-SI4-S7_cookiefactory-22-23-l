package fr.unice.polytech.cookiefactory.exceptions;

import fr.unice.polytech.cookiefactory.divers.Prix;

public class PayementException extends RuntimeException {

    public PayementException(Prix valeur) {
        super("Le payement de " + valeur + " a échoué");
    }
}
