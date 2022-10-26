package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PasAssezIngredientStock;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.*;

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
        if (stockQuantite == null) {
            ingredients.put(ingredient, quantite);
        } else {
            ingredients.put(ingredient, getQuantite(ingredient) + quantite);
        }
    }

    public void nouvelIngredient(Ingredient ingredient) {
        ingredients.put(ingredient, 0);
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public Ingredient getIngredient(String nomIngredient) {
        String nom = nomIngredient.toLowerCase();
        Optional<Ingredient> res = ingredients.keySet().stream().filter(ingredient -> ingredient.getNom().equals(nom)).findFirst();

        if (res.isEmpty()) {
            throw new NoSuchElementException();
        }

        return res.get();
    }


}
