package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.time.ZonedDateTime;
import java.util.List;

public class Magasin {
    private final String nom;
    private double valeurTaxe = 0.2;
    private String lieu;
    private ZonedDateTime dateOuverture;
    private ZonedDateTime dateFermeture;

    private RecettesDuMagasin recettesDuMagasin;
    private Stock stock;
    private GestionnaireDeCommandes gestionnaireDeCommandes;

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

    public Magasin(String nom, double valeurTaxe, String lieu, ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        this.nom = nom;
        this.valeurTaxe = valeurTaxe;
        this.lieu = lieu;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
    }

    public Prix ajouterTaxe(Prix p){
        double prix = p.value();
        double prixAvecTaxe = prix * (1 + valeurTaxe);
        return new Prix((int) prixAvecTaxe * 100);
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

    public GestionnaireDeCuisiniers getGestionnaireDeCuisiniers() {
        return gestionnaireDeCuisinier;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Magasin magasin) {
            return this.getNom().equals(magasin.getNom());
        }
        return false;
    }
}
