package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import io.cucumber.java.bs.I;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaissierStepdef {
    private Commande commande;

    @Étantdonné("une Commande pour {string} {string} en état {string}")
    public void uneCommandePourEnÉtat(String prenom, String nom, String etat) {
        commande = new Commande(new Invite(prenom, nom));
        commande.setEtat(Etat.valueOf(etat));
    }

    @Quand("je veux valider la commande de {string}")
    public void je_veux_valider_la_commande(String nom) {
        commande = new Commande();
        GestionnaireDeCommandes g = new GestionnaireDeCommandes();
        g.commandeReceptionnee(commande);
        assertEquals(commande.getEtat(), Etat.RECEPTIONNEE);
    }

    @Alors("la commande est enlevée de la liste des commandes en attente de retrait et la commande est marquée comme {string}")
    public void laCommandeEstEnlevéeDeLaListeDesCommandesEnAttenteDeRetraitEtLaCommandeEstMarquéeComme(String etatCommande) {
    }


}
