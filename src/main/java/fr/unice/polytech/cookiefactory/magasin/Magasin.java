package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.Date;
import java.util.List;

public class Magasin {
    private String nom;
    private double valeurTaxe = 0.2;
    private String lieu;
    private Date dateOuverture;
    private Date dateFermeture;

    private RecettesDuMagasin recettesDuMagasin;
    private Stock stock;
    private ChaineDeMagasins chaineDeMagasins;
    private GestionnaireDeCommandes gestionnaireDeCommandes;

    public GestionnaireDeCuisiniers getGestionnaireDeCuisiniers() {
        return gestionnaireDeCuisinier;
    }

    private GestionnaireDeCuisiniers gestionnaireDeCuisinier;

    public Magasin(double valeurTaxe, Stock stock) {
        this.valeurTaxe = valeurTaxe;
        this.stock = stock;
        this.nom = "";
    }

    public Magasin(double valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.recettesDuMagasin = new RecettesDuMagasin();
        this.gestionnaireDeCuisinier = new GestionnaireDeCuisiniers(this);
        this.stock = new Stock();
        this.nom = "";
    }

    public Magasin(Stock stock) {
        gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        gestionnaireDeCuisinier = new GestionnaireDeCuisiniers(this);
        recettesDuMagasin = new RecettesDuMagasin();
        this.stock = stock;
        this.nom = "";
    }

    public Magasin() {
        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.recettesDuMagasin = new RecettesDuMagasin();
        this.gestionnaireDeCuisinier = new GestionnaireDeCuisiniers(this);
        this.stock = new Stock();
        this.nom = "";
    }

    public Magasin(String nom) {
        this.nom = nom;
    }

    public double ajouterTaxe(double valeur) {
        return valeur * (1 - valeurTaxe);
    }

    public void soumettreUnNouveauCookie(Cookie cookie) {
        recettesDuMagasin.soumettreUnCookie(cookie);
    }

    public void ajouterIngredient(Ingredient ingredient) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void retirerIngredient(Ingredient ingredient) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Cookie> recupererCookiesDuMagasin() {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Stock getStock() {
        return stock;
    }

    public RecettesDuMagasin getRecettesDuMagasin() {
        return recettesDuMagasin;
    }

    public GestionnaireDeCommandes getGestionnaireDeCommandes() {
        return gestionnaireDeCommandes;
    }

    public double getValeurTaxe() {
        return valeurTaxe;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Magasin magasin) {
            return this.getNom().equals(magasin.getNom());
        }
        return false;
    }
}
