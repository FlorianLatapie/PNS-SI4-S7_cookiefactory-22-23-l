package fr.unice.polytech.cookiefactory.spring.depots;

import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClientDepot extends DepotBasiqueImplemente<Invite, UUID> {
}
