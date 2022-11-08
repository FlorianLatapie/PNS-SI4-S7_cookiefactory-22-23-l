package fr.unice.polytech.cookiefactory.recette.ingredient;

import fr.unice.polytech.cookiefactory.divers.Prix;

public class Pate extends Ingredient {
    public Pate(String nom){
        this(nom, new Prix(10), 1);
    }

    public Pate(String nom, Prix prix, int quantite) {
        super(nom, prix, quantite);
    }
}
