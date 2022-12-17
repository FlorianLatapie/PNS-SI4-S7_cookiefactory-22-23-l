package fr.unice.polytech.cookiefactory.spring.connecteur;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PayementException;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProxyBanque implements Banque {

    @Override
    public void payer(Prix valeur) throws PayementException {
        if (valeur.getPrixEnCentimes() < 0) {
            throw new PayementException(valeur);
        }
    }
}