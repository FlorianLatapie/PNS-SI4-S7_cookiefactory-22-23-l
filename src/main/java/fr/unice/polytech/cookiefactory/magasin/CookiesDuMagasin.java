package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesDuMagasin {
    private final List<Cookie> cookiesDisponibles;
    public CookiesDuMagasin() {
        this.cookiesDisponibles = new ArrayList<>();
    }
    
    public List<Cookie> getCookiesDisponibles() {
        return cookiesDisponibles;
    }

    public void ajouterCookie(Cookie cookie) {
        cookiesDisponibles.add(cookie);
    }

}