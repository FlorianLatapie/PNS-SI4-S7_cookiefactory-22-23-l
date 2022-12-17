package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

public interface ModifierCookieGlobaux {
    void ajouterUnCookie(Cookie cookie);

    void validerCookie(String nom);
}
