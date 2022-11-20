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

    public SimpleCookieFactory() {
        BDIngredient ingredient = ChaineDeMagasins.getInstance().getBd().getBdIngredient();
        Pate pate = ingredient.getPate("Nature").get();
        Saveur saveur = ingredient.getSaveur("Amandes").get();
        Garniture garniture = ingredient.getGarniture("Chocolat noir").get();
        recette = new Recette(pate, saveur, List.of(garniture), Cuisson.MOELLEUX, Melange.GARNI, 10);
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public void setValidationCookie(ValidationCookie etat) {
        this.etat = etat;
    }

    public Cookie creerCookie(String nom) {
        return new Cookie(nom, recette, etat, prix);
    }
}
