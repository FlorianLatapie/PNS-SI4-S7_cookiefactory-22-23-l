package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PasAssezCookies;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import io.cucumber.java.fr.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CommanderStepdef {
    private Invite invite;
    private Cookie cookie;
    private Commande commande;

    @Etantdonné("un invité nommé {string} {string} avec pour adresse mail {string} et pour numéro du téléphone {string}")
    public void unInvitéNomméAvecPourAdresseMailEtPourNuméroDuTéléphone(String prenom, String nom, String mail, String numTel) {
        invite = new Invite(prenom, nom, mail, numTel);
        commande = new Commande(invite);
    }

    @Et("un cookie nommé {string}")
    public void unCookieNomméDUnPrixDe€(String nomCookie) {
        cookie = BaseDeDonnees.getInstance().getBdCookie().getCookieParNom(nomCookie);
    }

    @Quand("l'invité ajoute {int} cookie à son panier")
    public void lInvitéAjouteCookieÀSonPanier(int nb) {
        commande.getPanier().ajouterCookies(cookie, nb);
    }

    @Alors("il y a {int} cookie dans son panier")
    public void ilYACookieDansSonPanier(int nb) {
        int nbCookie = commande.getPanier().getNbCookies();
        assertEquals(nb, nbCookie);
    }

    @Quand("l'invité retire {int} cookie à son panier")
    public void lInvitéRetireUnCookieÀSonPanier(int nb) {
        commande.getPanier().supprimerCookies(cookie, nb);
    }

    @Alors("il y a {int} cookies dans son panier")
    public void ilYACookiesDansSonPanier(int nbCookie) {
        assertEquals(nbCookie, commande.getPanier().getNbCookies());
    }

    @Quand("l'invité accède au prix de son panier")
    public void lInvitéAccèdeAuPrixDeSonPanier() {
    }

    @Alors("son panier possède un montant de {double} €")
    public void sonPanierPossèdeUnMontantDe€(double prix) {
        Prix prix2 = new Prix((int) (prix * 100));
        assertEquals(prix2, commande.getPrix());
    }

    @Quand("l'invité retire {int} cookie à son panier \\(erreur)")
    public void lInvitéRetireCookieÀSonPanierErreur(int nb) {
        assertThrows(PasAssezCookies.class, () -> lInvitéRetireUnCookieÀSonPanier(nb));
    }

    @Alors("une erreur PasAssezCookie intervient")
    public void uneErreurPasAssezCookieIntervient() {
    }
}
