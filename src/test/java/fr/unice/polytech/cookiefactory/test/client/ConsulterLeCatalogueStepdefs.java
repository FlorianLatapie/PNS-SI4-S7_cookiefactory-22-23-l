package fr.unice.polytech.cookiefactory.test.client;

import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.bd.BDCookie;
import fr.unice.polytech.cookiefactory.bd.BDIngredient;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsulterLeCatalogueStepdefs {
    ChaineDeMagasins chaineDeMagasins = ChaineDeMagasins.getInstance();

    BDCookie bdCookie = chaineDeMagasins.getBd().getBdCookie();
    BDIngredient bdIngredient = chaineDeMagasins.getBd().getBdIngredient();

    Magasin magasin1 = chaineDeMagasins.getAllMagasins().get(0);
    Magasin magasin2 = chaineDeMagasins.getAllMagasins().get(1);
    Magasin magasin3 = chaineDeMagasins.getAllMagasins().get(2);
    Magasin magasin;

    Cookie cookie1;
    Cookie cookie2;
    Cookie cookie3;
    Cookie cookie4;
    Cookie cookie5;

    Client client;

    @Etantdonné("un invité qui veut onsulter le catalogue d'un magasin")
    public void un_invité_qui_veut_onsulter_le_catalogue_d_un_magasin() {
        client = new Client(new Invite());
        initBDCookies();
        initStocks();
    }
    @Quand("il veux consulter le catalogue du magasin {int}")
    public void il_veux_consulter_le_catalogue_du_magasin(Integer int1) {
        switch (int1) {
            case 1 -> magasin = magasin1;
            case 2 -> magasin = magasin2;
            case 3 -> magasin = magasin3;
        }
    }

    @Alors("l'invité peut voir {int} cookies")
    public void l_invité_peut_voir_cookies(Integer int1) {
        if (int1 == 5) {
            System.out.println(magasin.getCatalogue());
            assertEquals(5, magasin.getCatalogue().size());
            assertTrue(magasin.getCatalogue().containsKey("cookie1"));
            assertTrue(magasin.getCatalogue().containsKey("cookie2"));
            assertTrue(magasin.getCatalogue().containsKey("cookie3"));
            assertTrue(magasin.getCatalogue().containsKey("cookie4"));
            assertTrue(magasin.getCatalogue().containsKey("cookie5"));
        }
        else if (int1 == 2) {
            assertEquals(2, magasin.getCatalogue().size());
            assertTrue(magasin.getCatalogue().containsKey("cookie2"));
            assertTrue(magasin.getCatalogue().containsKey("cookie4"));
        }
        else{
            assertEquals(1, magasin.getCatalogue().size());
            assertTrue(magasin.getCatalogue().containsKey("cookie3"));
        }
    }

    private void initBDCookies() {
        bdIngredient.initAUtiliserPourLesTests();
        cookie1 = new Cookie(
                "cookie1",
                new Recette()
                        .setPate(bdIngredient.getPate("Nature").get(), 1)
                        .setSaveur(bdIngredient.getSaveur("Vanille").get(), 1)
                        .setGarnituresWithGarniture(List.of(bdIngredient.getGarniture("Amande").get()), 1)

        );


        cookie2= new Cookie(
                "cookie2",
                new Recette()
                        .setPate(bdIngredient.getPate("Chocolat").get(), 1)
                        .setSaveur(bdIngredient.getSaveur("Chocolat au lait").get(), 1)
                        .setGarnituresWithGarniture(List.of(bdIngredient.getGarniture("Pépite de chocolat au lait").get(), bdIngredient.getGarniture("Pépite de chocolat noir").get()), 1)

        );
        cookie3= new Cookie(
                "cookie3",
                new Recette()
                        .setPate(bdIngredient.getPate("Nature").get(), 1)
                        .setSaveur(bdIngredient.getSaveur("Nature").get(), 1)
        );
        cookie4= new Cookie(
                "cookie4",
                new Recette()
                        .setPate(bdIngredient.getPate("Caramel").get(), 1)
                        .setSaveur(bdIngredient.getSaveur("Caramel").get(), 1)
                        .setGarnituresWithGarniture(List.of(bdIngredient.getGarniture("Amande").get(), bdIngredient.getGarniture("Caramel").get()), 1)

        );
        cookie5= new Cookie(
                "cookie5",
                new Recette()
                        .setPate(bdIngredient.getPate("Nature").get(), 1)
                        .setSaveur(bdIngredient.getSaveur("Vanille").get(), 1)
                        .setGarnituresWithGarniture(List.of(bdIngredient.getGarniture("M&M’s™").get()), 1)

        );
            bdCookie.ajouterUnCookie(cookie1);
            bdCookie.ajouterUnCookie(cookie2);
            bdCookie.ajouterUnCookie(cookie3);
            bdCookie.ajouterUnCookie(cookie4);
            bdCookie.ajouterUnCookie(cookie5);

            bdCookie.validerCookie("cookie1");
            bdCookie.validerCookie("cookie2");
            bdCookie.validerCookie("cookie3");
            bdCookie.validerCookie("cookie4");
            bdCookie.validerCookie("cookie5");
        }

        private void initStocks() {
            magasin1.getStock().ajouterIngredient(new Pate("Nature"), 100);
            magasin1.getStock().ajouterIngredient(new Pate("Chocolat"), 100);
            magasin1.getStock().ajouterIngredient(new Pate("Caramel"), 100);
            magasin1.getStock().ajouterIngredient(new Saveur("Vanille"), 100);
            magasin1.getStock().ajouterIngredient(new Saveur("Chocolat au lait"), 100);
            magasin1.getStock().ajouterIngredient(new Saveur("Caramel"), 100);
            magasin1.getStock().ajouterIngredient(new Saveur("Nature"), 100);
            magasin1.getStock().ajouterIngredient(new Garniture("M&M’s™"), 100);
            magasin1.getStock().ajouterIngredient(new Garniture("Amande"), 100);
            magasin1.getStock().ajouterIngredient(new Garniture("Caramel"), 100);
            magasin1.getStock().ajouterIngredient(new Garniture("Pépite de chocolat au lait"), 100);
            magasin1.getStock().ajouterIngredient(new Garniture("Pépite de chocolat noir"), 100);

            magasin2.getStock().ajouterIngredient(new Pate("Chocolat"), 100);
            magasin2.getStock().ajouterIngredient(new Pate("Caramel"), 100);
            magasin2.getStock().ajouterIngredient(new Saveur("Vanille"), 100);
            magasin2.getStock().ajouterIngredient(new Saveur("Chocolat au lait"), 100);
            magasin2.getStock().ajouterIngredient(new Saveur("Caramel"), 100);
            magasin2.getStock().ajouterIngredient(new Saveur("Nature"), 100);
            magasin2.getStock().ajouterIngredient(new Garniture("M&M’s™"), 100);
            magasin2.getStock().ajouterIngredient(new Garniture("Amande"), 100);
            magasin2.getStock().ajouterIngredient(new Garniture("Caramel"), 100);
            magasin2.getStock().ajouterIngredient(new Garniture("Pépite de chocolat au lait"), 100);
            magasin2.getStock().ajouterIngredient(new Garniture("Pépite de chocolat noir"), 100);

            magasin3.getStock().ajouterIngredient(new Pate("Nature"), 100);
            magasin3.getStock().ajouterIngredient(new Pate("Chocolat"), 100);
            magasin3.getStock().ajouterIngredient(new Pate("Caramel"), 100);
            magasin3.getStock().ajouterIngredient(new Saveur("Chocolat au lait"), 100);
            magasin3.getStock().ajouterIngredient(new Saveur("Caramel"), 100);
            magasin3.getStock().ajouterIngredient(new Saveur("Nature"), 100);
            magasin3.getStock().ajouterIngredient(new Garniture("M&M’s™"), 100);
            magasin3.getStock().ajouterIngredient(new Garniture("Caramel"), 100);
            magasin3.getStock().ajouterIngredient(new Garniture("Pépite de chocolat noir"), 100);
        }
}
