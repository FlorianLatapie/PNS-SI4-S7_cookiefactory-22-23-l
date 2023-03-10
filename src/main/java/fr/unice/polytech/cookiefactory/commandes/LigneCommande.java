package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PasAssezCookies;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

public class LigneCommande {

    private final Cookie cookie;
    private int quantite;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public LigneCommande(Cookie cookie, int nombre) {
        this.quantite = nombre;
        this.cookie = cookie;
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public void ajouterQuantite(int quantite) {
        this.quantite += quantite;
    }

    public void enleverQuantite(int quantite) {
        int newValue = this.quantite - quantite;
        if (newValue < 0) {
            throw new PasAssezCookies(quantite, this.quantite);
        }
        this.quantite -= quantite;
    }

    public Prix obtenirPrixSelonQuantite() {
        return cookie.getPrixHorsTaxe().multiplier(quantite);
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public int getQuantite() {
        return quantite;
    }

    public Cookie getCookie() {
        return cookie;
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */
    @Override
    public String toString() {
        return "{ " + cookie + ", " + quantite + " }";
    }
}
