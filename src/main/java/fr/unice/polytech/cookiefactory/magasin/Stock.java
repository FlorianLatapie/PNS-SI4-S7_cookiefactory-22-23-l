package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.exceptions.PasAssezIngredientStock;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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


    public LocalDateTime heure() {
        System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        return LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ingredients=" + ingredients +
                '}';
    }
}
