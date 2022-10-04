package fr.unice.polytech.cookiefactory.services;

import fr.unice.polytech.cookiefactory.clientelle.InformationClient;

public interface ServiceDEnvoi {
    void send(String message, InformationClient client);
}
