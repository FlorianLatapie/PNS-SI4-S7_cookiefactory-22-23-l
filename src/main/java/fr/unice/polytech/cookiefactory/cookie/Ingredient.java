package fr.unice.polytech.cookiefactory.cookie;

public class Ingredient {
    private boolean disponible;
    String nom;

    public Ingredient(String nom, boolean disponible) {
        this.disponible = disponible;
        this.nom = nom;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNom() {
        return nom;
    }
}
