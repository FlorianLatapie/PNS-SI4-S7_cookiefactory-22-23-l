package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.List;

public record Recette(Pate pate, Saveur saveur, List<Garniture> garnitures, Cuisson cuisson,
                      Melange melange, int tempsPreparation) {
    public Recette {
        if (pate == null || saveur == null || garnitures == null || cuisson == null || melange == null || tempsPreparation <= 0) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être null");
        }
        if (garnitures.size() > 3) {
            throw new IllegalArgumentException("Un cookie ne peut pas avoir plus de 3 garnitures");
        }
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new java.util.ArrayList<>(List.of(pate, saveur));
        ingredients.addAll(garnitures);
        return ingredients;
    }
}
