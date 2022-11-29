package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayerUneCommandeStepdef {
    private Commande commande;
    private Client client;

    private GestionnaireDeCommandes gestionnaireDeCommandes;

    @Étantdonné("un client qui passe une commande")
    public void unClientAvecSolde€QuiPasseUneCommande() {
        this.client = new Client("Jean", "Dupont", "jean_dupont@gmail.com", "1234567890", "secret");
        Magasin m = new Magasin();
        this.commande = new Commande(m);
        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(m);
    }

    @Quand("le client paye la commande et qu'il arrive au bout du {string}")
    public void leClientPayeLaCommandeEtQuIlArriveAuBoutDu(String paiement) {
        this.commande.getPanier().ajouterCookies(new Cookie("Test", new Recette(/*new Pate("Pate"), new Saveur("Saveur"), List.of(new Garniture("Garniture")), Cuisson.CROQUANT, Melange.GARNI, 10*/)), 2);
        this.commande.setEtat(Etat.EN_COURS_DE_PAIEMENT);
        try {
            this.gestionnaireDeCommandes.payerCommande(this.commande, this.client, Boolean.parseBoolean(paiement));
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Alors("l'état de la commande passe à {string}")
    public void lÉtatDeLaCommandePasseÀEtat(String etat) {
        assertEquals(etat, this.commande.getEtat().toString());
    }
}