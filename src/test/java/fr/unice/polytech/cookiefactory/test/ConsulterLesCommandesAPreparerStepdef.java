package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.cuisine.CreneauPreparationCommande;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsulterLesCommandesAPreparerStepdef {
    Cuisinier cuisinier;
    Commande commande;
    List<CreneauPreparationCommande> commandes;

    @Étantdonné("un cuisinier {string}")
    public void unCuisinier(String arg0) {
        cuisinier = new Cuisinier();
    }

    @Etantdonnéque("le cuisinier {string} a une commande {string} à préparer")
    public void leCuisinierAUneCommandeÀPréparer(String arg0, String arg1) {
        commande = new Commande();
        cuisinier.ajouterCommande(commande);
    }

    @Quand("le cuisinier {string} consulte les commandes à préparer")
    public void leCuisinierConsulteLesCommandesÀPréparer(String arg0) {
        commandes = cuisinier.getEdtCuisinier().getCreneauPreparationCommande();
    }

    @Alors("le cuisinier {string} voit la commande {string} à préparer")
    public void leCuisinierVoitLaCommandeÀPréparer(String arg0, String arg1) {
        assertEquals(List.of(new CreneauPreparationCommande(commande)), commandes);
    }

    @Etantdonnéque("le cuisinier {string} n’a pas de commande à préparer")
    public void leCuisinierNAPasDeCommandeÀPréparer(String arg0) {
        commandes = cuisinier.getEdtCuisinier().getCreneauPreparationCommande();
    }

    @Alors("le cuisinier {string} voit {string}")
    public void leCuisinierVoit(String arg0, String arg1) {
        assertEquals(List.of(), commandes);
    }
}
