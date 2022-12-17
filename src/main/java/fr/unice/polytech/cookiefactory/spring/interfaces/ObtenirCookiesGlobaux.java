package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.List;

public interface ObtenirCookiesGlobaux {
    Cookie getCookieParNom(String nom);

    List<Cookie> getCookiesEnAttente();

    List<Cookie> getCookiesValide();
}
