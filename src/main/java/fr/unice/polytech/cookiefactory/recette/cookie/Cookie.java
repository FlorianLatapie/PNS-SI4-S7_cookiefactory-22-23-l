package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;

public class Cookie {
    private Recette recette;
    private Prix prix;
    private ValidationCookie etat;

    public Cookie(Recette recette) {
        this.recette = recette;
        this.etat = ValidationCookie.SOUMIS;
    }

    public Cookie(Recette recette, ValidationCookie etat) {
        this.recette = recette;
        this.etat = etat;
    }

    public Cookie(Recette recette, ValidationCookie etat, Prix prix) {
        this.recette = recette;
        this.etat = etat;
        this.prix = prix;
    }

    public Cookie(Prix prix) {
        this.prix = prix;
    }

    public Recette getRecette() {
        return this.recette;
    }

    public Prix getPrixHorsTaxe() {
        return this.prix;
    }

    public ValidationCookie getEtat() {
        return this.etat;
    }

    public void changerEtat(ValidationCookie etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Cookie{}";
    }
}
