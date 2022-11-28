package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;

public class Cookie {
    private final String nom;
    protected Recette recette;
    protected Prix prix;
    private ValidationCookie etat = ValidationCookie.VALIDE;

    public Cookie(String nom) {
        this.nom = nom;
    }

    public Cookie(String nom, Recette recette) {
        this(nom, recette, ValidationCookie.SOUMIS);
    }

    public Cookie(String nom, Recette recette, Prix prix) {
        this(nom, recette, ValidationCookie.SOUMIS, prix);
    }

    public Cookie(String nom, Recette recette, ValidationCookie etat) {
        this(nom, recette, etat, new Prix(100));
    }

    public Cookie(String nom, Recette recette, ValidationCookie etat, Prix prix) {
        this.nom = nom;
        this.recette = recette;
        this.etat = etat;
        this.prix = prix;
    }

    public Recette getRecette() {
        return this.recette;
    }

    public Prix getPrixHorsTaxe() {
        return this.prix != null ? this.prix : new Prix(10);
    }

    public String getNom() {
        return nom;
    }

    public ValidationCookie getEtat() {
        return this.etat;
    }

    public void changerEtat(ValidationCookie etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "nom='" + nom + '\'' +
                ", etat=" + etat +
                '}';
    }


}
