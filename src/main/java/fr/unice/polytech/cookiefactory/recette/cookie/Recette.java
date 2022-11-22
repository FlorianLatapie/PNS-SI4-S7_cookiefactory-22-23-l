package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.ingredient.*;

import java.util.ArrayList;
import java.util.List;

public class Recette {
    QuantiteIngredient<Pate, Integer> quantitePate;
    QuantiteIngredient<Saveur, Integer> quantiteSaveur;
    QuantiteIngredient<List<Garniture>, Integer> quantiteGarnitures;
    Cuisson cuisson;
    Melange melange;
    int tempsPreparation;

    public Recette(){
        Pate pate = new Pate("Nature");
        Saveur saveur = new Saveur("Nature");
        ArrayList<Garniture> garniture = new ArrayList<>();
        quantitePate = new QuantiteIngredient<>(pate, 0);
        quantiteSaveur = new QuantiteIngredient<>(saveur, 0);
        quantiteGarnitures = new QuantiteIngredient<>(garniture, 0);
        cuisson = Cuisson.MOELLEUX;
        melange = Melange.MIXTE;
        tempsPreparation = 15;
    }

    public Recette setPate(String nomPate, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getPate(nomPate).isEmpty()){
            throw new IllegalArgumentException("La pate n'existe pas");
        }
        Pate pate = new Pate(nomPate);
        this.quantitePate = new QuantiteIngredient<>(pate, quantite);
        return this;
    }

    public Recette setSaveur(String nomSaveur, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getSaveur(nomSaveur).isEmpty()){
            throw new IllegalArgumentException("La saveur n'existe pas");
        }
        Saveur saveur = new Saveur(nomSaveur);
        this.quantiteSaveur = new QuantiteIngredient<>(saveur, quantite);
        return this;
    }

    public Recette setGarnitures(List<String> nomsGarnitures, int quantite) {
        ArrayList<Garniture> garnitures = new ArrayList<>();
        for (String nomGarniture : nomsGarnitures) {
            if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getGarniture(nomGarniture).isEmpty()){
                throw new IllegalArgumentException("La garniture n'existe pas");
            }
            garnitures.add(new Garniture(nomGarniture));
        }
        this.quantiteGarnitures = new QuantiteIngredient<>(garnitures, quantite);
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
        List<Ingredient> ingredients = new java.util.ArrayList<>(List.of(quantitePate.getIngredient(), quantiteSaveur.getIngredient()));
        ingredients.addAll(quantiteGarnitures.getIngredient());
        return ingredients;
    }

    public QuantiteIngredient<Pate, Integer> getQuantitePate() {
        return quantitePate;
    }

    public QuantiteIngredient<Saveur, Integer> getQuantiteSaveur() {
        return quantiteSaveur;
    }

    public QuantiteIngredient<List<Garniture>, Integer> getQuantiteGarnitures() {
        return quantiteGarnitures;
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
