package fr.unice.polytech.cookiefactory.spring.connecteur;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PayementException;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import org.springframework.stereotype.Component;

@Component
public class ProxyBanque implements Banque {

    @Override
    public boolean payer(Prix valeur) throws PayementException {
        if (valeur.getPrixEnCentimes() < 0) {
            throw new PayementException(valeur);
        }
        return true;
    }
}