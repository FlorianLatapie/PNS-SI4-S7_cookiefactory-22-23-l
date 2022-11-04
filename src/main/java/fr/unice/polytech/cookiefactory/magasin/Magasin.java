package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.Date;
import java.util.List;

public class Magasin {
    private double valeurTaxe;
    private String lieu;
    private Date dateOuverture;
    private Date dateFermeture;

    private List<RecettesDuMagasin> recettesDuMagasin;
    private Stock stock;
    private ChaineDeMagasins chaineDeMagasins;
    private GestionnaireDeCommandes gestionnaireDeCommandes;

    public GestionnaireDeCuisiniers getGestionnaireDeCuisiniers() {
        return gestionnaireDeCuisinier;
    }

    private GestionnaireDeCuisiniers gestionnaireDeCuisinier;

    public Magasin(Stock stock) {
        this.stock = stock;
    }
    public Magasin(){
        gestionnaireDeCommandes = new GestionnaireDeCommandes();
        gestionnaireDeCuisinier = new GestionnaireDeCuisiniers();
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
}
