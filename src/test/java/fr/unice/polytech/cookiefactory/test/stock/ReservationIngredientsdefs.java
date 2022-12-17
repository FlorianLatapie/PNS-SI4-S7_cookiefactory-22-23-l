package fr.unice.polytech.cookiefactory.test.stock;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonnée;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReservationIngredientsdefs {
    private Cookie cookie;
    private Commande commande;
    private Magasin magasin;

    private Garniture ingredient3;

    @Etantdonné("un cookie nommé {string} composé de Chocolat")
    public void unCookieNomméComposéDUnIngrédient(String nomCookie) {
        cookie = ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookieParNom(nomCookie);
    }

    @Étantdonnée("un stock contenant {int} pâte {string}, {int} {string}, {int} {string}, {int} {string}")
    public void un_stock_contenant(int nbIngredient1, String nomIngredient1, int nbIngredient2, String nomIngredient2, int nbIngredient3, String nomIngredient3, int nbIngredient4, String nomIngredient4) {
        magasin = new Magasin();
        Pate ingredient1 = new Pate(nomIngredient1);
        Saveur ingredient2 = new Saveur(nomIngredient2);
        ingredient3 = new Garniture(nomIngredient3);
        var ingredient4 = new Garniture(nomIngredient4);
        magasin.getStock().ajouterIngredient(ingredient1, nbIngredient1);
        magasin.getStock().ajouterIngredient(ingredient2, nbIngredient2);
        magasin.getStock().ajouterIngredient(ingredient3, nbIngredient3);
        magasin.getStock().ajouterIngredient(ingredient4, nbIngredient4);
        System.out.println(magasin.getStock());
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
        assertEquals(nbIngredient, (int) magasin.getStock().getQuantite(ingredient3));
    }

}
