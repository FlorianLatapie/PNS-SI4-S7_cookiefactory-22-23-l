package fr.unice.polytech.cookiefactory.recette.cookie.factory;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.CookieFestif;
import fr.unice.polytech.cookiefactory.recette.enums.Taille;

public class SimpleCookieFestifFactory extends SimpleCookieFactory {

    private Taille taille = Taille.L;

    public SimpleCookieFestifFactory() {
        super();
    }

    public void setSize(Taille taille) {
        this.taille = taille;
    }

    @Override
    public Cookie creerCookie(String nom) {
        return creerCookieFestif(nom);
    }

    public CookieFestif creerCookieFestif(String nom) {
        return new CookieFestif(nom, recette, prix, taille);
    }
}
