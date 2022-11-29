package fr.unice.polytech.cookiefactory.bd;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.List;

public interface ConsulterRecettesGlobales {
    Cookie getCookieParNom(String nom);

    List<Cookie> getCookies();

    List<Cookie> getCookiesEnAttente();

    List<Cookie> getCookiesValide();
}
