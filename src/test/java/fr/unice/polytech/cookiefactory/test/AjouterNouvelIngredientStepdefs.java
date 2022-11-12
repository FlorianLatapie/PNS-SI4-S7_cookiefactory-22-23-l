package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.Assert.*;

public class AjouterNouvelIngredientStepdefs {

    private Saveur saveur;
    private String nom;
    @Etantdonné("une saveur {string}")
    public void uneSaveur(String nomSaveur) {
        nom = nomSaveur;
        saveur = new Saveur(nomSaveur);
    }

    @Quand("j'ajoute le nouvel ingrédient")
    public void jAjouteLeNouvelIngrédient() {
        ChaineDeMagasins.getInstance().getBd().getBdIngredient().ajouterSaveur(saveur);
    }

    @Alors("l'ingrédient est ajouté à la liste des ingrédients disponibles")
    public void lIngrédientEstAjoutéÀLaListeDesIngrédientsDisponibles() {
        assertNotNull(ChaineDeMagasins.getInstance().getBd().getBdIngredient().getIngredient(nom));
    }

    @Etantdonné("l'ingrédient est présent dans la liste des ingrédients disponibles")
    public void lIngrédientEstPrésentDansLaListeDesIngrédientsDisponibles() {
        jAjouteLeNouvelIngrédient();
    }

    @Quand("je retire l'ingrédient")
    public void jeRetireLIngrédient() {
        ChaineDeMagasins.getInstance().getBd().getBdIngredient().retirerSaveur(saveur);
    }

    @Alors("l'ingrédient est retiré à la liste des ingrédients disponibles")
    public void lIngrédientEstRetiréÀLaListeDesIngrédientsDisponibles() {
        try{
            ChaineDeMagasins.getInstance().getBd().getBdIngredient().getIngredient(nom);
            fail();
        } catch (IllegalArgumentException e){
           assertTrue(true);
        }
    }
}
