package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.observeur.CookieDuMagasinListener;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BDCookie {
    private final Map<String, Cookie> cookies;
    HashSet<CookieDuMagasinListener> cookieDuMagasinListeners;

    BDCookie() {
        cookies = new HashMap<>();
        cookieDuMagasinListeners = new HashSet<>();
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
        for (CookieDuMagasinListener cookieDuMagasinListener : cookieDuMagasinListeners) {
            cookieDuMagasinListener.update(cookie);
        }
    }

    public List<Cookie> getCookies() {
        return this.cookies.values().stream().toList();
    }

    public List<Cookie> getCookiesEnAttente() {
        return cookies.values().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.SOUMIS)).toList();
    }

    public List<Cookie> getCookiesValide() {
        return cookies.values().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.VALIDE)).toList();
    }

    public void ajouterCookieDuMagasinListener(CookieDuMagasinListener cookieDuMagasinListener) {
        cookieDuMagasinListeners.add(cookieDuMagasinListener);
    }

    public void init() {
        Cookie cookiePopChoco = new Cookie(
                "Pop-Choco",
                new Recette()
                        .setSaveur("Amande")
                        .setGarnitures(List.of("Chocolat", "Chocolat blanc"))
                        .setCuisson("CROQUANT"),
                new Prix(150));
        ajouterUnCookie(cookiePopChoco);
        validerCookie("Pop-Choco");
    }
}
