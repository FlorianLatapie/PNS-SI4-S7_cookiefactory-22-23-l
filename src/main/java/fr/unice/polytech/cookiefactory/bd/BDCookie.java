package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class BDCookie {
    private static BDCookie instance;

    private final Map<String, Cookie> cookies;

    public static BDCookie getInstance() {
        if (instance == null) {
            instance = new BDCookie();
        }
        return instance;
    }

    private BDCookie() {
        cookies = new HashMap<>();
        Cookie cookiePopChoco = new Cookie(new Prix(150));
        cookiePopChoco.addIngredient(new Ingredient("Chocolat"));
        cookies.put("Pop-Choco", cookiePopChoco);
    }

    public Cookie getCookieParNom(String nom) {
        if (!cookies.containsKey(nom)) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        return cookies.get(nom);
    }
}
