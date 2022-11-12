package fr.unice.polytech.cookiefactory.test.recette;

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

public class SoumettreUnNouveauCookieStepDef {
    Magasin magasin;
    Cuisinier cuisinier;
    Cookie cookie;
    String nom;
    Pate pate;
    Saveur saveur;
    Garniture garniture1;
    Garniture garniture2;
    Cuisson cuisson;
    Melange melange;
    int temps;

    @Étantdonné("un cuisinier")
    public void un_cuisinier() {
        magasin = new Magasin();
        cuisinier = new Cuisinier(magasin.getGestionnaireDeCommandes());
        magasin.getGestionnaireDeCuisiniers().ajouterCuisinier(cuisinier);
    }

    @Étantdonné("un cookie de Nom : {string}")
    public void un_cookie_de_nom(String nom) {
        this.nom = nom;
    }

    @Étantdonné("avec une Pate : {string}")
    public void avec_une_pate(String pate) {
        this.pate = new Pate(pate);
    }

    @Étantdonné("de Saveur : {string}")
    public void de_saveur(String saveur) {
        this.saveur = new Saveur(saveur);
    }

    @Étantdonné("avec les garnitures {string} et {string}")
    public void avec_les_garnitures_et(String garniture1, String garniture2) {
        this.garniture1 = new Garniture(garniture1);
        this.garniture2 = new Garniture((garniture2));
    }

    @Étantdonné("une Cuisson : {string}")
    public void une_cuisson(String cuisson) {
        this.cuisson = Cuisson.valueOf(cuisson);
    }

    @Étantdonné("un Melange : {string}")
    public void un_melange(String melange) {
        this.melange = Melange.valueOf(melange);
    }

    @Étantdonné("un temps de préparation {int} s")
    public void un_temps_de_préparation_temps(int temps) {
        this.temps = temps;

        this.cookie = new Cookie(nom, new Recette(pate, saveur, List.of(garniture1, garniture2), cuisson, melange, temps));

    }

    @Quand("le gestionaire de cuisinier soumet un nouveau cookie")
    public void le_gestionaire_de_cuisinier_soumet_un_nouveau_cookie() {
        cuisinier.soumettreUnCookie(cookie);
    }

    @Alors("le cookie apparait dans la liste des cookies en attente de validation")
    public void le_cookie_apparait_dans_la_liste_des_cookies_en_attente_de_validation() {
        assertTrue(ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookiesEnAttente().contains(cookie));
    }

}
