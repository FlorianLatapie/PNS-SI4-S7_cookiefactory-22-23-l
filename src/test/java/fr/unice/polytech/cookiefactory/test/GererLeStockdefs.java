package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.magasin.Stock;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;
import static org.junit.jupiter.api.Assertions.*;

public class GererLeStockdefs {
    private Stock stock;
    private Ingredient ingredient;
    private final GestionExceptions gestionExceptions = new GestionExceptions();

    @Étantdonné("un stock")
    public void sonStock() {
        stock = new Stock();
    }

    @Et("un ingrédient {string}")
    public void unIngrédient(String nomIngredient) {
        ingredient = new Ingredient(nomIngredient);
    }

    @Étantdonné("le stock ayant {int} ingrédients")
    public void leStockAyantNbInitialIngrédients(int nbIngredient) {
        stock.ajouterIngredient(ingredient, nbIngredient);
    }

    @Quand("le responsable du stock ajoute {int} ingrédients")
    public void leResponsableDuStockAjouteNbIngredients(int nbIngredient) {
        try {
            stock.ajouterIngredient(ingredient, nbIngredient);
        } catch (RuntimeException exception) {
            gestionExceptions.ajouteException(exception);
        }
    }

    @Alors("le stock comporte {int} ingrédients")
    public void leStockComporteNbFinalIngrédients(int nbIngredient) {
        assertEquals(nbIngredient, stock.getQuantite(ingredient));
    }

    @Et("un problème est attendu")
    public void unProblèmeEstAttendu() {
        gestionExceptions.exceptionAttendue();
    }

    @Et("une exception IllegalArgumentException a été levée")
    public void uneExceptionIllegalArgumentExceptionAÉtéLevée() {
        RuntimeException exception = gestionExceptions.getPremiereException();
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
}
