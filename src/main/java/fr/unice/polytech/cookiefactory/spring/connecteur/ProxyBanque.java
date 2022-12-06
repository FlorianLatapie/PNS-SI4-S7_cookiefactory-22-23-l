package fr.unice.polytech.cookiefactory.spring.connecteur;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PayementException;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import org.springframework.stereotype.Component;

@Component
public class ProxyBanque implements Banque {

    @Override
    public boolean payer(Invite invite, Prix valeur) throws PayementException {
        return (valeur.getPrixEnCentimes() > 0);
    }
}