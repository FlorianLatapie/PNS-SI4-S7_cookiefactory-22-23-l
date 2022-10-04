package fr.unice.polytech.cookiefactory.cookie;

import fr.unice.polytech.cookiefactory.cookie.enums.Cuisson;
import fr.unice.polytech.cookiefactory.cookie.enums.Melange;
import fr.unice.polytech.cookiefactory.cookie.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.divers.Prix;

import java.util.ArrayList;

public class Cookie {

    private boolean disponible = false;
    private ValidationCookie validation = ValidationCookie.SOUMIS;
    private Prix prixHorsTaxe;
    private final Cuisson cuisson;
    private final Melange melange;
    private final Pate pate;
    private final Saveur saveur;
    private final ArrayList<Garniture> garniture;

    public Cookie(Prix prixHorsTaxe, Cuisson cuisson, Melange melange, Pate pate, Saveur saveur, ArrayList<Garniture> garniture) {
        this.prixHorsTaxe = prixHorsTaxe;
        this.cuisson = cuisson;
        this.melange = melange;
        this.pate = pate;
        this.saveur = saveur;
        this.garniture = new ArrayList<>(garniture);
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
