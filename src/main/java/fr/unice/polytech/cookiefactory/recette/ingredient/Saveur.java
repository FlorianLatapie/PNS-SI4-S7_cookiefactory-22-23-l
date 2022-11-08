package fr.unice.polytech.cookiefactory.recette.ingredient;

import fr.unice.polytech.cookiefactory.divers.Prix;

public class Saveur extends Ingredient {
    public Saveur(String nom){
        this(nom, new Prix(10), 1);
    }
    public Saveur(String nom, Prix prix, int quantite) {
        super(nom, prix, quantite);
    }
}
