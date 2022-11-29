package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.observeur.CookieDuMagasinListener;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GererRecettesGlobales implements ConsulterRecettesGlobales, ModifierRecettesGlobales {
    private final Map<String, Cookie> cookies;
    HashSet<CookieDuMagasinListener> cookieDuMagasinListeners;

    GererRecettesGlobales() {
        cookies = new HashMap<>();
        cookieDuMagasinListeners = new HashSet<>();
        init();
    }

    @Override
    public Cookie getCookieParNom(String nom) {
        if (!cookies.containsKey(nom)) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        return cookies.get(nom);
    }

    @Override
    public void ajouterUnCookie(Cookie cookie) {
        cookies.put(cookie.getNom(), cookie);
    }

    @Override
    public void validerCookie(String nom) {
        if (!cookies.containsKey(nom)) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        Cookie cookie = cookies.remove(nom);
        cookie.changerEtat(ValidationCookie.VALIDE);
        ajouterUnCookie(cookie);
        for (CookieDuMagasinListener cookieDuMagasinListener : cookieDuMagasinListeners) {
            cookieDuMagasinListener.update(cookie);
        }
    }

    @Override
    public List<Cookie> getCookies() {
        return this.cookies.values().stream().toList();
    }

    @Override
    public List<Cookie> getCookiesEnAttente() {
        return cookies.values().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.SOUMIS)).toList();
    }

    @Override
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
                        .setSaveur("Amande", 10)
                        .setGarnitures(List.of("Chocolat", "Chocolat blanc"), 10)
                        .setCuisson("CROQUANT"),
                new Prix(150));
        ajouterUnCookie(cookiePopChoco);
        validerCookie("Pop-Choco");
    }
}
