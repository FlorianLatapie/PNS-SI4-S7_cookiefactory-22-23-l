package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PayementException;

public interface Banque {

    boolean payer(Prix valeur) throws PayementException;
}
