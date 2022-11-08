package fr.unice.polytech.cookiefactory.recette.ingredient;

import fr.unice.polytech.cookiefactory.divers.Prix;

import java.util.Objects;

public class Ingredient {
    private final String nom;
    private final Prix prix;
    private final int quantite;

    public Ingredient(String nom){
        this(nom, new Prix(10), 1);
    }
    public Ingredient(String nom, Prix prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public Prix getPrix() {
        return prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
