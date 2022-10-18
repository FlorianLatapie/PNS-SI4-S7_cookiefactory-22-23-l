package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommanderStepdef {
    private Invite invite;
    private Cookie cookie;
    private Commande panier = new Commande();

    @Etantdonné("un invité nommé {string} {string} avec pour adresse mail {string} et pour numéro du téléphone {string}")
    public void unInvitéNomméAvecPourAdresseMailEtPourNuméroDuTéléphone(String prenom, String nom, String mail, String numTel) {
        invite = new Invite(prenom, nom, mail, numTel);
    }

    @Et("un cookie nommé {string}")
    public void unCookieNomméDUnPrixDe€(String nomCookie) {
        cookie = BaseDeDonnees.getInstance().getBdCookie().getCookieParNom(nomCookie);
    }

    @Quand("l'invité ajoute {int} cookie à son panier")
    public void lInvitéAjouteCookieÀSonPanier(int arg0) {
        for (int i = 0; i < arg0; i++) {
            panier.ajouterCookie(cookie);
        }
    }

    @Alors("il y a {int} cookie dans son panier")
    public void ilYACookieDansSonPanier(int nb) {
        assertTrue(panier.getCookies().contains(cookie));

        int nbCookie = (int) panier.getCookies().stream().filter(c -> c.equals(cookie)).count();
        assertEquals(nb, nbCookie);
    }

    @Quand("l'invité retire {int} cookie à son panier")
    public void lInvitéRetireUnCookieÀSonPanier(int nb) {
        for (int i = 0; i < nb; i++) {
            panier.getCookies().remove(cookie);
        }
    }

    @Alors("il y a {int} cookies dans son panier")
    public void ilYACookiesDansSonPanier(int nbCookie) {
        assertEquals(nbCookie, panier.getCookies().size());
    }

    @Quand("l'invité accède au prix de son panier")
    public void lInvitéAccèdeAuPrixDeSonPanier() {
    }

    @Alors("son panier possède un montant de {double} €")
    public void sonPanierPossèdeUnMontantDe€(double prix) {
        Prix prix2 = new Prix((int) (prix * 100));
        assertEquals(panier.getPrix(), prix2);
    }
}
