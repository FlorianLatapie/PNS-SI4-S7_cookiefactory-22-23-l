package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.Taille;

public class CookieFestif extends Cookie {

    private static final double MARGE = 1.25;
    private final Taille taille;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public CookieFestif(String nom, Recette recette, Prix prix, Taille taille) {
        super(nom, recette, prix);
        this.taille = taille;
        this.recette.multiplierQuantitePate(taille.getMultiplicateurQuantite());
        this.recette.multiplierQuantiteSaveur(taille.getMultiplicateurQuantite());
        this.recette.multiplierQuantiteGarnitures(taille.getMultiplicateurQuantite());
    }

    public CookieFestif(Cookie cookie, Taille taille) {
        super(cookie.getNom());
        this.taille = taille;
        recette = cookie.getRecette();
        this.recette.multiplierQuantitePate(taille.getMultiplicateurQuantite());
        this.recette.multiplierQuantiteSaveur(taille.getMultiplicateurQuantite());
        this.recette.multiplierQuantiteGarnitures(taille.getMultiplicateurQuantite());
        prix = cookie.getPrixHorsTaxe().multiplier(taille.getMultiplicateurPrix()).multiplier(MARGE);
    }
}
