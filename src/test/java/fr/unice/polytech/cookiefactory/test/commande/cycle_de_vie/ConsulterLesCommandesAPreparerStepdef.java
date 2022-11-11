package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.CreneauPreparationCommande;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsulterLesCommandesAPreparerStepdef {
    private Cuisinier cuisinier;
    private Commande commande;
    private List<CreneauPreparationCommande> commandes;
    private GestionnaireDeCommandes gestionnaireDeCommandes;

    @Étantdonné("un cuisinier {string}")
    public void unCuisinier(String arg0) {
        gestionnaireDeCommandes = new GestionnaireDeCommandes();
        cuisinier = new Cuisinier(gestionnaireDeCommandes);
    }

    @Etantdonnéque("une commande {string} à préparer")
    public void uneCommandeÀPréparer(String arg0) {
        commande = new Commande();
        gestionnaireDeCommandes.ajouterCommande(commande);
        cuisinier.ajouterCommande(commande);
    }

    @Quand("le cuisinier consulte les commandes à préparer")
    public void leCuisinierConsulteLesCommandesÀPréparer() {
        commandes = cuisinier.getEdtCuisinier().getCreneauPreparationCommande();
    }

    @Alors("le cuisinier voit la commande à préparer")
    public void leCuisinierVoitLaCommandeÀPréparer() {
        assertEquals(List.of(new CreneauPreparationCommande(commande)), commandes);
    }

    @Etantdonnéque("le cuisinier n’a pas de commande à préparer")
    public void leCuisinierNAPasDeCommandeÀPréparer() {
        commandes = cuisinier.getEdtCuisinier().getCreneauPreparationCommande();
    }

    @Alors("le cuisinier voit aucune commande à préparer")
    public void leCuisinierVoitAucuneCommandeÀPréparer() {
        assertEquals(List.of(), commandes);
    }
}
