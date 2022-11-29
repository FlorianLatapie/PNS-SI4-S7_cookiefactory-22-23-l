package fr.unice.polytech.cookiefactory.recette.ingredient;

public class QuantiteIngredient<Ingredient, Integer> {
    private Ingredient ingredient;
    private int quantite;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public QuantiteIngredient(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */
    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
}
