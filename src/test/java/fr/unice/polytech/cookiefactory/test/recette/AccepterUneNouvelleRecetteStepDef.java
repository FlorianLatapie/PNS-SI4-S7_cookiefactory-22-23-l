package fr.unice.polytech.cookiefactory.test.recette;

import fr.unice.polytech.cookiefactory.acteur.employe.management.Dirigeant;
import fr.unice.polytech.cookiefactory.bd.BDCookie;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AccepterUneNouvelleRecetteStepDef {
    Dirigeant dirigeant;
    ChaineDeMagasins chaineDeMagasins = ChaineDeMagasins.getInstance();
    final BDCookie bdCookie = chaineDeMagasins.getBd().getBdCookie();
    Magasin magasin;
    Cuisinier cuisinier;
    Cookie cookie;
    String nom;
    String pate;
    String saveur;
    String garniture1;
    String cuisson;
    String melange;
    int temps;

    @Étantdonné("un Dirigent")
    public void un_dirigent() {
        dirigeant = new Dirigeant("Jean", "Dupont", "jean_dupont@gmail.com", "1234567890", "secret");
    }

    @Étantdonné("un cookie {string}")
    public void un_cookie(String string) {
        nom = string;
    }

    @Étantdonné("avec une {string}")
    public void avec_une(String string) {
        pate = string;
    }

    @Étantdonné("de {string}")
    public void de(String string) {
        saveur = string;
    }

    @Étantdonné("avec les garnitures : {string}")
    public void avec_les_garnitures(String string) {
        garniture1 = string;
    }

    @Étantdonné("une {string}")
    public void une(String string) {
        cuisson = string;
    }

    @Étantdonné("un {string}")
    public void un(String string) {
        melange = string;
    }

    @Étantdonné("un {int} s de préparation")
    public void un_s_de_préparation(Integer int1) {
        temps = int1;
        cookie = new Cookie(nom,
                new Recette()
                        .setPate(pate)
                        .setSaveur(saveur)
                        .setGarnitures(List.of(garniture1))
                        .setCuisson(cuisson)
                        .setMelange(melange)
                        .setTempsPreparation(temps)
        );
    }

    @Étantdonné("un cuisinier qui a soumis un cookie")
    public void un_cuisinier_qui_a_soumis_un_cookie() {
        chaineDeMagasins = ChaineDeMagasins.getInstance();
        magasin = chaineDeMagasins.getAllMagasins().get(0);
        cuisinier = new Cuisinier(magasin.getGestionnaireDeCommandes());
        cuisinier.soumettreUnCookie(cookie);
    }

    @Quand("le Dirigent regarde les cookies en attente de validation")
    public void le_dirigent_regarde_les_cookies_en_attente_de_validation() {
        assertTrue(bdCookie.getCookiesEnAttente().contains(cookie));
    }

    @Alors("le Dirigent valide le cookie {string}")
    public void le_dirigent_valide_le_cookie(String string) {
        bdCookie.validerCookie(string);
    }
}
