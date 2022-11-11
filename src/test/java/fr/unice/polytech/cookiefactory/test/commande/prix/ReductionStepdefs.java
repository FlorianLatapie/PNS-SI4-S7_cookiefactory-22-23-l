package fr.unice.polytech.cookiefactory.test.commande.prix;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Lorsque;

import static org.junit.Assert.assertEquals;

public class ReductionStepdefs {
    private Commande commande;
    private Cookie cookie;
    private Prix reduction;

    @Etantdonné("une commande composée de {int} cookies")
    public void uneCommandeComposéeDeNbCookieCookies(int nbCookie) {
        commande = new Commande();
        commande.getPanier().ajouterCookies(cookie, nbCookie);
    }

    @Lorsque("le système calcule le montant total de la commande")
    public void leSystèmeCalculeLeMontantTotalDeLaCommande() {
        reduction = commande.getPrixReduction();
    }

    @Etantdonné("un cookie nommé {string} \\(reduction)")
    public void unCookieNomméReduction(String nomCookie) {
        cookie = ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookieParNom(nomCookie);
    }

    @Alors("le prix est égal à {double} €")
    public void lePrixEstÉgalÀPrixTotalEuros(double prixReduction) {
        assertEquals(new Prix((int) (prixReduction * 100)), reduction);
    }
}
