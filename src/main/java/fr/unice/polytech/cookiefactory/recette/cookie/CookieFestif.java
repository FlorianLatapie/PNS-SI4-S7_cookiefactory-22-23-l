package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.Taille;

public class CookieFestif extends Cookie {

    private static final double MARGE = 1.25;
    private final Taille taille;

    public CookieFestif(String nom, Recette recette, Prix prix, Taille taille) {
        super(nom, recette, prix);
        this.taille = taille;
    }

    public CookieFestif(Cookie cookie) {
        super(cookie.getNom());
        this.taille = Taille.L;
        recette = cookie.getRecette(); // à changer plus tard par la multiplication de la quantité définie dans Size
        prix = cookie.getPrixHorsTaxe().multiplier(taille.getMultiplicateurPrix()).multiplier(MARGE);
    }
}
