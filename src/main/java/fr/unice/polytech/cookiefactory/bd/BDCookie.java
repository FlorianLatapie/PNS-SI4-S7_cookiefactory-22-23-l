package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Cookie cookiePopChoco = new Cookie(
                "Pop-Choco",
                new Recette(
                        new Pate("Pizza"),
                        new Saveur("4 fromage"),
                        List.of(new Garniture("Chocolat"), new Garniture("Tomate")),
                        Cuisson.CROQUANT,
                        Melange.MIXTE,
                        15
                ),
                new Prix(150));
        cookies.put(cookiePopChoco.getNom(), cookiePopChoco);
    }

    public Cookie getCookieParNom(String nom) {
        if (!cookies.containsKey(nom)) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        return cookies.get(nom);
    }

    public void ajouterUnCookie(Cookie cookie){
        cookies.put(cookie.getNom(), cookie);
    }

    public void validerUnCookie(String nom){
        Cookie cookie = cookies.remove(nom);
        cookie.changerEtat(ValidationCookie.VALIDE);
        ajouterUnCookie(cookie);
    }

    public List<Cookie> getCookiesEnAttente(){
        return cookies.values().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.SOUMIS)).toList();
    }
}
