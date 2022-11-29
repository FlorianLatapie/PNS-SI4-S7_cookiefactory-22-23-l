package fr.unice.polytech.cookiefactory.bd;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

public interface ModifierRecettesGlobales {
    void ajouterUnCookie(Cookie cookie);

    void validerCookie(String nom);
}
