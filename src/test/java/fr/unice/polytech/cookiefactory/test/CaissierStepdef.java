package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaissierStepdef {
    @Etantdonné("un Caissier")
    public void un_caissier() {
        //
    }

    @Etantdonné("une Commande")
    public void une_commande() {
        //
    }

    @Quand("je veux valider la commande de {string}")
    public void je_veux_valider_la_commande(String nom) {
        Commande c = new Commande();
        GestionnaireDeCommandes g = new GestionnaireDeCommandes();
        g.commandeReceptionnee(c);
        assertEquals(c.getEtat(), Etat.RECEPTIONNEE);
    }

    @Alors("la commande est enlevée de la liste des commandes en attente de retrait")
    public void la_commande_est_enlevée_de_la_liste_des_commandes_en_attente_de_retrait() {
        //
    }
}
