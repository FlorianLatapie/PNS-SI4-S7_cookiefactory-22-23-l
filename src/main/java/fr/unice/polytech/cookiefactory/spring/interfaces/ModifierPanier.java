package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

public interface ModifierPanier {

    void ajouterCookies(Invite invite, Cookie cookie, int quantite);

    void supprimerCookies(Invite invite, Cookie cookie, int quantite);
}
