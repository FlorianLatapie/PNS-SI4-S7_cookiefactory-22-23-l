package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.magasin.Stock;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;
import io.cucumber.java.fr.*;

import static org.junit.Assert.*;

public class ReservationIngredientsdefs {
    private Cookie cookie;
    private Commande commande;
    private Magasin magasin;
    private Ingredient ingredient;

    @Etantdonné("un cookie nommé {string} composé de Chocolat")
    public void unCookieNomméComposéDUnIngrédient(String nomCookie) {
        cookie = BaseDeDonnees.getInstance().getBdCookie().getCookieParNom(nomCookie);
    }

    @Et("un stock contenant {int} {string}")
    public void unStockContenant(int nbIngredient, String nomIngredient) {
        magasin = new Magasin(new Stock());
        ingredient = new Ingredient(nomIngredient);
        magasin.getStock().ajouterIngredient(ingredient, nbIngredient);
    }

    @Etantdonné("une commande contenant {int} cookies")
    public void uneCommandeContenantNbCookieCookie(int nbCookie) {
        commande = new Commande(magasin);
        commande.getPanier().ajouterCookies(cookie, nbCookie);
    }

    @Quand("la commande est validé par le système")
    public void laCommandeEstValidéParLeSystème() {
        commande.commandeConfirmee();
    }

    @Alors("le stock comporte {int} chocolats")
    public void leStockComporteNbChocolatChocolat(int nbIngredient) {
        assertEquals(nbIngredient, (int) magasin.getStock().getQuantite(ingredient));
    }

}
