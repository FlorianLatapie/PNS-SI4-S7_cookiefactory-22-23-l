package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.ArrayList;
import java.util.List;

public class Recette {
    Pate pate;
    Saveur saveur;
    List<Garniture> garnitures;
    Cuisson cuisson;
    Melange melange;
    int tempsPreparation;

    public Recette(){
        pate = new Pate("Nature");
        saveur = new Saveur("Nature");
        garnitures = new ArrayList<>();
        cuisson = Cuisson.MOELLEUX;
        melange = Melange.MIXTE;
        tempsPreparation = 15;
    }

    public Recette setPate(String pate) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getPate(pate).isEmpty()){
            throw new IllegalArgumentException("La pate n'existe pas");
        }
        this.pate = new Pate(pate);
        return this;
    }

    public Recette setSaveur(String saveur) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getSaveur(saveur).isEmpty()){
            throw new IllegalArgumentException("La saveur n'existe pas");
        }
        this.saveur = new Saveur(saveur);
        return this;
    }

    public Recette setGarnitures(List<String> garnitures) {
        for (String garniture : garnitures) {
            if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getGarniture(garniture).isEmpty()){
                throw new IllegalArgumentException("La garniture n'existe pas");
            }
            this.garnitures.add(new Garniture(garniture));
        }
        return this;
    }

    public Recette setCuisson(String cuisson) {
        if (cuisson.equals("CROQUANT")){
            this.cuisson = Cuisson.CROQUANT;
        } else if (cuisson.equals("MOELLEUX")){
            this.cuisson = Cuisson.MOELLEUX;
        } else {
            throw new IllegalArgumentException("La cuisson n'existe pas");
        }
        return this;
    }

    public Recette setMelange(String melange) {
        if (melange.equals("MIXTE")){
            this.melange = Melange.MIXTE;
        } else if (melange.equals("GARNI")){
            this.melange = Melange.GARNI;
        } else {
            throw new IllegalArgumentException("Le melange n'existe pas");
        }
        return this;
    }

    public Recette setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
        return this;
    }


    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new java.util.ArrayList<>(List.of(pate, saveur));
        ingredients.addAll(garnitures);
        return ingredients;
    }

    public Pate getPate() {
        return pate;
    }

    public Saveur getSaveur() {
        return saveur;
    }

    public List<Garniture> getGarnitures() {
        return garnitures;
    }

    public Cuisson getCuisson() {
        return cuisson;
    }

    public Melange getMelange() {
        return melange;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }
}
