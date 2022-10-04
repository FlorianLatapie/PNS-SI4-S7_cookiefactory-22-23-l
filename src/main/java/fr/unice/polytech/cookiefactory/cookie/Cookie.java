package fr.unice.polytech.cookiefactory.cookie;

import fr.unice.polytech.cookiefactory.cookie.enums.Cuisson;
import fr.unice.polytech.cookiefactory.cookie.enums.Melange;
import fr.unice.polytech.cookiefactory.cookie.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.ingredients.Garniture;
import fr.unice.polytech.cookiefactory.ingredients.Pate;
import fr.unice.polytech.cookiefactory.ingredients.Saveur;

import java.util.ArrayList;

public class Cookie {
    private boolean disponible = false;
    private int tempsPreparation;
    private Prix prixHorsTaxe;
    private ValidationCookie validation = ValidationCookie.SOUMIS;


    private final Melange melange;
    private final Cuisson cuisson;
    private final Saveur saveur;
    private final ArrayList<Garniture> garniture;
    private final Pate pate;

    public Cookie(Prix prixHorsTaxe, Cuisson cuisson, Melange melange, Pate pate, Saveur saveur, ArrayList<Garniture> garniture) {
        if (garniture.size() > 3){
            throw new IllegalArgumentException("Un cookie ne peut pas avoir plus de 3 garnitures");
        }
        this.prixHorsTaxe = prixHorsTaxe;
        this.cuisson = cuisson;
        this.melange = melange;
        this.pate = pate;
        this.saveur = saveur;
        this.garniture = garniture;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ValidationCookie getValidation() {
        return validation;
    }

    public void setValidation(ValidationCookie validation) {
        this.validation = validation;
    }

    public Prix getPrixHorsTaxe() {
        return prixHorsTaxe;
    }

    public void setPrixHorsTaxe(Prix prixHorsTaxe) {
        this.prixHorsTaxe = prixHorsTaxe;
    }

    public Cuisson getCuisson() {
        return cuisson;
    }

    public Melange getMelange() {
        return melange;
    }

    public Pate getPate() {
        return pate;
    }

    public Saveur getSaveur() {
        return saveur;
    }

    public ArrayList<Garniture> getGarniture() {
        return garniture;
    }
}
