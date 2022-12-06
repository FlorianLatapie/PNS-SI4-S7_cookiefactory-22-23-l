package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.LigneCommande;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.List;

public interface ConsulterPanier {

    List<Cookie> getCookies(Invite invite);

    int getNbCookies(Invite invite);
}
