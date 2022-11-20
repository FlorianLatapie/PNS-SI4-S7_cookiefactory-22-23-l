package fr.unice.polytech.cookiefactory.test.commande.panier;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.recette.cookie.CookieFestif;
import fr.unice.polytech.cookiefactory.recette.cookie.factory.SimpleCookieFestifFactory;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import static org.junit.jupiter.api.Assertions.*;

public class AjouterDesCookiesFestifsAuPanierStepdefs {
    private Invite invite;
    private Commande commande;
    private CookieFestif cookieFestif;

    @Etantdonné("un invité \\(cookieFestif)")
    public void unInvitéCookieFestif() {
        invite = new Invite();
        commande = new Commande(invite);
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
}
