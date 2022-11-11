package fr.unice.polytech.cookiefactory.bd;

import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.HashSet;

public class BDIngredient {
    private final HashSet<Garniture> garnitures;
    private final HashSet<Pate> pates;
    private final HashSet<Saveur> saveurs;
    BDIngredient() {
        garnitures = new HashSet<>();
        pates = new HashSet<>();
        saveurs = new HashSet<>();
        init();
    }

    public void ajouterGarniture(Garniture garniture) {
        garnitures.add(garniture);
    }

    public boolean retirerGarniture(Garniture garniture) {
        return garnitures.remove(garniture);
    }

    public void ajouterPate(Pate pate) {
        pates.add(pate);
    }

    public boolean retirerPate(Pate pate) {
        return pates.remove(pate);
    }

    public void ajouterSaveur(Saveur saveur) {
        saveurs.add(saveur);
    }

    public boolean retirerSaveur(Saveur saveur) {
        return saveurs.remove(saveur);
    }

    public Ingredient getIngredient(String nom) {
        Ingredient res;
        res = getGarniture(nom);
        if (res != null) return res;
        res = getPate(nom);
        if (res != null) return res;
        res = getSaveur(nom);
        return res;
    }

    public Saveur getSaveur(String nom) {
        return saveurs.stream().filter(saveur -> saveur.getNom().equals(nom)).findFirst().orElse(null);
    }

    public Garniture getGarniture(String nom) {
        return garnitures.stream().filter(garniture -> garniture.getNom().equals(nom)).findFirst().orElse(null);
    }

    public Pate getPate(String nom) {
        return pates.stream().filter(pate -> pate.getNom().equals(nom)).findFirst().orElse(null);
    }

    public void init() {

    }
}
