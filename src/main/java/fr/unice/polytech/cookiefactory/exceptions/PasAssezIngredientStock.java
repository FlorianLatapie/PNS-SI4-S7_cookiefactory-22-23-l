package fr.unice.polytech.cookiefactory.exceptions;

public class PasAssezIngredientStock extends RuntimeException {

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public PasAssezIngredientStock(int nbARetirer, int nbTotal) {
        super("Le nombre d'ingrédients à retirer est trop important (total : " + nbTotal + " | retirer : " + nbARetirer);
    }
}
