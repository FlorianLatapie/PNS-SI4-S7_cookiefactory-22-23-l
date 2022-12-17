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

    public Recette() {
        Pate pate = new Pate("Nature");
        Saveur saveur = new Saveur("Nature");
        ArrayList<Garniture> garniture = new ArrayList<>();
        this.quantitePate = new QuantiteIngredient<>(pate, 0);
        this.quantiteSaveur = new QuantiteIngredient<>(saveur, 0);
        this.quantiteGarnitures = new QuantiteIngredient<>(garniture, 0);
        this.cuisson = Cuisson.MOELLEUX;
        this.melange = Melange.MIXTE;
        this.tempsPreparation = 15;
    }

    public Recette setPate(String nomPate, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getPate(nomPate).isEmpty()) {
            throw new IllegalArgumentException("La pate n'existe pas");
        }
        Pate pate = new Pate(nomPate);
        this.quantitePate = new QuantiteIngredient<>(pate, quantite);
        return this;
    }

    public Recette setPate(Pate pate, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getPate(pate).isEmpty()) {
            throw new IllegalArgumentException("La pate n'existe pas");
        }
        this.quantitePate = new QuantiteIngredient<>(pate, quantite);
        return this;
    }

    public Recette setSaveur(String nomSaveur, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getSaveur(nomSaveur).isEmpty()) {
            throw new IllegalArgumentException("La saveur n'existe pas");
        }
        Saveur saveur = new Saveur(nomSaveur);
        this.quantiteSaveur = new QuantiteIngredient<>(saveur, quantite);
        return this;
    }

    public Recette setSaveur(Saveur saveur, int quantite) {
        if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getSaveur(saveur).isEmpty()) {
            throw new IllegalArgumentException("La saveur n'existe pas");
        }
        this.quantiteSaveur = new QuantiteIngredient<>(saveur, quantite);
        return this;
    }

    public Recette setGarnitures(List<String> nomsGarnitures, int quantite) {
        ArrayList<Garniture> garnitures = new ArrayList<>();
        for (String nomGarniture : nomsGarnitures) {
            if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getGarniture(nomGarniture).isEmpty()) {
                throw new IllegalArgumentException("La garniture n'existe pas");
            }
            garnitures.add(new Garniture(nomGarniture));
        }
        this.quantiteGarnitures = new QuantiteIngredient<>(garnitures, quantite);
        return this;
    }

    public Recette setGarnituresWithGarniture(List<Garniture> garnitures, int quantite) {
        for (Garniture garniture : garnitures) {
            if (ChaineDeMagasins.getInstance().getBd().getBdIngredient().getGarniture(garniture).isEmpty()) {
                throw new IllegalArgumentException("La garniture n'existe pas");
            }
        }
        this.quantiteGarnitures = new QuantiteIngredient<>(garnitures, quantite);
        return this;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(List.of(quantitePate.getIngredient(), quantiteSaveur.getIngredient()));
        ingredients.addAll(quantiteGarnitures.getIngredient());
        return ingredients;
    }

    public int getQuantiteTotale() {
        return quantiteGarnitures.getQuantite() + quantiteSaveur.getQuantite() + quantitePate.getQuantite();
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

    public Recette setCuisson(String cuisson) {
        switch (cuisson) {
            case "CROQUANT" -> this.cuisson = Cuisson.CROQUANT;
            case "MOELLEUX" -> this.cuisson = Cuisson.MOELLEUX;
            default -> throw new IllegalArgumentException("La cuisson n'existe pas");
        }
        return this;
    }

    public Melange getMelange() {
        return melange;
    }

    public Recette setMelange(String melange) {
        switch (melange) {
            case "MIXTE" -> this.melange = Melange.MIXTE;
            case "GARNI" -> this.melange = Melange.GARNI;
            default -> throw new IllegalArgumentException("Le melange n'existe pas");
        }
        return this;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void modifierQuantitePate(int quantite) {
        this.quantitePate.setQuantite(quantite);
    }

    public void modifierQuantiteGarnitures(int quantite) {
        this.quantiteGarnitures.setQuantite(quantite);
    }

    public void modifierQuantiteSaveur(int quantite) {
        this.quantiteSaveur.setQuantite(quantite);
    }

    public void multiplierQuantitePate(int multiplicateur) {
        modifierQuantitePate(this.quantitePate.getQuantite() * multiplicateur);
    }

    public void multiplierQuantiteGarnitures(int multiplicateur) {
        this.quantiteGarnitures.setQuantite(this.quantiteGarnitures.getQuantite() * multiplicateur);
    }

    public void multiplierQuantiteSaveur(int multiplicateur) {
        this.quantiteSaveur.setQuantite(this.quantiteSaveur.getQuantite() * multiplicateur);
    }

    public Recette setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
        return this;
    }

    public Integer getQuantite(Ingredient ingredient) {
        if (getIngredients().contains(ingredient)) {
            switch (ingredient.getClass().getSimpleName()) {
                case "Pate" -> {
                    return quantitePate.getQuantite();
                }
                case "Saveur" -> {
                    return quantiteSaveur.getQuantite();
                }
                case "Garniture" -> {
                    return quantiteGarnitures.getQuantite();
                }
            }
        }
        throw new IllegalArgumentException("L'ingredient n'est pas dans la recette");
    }
}
