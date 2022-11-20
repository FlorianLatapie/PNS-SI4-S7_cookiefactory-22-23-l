package fr.unice.polytech.cookiefactory.test.commande.panier;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.magasin.factory.SimpleMagasinFactory;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.CookieFestif;
import fr.unice.polytech.cookiefactory.recette.cookie.factory.SimpleCookieFestifFactory;
import fr.unice.polytech.cookiefactory.recette.enums.Taille;
import io.cucumber.java.fr.*;

import static org.junit.jupiter.api.Assertions.*;

public class AjouterDesCookiesFestifsAuPanierStepdefs {
    private Invite invite;
    private Commande commande;
    private CookieFestif cookieFestif;

    private Magasin magasin;

    @Etantdonné("un invité \\(cookieFestif)")
    public void unInvitéCookieFestif() {
        invite = new Invite();
        commande = new Commande(magasin, invite);
    }

    @Soit("un cookie festif se nommant {string}.")
    public void unCookieFestifSeNommant(String nomCookie) {
        cookieFestif = new SimpleCookieFestifFactory().creerCookieFestif(nomCookie);
    }

    @Quand("j'ajoute {int} cookies festifs au panier.")
    public void jAjouteLeCookieFestifAuPanier(int nbCookies) {
        commande.getPanier().ajouterCookies(cookieFestif, nbCookies);
    }

    @Alors("le panier contient {int} cookies festifs.")
    public void lePanierContientCookieFestif(int nbCookie) {
        assertEquals(nbCookie, commande.getPanier().getNbCookies());
    }

    @Et("un magasin avec une taxe de {double}")
    public void unMagasinCookieFestif(double taxe) {
        magasin = new SimpleMagasinFactory().setValeurTaxe(taxe).creerMagasin("Magasin");
    }

    @Quand("j'ajoute {int} cookies festifs de taille L au panier basés sur le cookie normal Pop-Choco.")
    public void jAjouteNbCookiesCookiesFestifsDeTailleLAuPanierBasésSurLeCookieNormal(int nbCookies) {
        Cookie cookie = ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookieParNom("Pop-Choco");
        commande.getPanier().ajouterCookies(new CookieFestif(cookie, Taille.L), nbCookies);
    }

    @Et("le prix du panier hors taxes est de {double} euros.")
    public void lePrixDuPanierHorsTaxesEstDePrixHTEuros(double prixHT) {
        assertEquals(Prix.convertir(prixHT), commande.getPrixHorsTaxe());
    }

    @Et("le prix de la commande est de {double} euros.")
    public void lePrixDeLaCommandeEstDePrixTTCEuros(double prixTTC) {
        assertEquals(Prix.convertir(prixTTC), commande.getPrixAvecTaxe());
    }
}
