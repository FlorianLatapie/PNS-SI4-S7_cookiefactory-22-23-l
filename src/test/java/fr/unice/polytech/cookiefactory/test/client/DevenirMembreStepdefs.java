package fr.unice.polytech.cookiefactory.test.client;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.bd.BDCompte;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.*;

public class DevenirMembreStepdefs {

    private final BDCompte baseDeDonnees = ChaineDeMagasins.getInstance().getBd().getBdCompte();
    private Compte compte;

    private Compte membre;

    @Etantdonné("un client qui veut passer son compte Client en compte Membre")
    public void unClientQuiVeutPasserSonCompteClientEnCompteMembre() {
        baseDeDonnees.getComptes().clear();
        this.compte = new Client("Jean", "Dupont", "jean_dupont@gmail.com", "1234567890", "secret");
        baseDeDonnees.addCompte(this.compte);
    }

    @Quand("il veux passer son compte Client en compte Membre")
    public void ilVeuxPasserSonCompteClientEnCompteMembre() {
        baseDeDonnees.devenirMembre((Client) this.compte);
    }

    @Alors("le client devient un membre avec ses avantages")
    public void leClientDevientUnMembreAvecSesAvantages() {
        assertTrue(baseDeDonnees.getCompte(Client.class).isEmpty());
        assertFalse(baseDeDonnees.getCompte(Membre.class).isEmpty());
    }

    @Quand("un Membre passe une commande à {int} cookies et qu'il a {int} points de fidélité")
    public void unMembrePasseUneCommandeÀNombreCookiesCookiesEtQuIlAAvantPointsDeFidélité(int nombreCookies, int avant) {
        var gestionnaireDeCommandes = new GestionnaireDeCommandes(new Magasin());
        this.membre = new Membre("Jack", "Daniel", "jackdaneil@gmail.com", "1234567890", "chuuuu🤫");
        ((Membre) this.membre).setPointsFidelite(avant);

        Commande commande = new Commande(this.membre);
        gestionnaireDeCommandes.ajouterCommande(commande);

        try {
            commande.getPanier().ajouterCookies(ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookies().get(0), nombreCookies);
        } catch (Exception ignored) {
            if (nombreCookies < 0) assertTrue(true);
        }

        gestionnaireDeCommandes.payerCommande(commande, this.membre, true);
    }

    @Alors("il voit ses points de fidélité augmenter du nombre de cookie acheté: {int}")
    public void ilVoitSesPointsDeFidélitéAugmenterDuNombreDeCookieAchetéAprès(int après) {
        assertEquals(après, ((Membre) this.membre).getPointsFidelite());
    }
}