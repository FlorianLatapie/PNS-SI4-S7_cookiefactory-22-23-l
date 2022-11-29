package fr.unice.polytech.cookiefactory.recette.cookie.factory;

import fr.unice.polytech.cookiefactory.bd.BDIngredient;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.List;

public class SimpleCookieFactory {

    protected Recette recette; // à modifier
    protected Prix prix = new Prix(300);
    protected ValidationCookie etat = ValidationCookie.VALIDE;

    /* --------------------------------------- Constructeurs --------------------------------------- */


    public SimpleCookieFactory() {
        recette = new Recette().setPate("Nature", 10).setSaveur("Amande", 10).setGarnitures(List.of("Chocolat noir"), 10).setCuisson("MOELLEUX").setMelange("GARNI").setTempsPreparation(10);
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public Cookie creerCookie(String nom) {
        return new Cookie(nom, recette, etat, prix);
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */
    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public void setValidationCookie(ValidationCookie etat) {
        this.etat = etat;
    }
}
