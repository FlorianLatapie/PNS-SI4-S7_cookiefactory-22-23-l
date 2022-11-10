package fr.unice.polytech.cookiefactory.recette.ingredient;

import java.util.Objects;

public class Ingredient {
    private final String nom;

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
