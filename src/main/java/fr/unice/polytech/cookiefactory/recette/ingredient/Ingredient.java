package fr.unice.polytech.cookiefactory.recette.ingredient;

import fr.unice.polytech.cookiefactory.divers.Prix;

public abstract class Ingredient {
    private final String nom;
    private final Prix prix;
    private int quantite;

    public Ingredient(String nom, Prix prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public Prix getPrix() {
        return prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public boolean estDisponible() {
        return quantite > 0;
    }

    public int ajouter(int quantite) {
        this.quantite += quantite;
        return this.quantite;
    }

    public boolean consommer(int quantite) {
        if (this.quantite >= quantite) {
            this.quantite -= quantite;
            return true;
        }
        return false;
    }
}
