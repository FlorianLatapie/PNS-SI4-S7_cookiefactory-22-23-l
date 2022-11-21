package fr.unice.polytech.cookiefactory.test.cuisinier;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.ChefCookieFestif;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Occasions;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Themes;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevenirChefCookieFestif {
    Cuisinier chef;
    Magasin magasin;
    GestionnaireDeCommandes gestionnaireDeCommandes;
    ArrayList<Themes> themes = new ArrayList<>();
    ArrayList<Occasions> occasions = new ArrayList<>();

    @Etantdonné("un magasin sans chef cookie festif")
    public void un_magasin_sans_chef_cookie_festif() {
        magasin = new Magasin();
        gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
    }

    @Et("un cuisinier existant")
    public void un_cuisinier_existant() {
        chef = new Cuisinier(gestionnaireDeCommandes);
        magasin.getGestionnaireDeCuisiniers().ajouterCuisinier(chef);
    }

    @Etantdonné("un thème {string}")
    public void un_thème(String string) {
        themes.add(Themes.valueOf(string));
    }
    @Etantdonné("une occasion {string}")
    public void une_occasion(String string) {
        occasions.add(Occasions.valueOf(string));
    }
    @Alors("je veux devenir chef cookie festif")
    public void je_veux_devenir_chef_cookie_festif() {
        chef = magasin.getGestionnaireDeCuisiniers().devenirChefCookieFestif(chef, themes, occasions);
        assertTrue(chef instanceof ChefCookieFestif);
        assertTrue(magasin.possedeChefCookieFestif());
    }
}
