package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.exceptions.PasAssezIngredientStock;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private final Map<Ingredient, Integer> ingredients;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Stock() {
        ingredients = new HashMap<>();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public void initStock(){
    }

    public void retirerIngredient(Ingredient ingredient, Integer quantite) {
        int intialQuantite = getQuantite(ingredient);
        if (intialQuantite - quantite < 0) {
            throw new PasAssezIngredientStock(quantite, intialQuantite);
        } else {
            ingredients.put(ingredient, getQuantite(ingredient) - quantite);
        }
    }

    public boolean estDisponible(Cookie cookie) {
        for (Ingredient ingredient : cookie.getRecette().getIngredients()) {
            if (!contientIngredient(ingredient) || getQuantite(ingredient) < cookie.getRecette().getQuantite(ingredient)) {
                return false;
            }
        }
        return true;
    }

    public void retirerCookie(Cookie cookie, int quantite) {
        for (Ingredient ingredient : cookie.getRecette().getIngredients()) {
            if (ingredients.containsKey(ingredient) && ingredients.get(ingredient) >= cookie.getRecette().getQuantite(ingredient) * quantite) {
                retirerIngredient(ingredient, cookie.getRecette().getQuantite(ingredient) * quantite);
            }
            else {
                throw new PasAssezIngredientStock(cookie.getRecette().getQuantite(ingredient), ingredients.get(ingredient));
            }
        }
    }

    public boolean contientIngredient(Ingredient ingredient) {
        return ingredients.containsKey(ingredient);
    }

    public void ajouterIngredient(Ingredient ingredient, Integer quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("la quantité ne peut pas être négative");
        }

        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().contains(ingredient)) {
            if (ingredients.containsKey(ingredient)) {
                ingredients.put(ingredient, getQuantite(ingredient) + quantite);
            } else {
                ingredients.put(ingredient, quantite);
            }
        } else {
            throw new IllegalArgumentException("L'ingredient n'existe pas dans la base de donnée");
        }
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    /* ------------------------------------------ Getters ------------------------------------------ */

    public Integer getQuantite(Ingredient ingredient) {
        return ingredients.get(ingredient);
    }
    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients.keySet());
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */

    @Override
    public String toString() {
        return "Stock{" +
                "ingredients=" + ingredients +
                '}';
    }

}
