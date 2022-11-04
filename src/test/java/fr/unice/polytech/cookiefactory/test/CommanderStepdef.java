package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.exceptions.PasAssezCookies;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.*;

public class CommanderStepdef {
    private Invite invite;
    private Cookie cookie;
    private Commande commande;

    private final GestionExceptions gestionExceptions = new GestionExceptions();

    @Etantdonné("un invité")
    public void unInvitéNomméAvecPourAdresseMailEtPourNuméroDuTéléphone() {
        invite = new Invite();
        commande = new Commande(invite);
    }

    @Et("un cookie nommé {string}")
    public void unCookieNomméDUnPrixDe€(String nomCookie) {
        cookie = BaseDeDonnees.getInstance().getBdCookie().getCookieParNom(nomCookie);
    }

    @Quand("l'invité ajoute {int} cookies à son panier")
    public void lInvitéAjouteCookieÀSonPanier(int nb) {
        try {
            commande.getPanier().ajouterCookies(cookie, nb);
        } catch (RuntimeException exception){
            gestionExceptions.ajouteException(exception);
        }
    }

    @Alors("il y a {int} cookie dans son panier")
    public void ilYACookieDansSonPanier(int nb) {
        int nbCookie = commande.getPanier().getNbCookies();
        assertEquals(nb, nbCookie);
    }

    @Quand("l'invité retire {int} cookie à son panier")
    public void lInvitéRetireUnCookieÀSonPanier(int nb) {
        try {
            commande.getPanier().supprimerCookies(cookie, nb);
        } catch (RuntimeException exception) {
            gestionExceptions.ajouteException(exception);
        }
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

    @Alors("une erreur PasAssezCookie intervient")
    public void uneErreurPasAssezCookieIntervient() {
    }

    @Etantdonné("un problème est attendu \\(Commander)")
    public void unProblèmeEstAttenduCommander() {
        gestionExceptions.exceptionAttendue();
    }

    @Et("une exception IllegalArgumentException a été levée \\(Commander)")
    public void uneExceptionIllegalArgumentExceptionAÉtéLevéeCommander() {
        RuntimeException exception = gestionExceptions.getPremiereException();
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Et("une exception PasAssezCookies a été levée \\(Commander)")
    public void uneExceptionPasAssezCookiesAÉtéLevéeCommander() {
        RuntimeException exception = gestionExceptions.getPremiereException();
        assertNotNull(exception);
        assertEquals(PasAssezCookies.class, exception.getClass());
    }
}
