package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.exceptions.PasAssezIngredientStock;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private final Map<Ingredient, Integer> ingredients;

    public Stock() {
        ingredients = new HashMap<>();
    }

    public void retirerIngredient(Ingredient ingredient, Integer quantite) {
        int intialQuantite = getQuantite(ingredient);
        if (intialQuantite - quantite < 0) {
            throw new PasAssezIngredientStock(quantite, intialQuantite);
        } else {
            ingredients.put(ingredient, getQuantite(ingredient) - quantite);
        }
    }

    public Integer getQuantite(Ingredient ingredient) {
        return ingredients.get(ingredient);
    }

    public void ajouterIngredient(Ingredient ingredient, Integer quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("la quantité ne peut pas être négative");
        }

        Integer stockQuantite = getQuantite(ingredient);
        if (stockQuantite == null) { //TODO vérifier si le check du null est nécessaire ou s'il peut être remplacé par un int initialisé à 0, ou initialiser par défaut à 0 dans le constructeur
            ingredients.put(ingredient, quantite);
        } else {
            ingredients.put(ingredient, getQuantite(ingredient) + quantite);
        }
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients.keySet());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ingredients=" + ingredients +
                '}';
    }
}
