package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.spring.depots.ClientDepot;
import fr.unice.polytech.cookiefactory.spring.interfaces.AjouterClient;
import fr.unice.polytech.cookiefactory.spring.interfaces.ModifierClient;
import fr.unice.polytech.cookiefactory.spring.interfaces.ObtenirClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistreClient implements ObtenirClient, ModifierClient, AjouterClient {
    private ClientDepot clientDepot;

    @Autowired
    public RegistreClient(ClientDepot clientDepot) {
        this.clientDepot = clientDepot;
    }
}
