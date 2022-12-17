package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;

import java.util.Optional;
import java.util.UUID;

public interface ObtenirClient {

    Optional<Invite> getClient(UUID id);

    Optional<Invite> getClient(String nom, String prenom);

    boolean estClient(UUID id);

    boolean estClient(String nom, String prenom);
}
