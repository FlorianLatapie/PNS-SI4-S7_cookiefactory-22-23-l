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

    private GestionnaireDeCuisiniers gestionnaireDeCuisiniers;

    // --- Constructeurs ---
    public Magasin() {
        this("", new Stock());
    }

    public Magasin(String nom, Stock stock) {
        this.nom = nom;
        this.stock = stock;

        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.gestionnaireDeCuisiniers = new GestionnaireDeCuisiniers(this);
        this.recettesDuMagasin = new RecettesDuMagasin();
    }

    public Magasin(Integer taxe) {
        this("", new Stock());
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(Stock stock) {
        this("", stock);
    }

    public Magasin(Integer taxe, Stock stock) {
        this("", stock);
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(String nom, double valeurTaxe, String lieu, ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        this(nom, new Stock());
        this.valeurTaxe = valeurTaxe;
        this.lieu = lieu;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
    }

    // ------------------------------------------------------------------------

    public Prix ajouterTaxe(Prix p) {
        double prix = p.getPrixEnCentimes();
        double prixAvecTaxe = prix * (1 + valeurTaxe);
        return new Prix((int) prixAvecTaxe);
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
        return gestionnaireDeCuisiniers;
    }

    public ZonedDateTime geHeureOuverture() {
        return dateOuverture;
    }

    public ZonedDateTime getHeureFermeture() {
        return dateFermeture;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Magasin magasin) {
            return this.getNom().equals(magasin.getNom());
        }
        return false;
    }

    public ZonedDateTime getDate() {
        return null;//ICI
    }
}
