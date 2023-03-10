package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.magasin.observeur.CookieDuMagasinListener;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CookiesDuMagasin implements CookieDuMagasinListener {
    private final HashMap<String, Cookie> cookiesDuMagasin;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public CookiesDuMagasin() {
        this.cookiesDuMagasin = new HashMap<>();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    @Override
    public void update(Cookie cookie) {
        cookiesDuMagasin.put(cookie.getNom(), cookie);
    }

    /* ------------------------------------------ Getters ------------------------------------------ */

    public HashMap<String, Cookie> getCookies() {
        return cookiesDuMagasin;
    }


}