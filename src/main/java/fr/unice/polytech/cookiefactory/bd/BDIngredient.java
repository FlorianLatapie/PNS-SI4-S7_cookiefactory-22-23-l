package fr.unice.polytech.cookiefactory.bd;

import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class BDIngredient {
    private final HashSet<Garniture> garnitures;
    private final HashSet<Pate> pates;
    private final HashSet<Saveur> saveurs;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    BDIngredient() {
        pates = new HashSet<>();
        saveurs = new HashSet<>();
        garnitures = new HashSet<>();
        init();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    private void init() {
        pates.addAll(List.of(
                new Pate("Nature"),
                new Pate("Chocolat"),
                new Pate("Beurre de cacahuette"),
                new Pate("Caramel"),
                new Pate("Chocolat blanc")

        ));
        saveurs.addAll(List.of(
                new Saveur("Nature"),//
                new Saveur("Chocolat"),//
                new Saveur("Chocolat noir"),//
                new Saveur("Chocolat blanc"),//
                new Saveur("Chocolat au lait"),//
                new Saveur("Amande"),//
                new Saveur("Pistache"),//
                new Saveur("Fraise"),//
                new Saveur("Caramel"),//
                new Saveur("Noisette"),//
                new Saveur("Vanille"),
                new Saveur("Cannelle")//

        ));
        garnitures.addAll(List.of(
                new Garniture("Chocolat"),
                new Garniture("Chocolat blanc"),
                new Garniture("Chocolat noir"),
                new Garniture("Chocolat au lait"),
                new Garniture("Pépite de chocolat"),
                new Garniture("Pépite de chocolat blanc"),
                new Garniture("Pépite de chocolat noir"),
                new Garniture("Pépite de chocolat au lait"),
                new Garniture("Amande"),
                new Garniture("Pistache"),
                new Garniture("Caramel"),
                new Garniture("Fraise"),
                new Garniture("Noix de coco"),
                new Garniture("Menthe"),
                new Garniture("Cerise"),
                new Garniture("Chouchou"),
                new Garniture("M&M’s™")
        ));
    }

    public void initAUtiliserPourLesTests() {
        init();
    }

    public boolean contains(Ingredient ingredient) {
        return garnitures.contains(ingredient) || pates.contains(ingredient) || saveurs.contains(ingredient);
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

        System.err.println("je retire la saveur " + saveur);
        return saveurs.remove(saveur);
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(List.copyOf(garnitures));
        ingredients.addAll(pates);
        ingredients.addAll(saveurs);
        return ingredients;
    }

    public Ingredient getIngredient(String nom) {
        if (getGarniture(nom).isPresent()) return getGarniture(nom).get();
        if (getPate(nom).isPresent()) return getPate(nom).get();
        if (getSaveur(nom).isPresent()) return getSaveur(nom).get();
        throw new IllegalArgumentException("L'ingredient " + nom + " n'existe pas");
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public Optional<Saveur> getSaveur(String nom) {
        return saveurs.stream().filter(saveur -> saveur.getNom().equals(nom)).findFirst();
    }

    public Optional<Saveur> getSaveur(Saveur saveur) {
        return saveurs.stream().filter(saveur::equals).findFirst();
    }

    public List<Saveur> getSaveurs() {
        return List.copyOf(saveurs);
    }

    public Optional<Garniture> getGarniture(String nom) {
        return garnitures.stream().filter(garniture -> garniture.getNom().equals(nom)).findFirst();
    }

    public Optional<Garniture> getGarniture(Garniture garniture) {
        return garnitures.stream().filter(garniture::equals).findFirst();
    }

    public List<Garniture> getGarnitures() {
        return List.copyOf(garnitures);
    }

    public Optional<Pate> getPate(String nom) {
        return pates.stream().filter(pate -> pate.getNom().equals(nom)).findFirst();
    }

    public Optional<Pate> getPate(Pate pate) {
        return pates.stream().filter(p -> p.equals(pate)).findFirst();
    }

    public List<Pate> getPates() {
        return List.copyOf(pates);
    }
}
