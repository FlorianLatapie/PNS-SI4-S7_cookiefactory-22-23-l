package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisinier;
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
    private GestionnaireDeCuisinier gestionnaireDeCuisinier;


    public void ajouterIngredient(Ingredient ingredient) {
        // TODO implement here
    }

    public void retirerIngredient(Ingredient ingredient) {
        // TODO implement here
    }

    public List<Cookie> recupererCookiesDuMagasin() {
        // TODO implement here
        return null;
    }
}
