package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDCookie {
    private final Map<String, Cookie> cookies;

    BDCookie() {
        cookies = new HashMap<>();
        init();
    }

    public Cookie getCookieParNom(String nom) {
        if (!cookies.containsKey(nom)) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        return cookies.get(nom);
    }

    public void ajouterUnCookie(Cookie cookie) {
        cookies.put(cookie.getNom(), cookie);
    }

    public void validerCookie(String nom) {
        Cookie cookie = cookies.remove(nom);
        cookie.changerEtat(ValidationCookie.VALIDE);
        ajouterUnCookie(cookie);
    }

    public List<Cookie> getGetCookies() {
        return this.cookies.values().stream().toList();
    }


    public List<Cookie> getCookiesEnAttente() {
        return cookies.values().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.SOUMIS)).toList();
    }

    public void init() {
        Cookie cookiePopChoco = new Cookie(
                "Pop-Choco",
                new Recette(
                        new Pate("Pate basic"),
                        new Saveur("Amandes"),
                        List.of(new Garniture("Chocolat"), new Garniture("Chocolat blanc")),
                        Cuisson.CROQUANT,
                        Melange.MIXTE,
                        15
                ),
                new Prix(150));
        cookies.put(cookiePopChoco.getNom(), cookiePopChoco);
    }
}
