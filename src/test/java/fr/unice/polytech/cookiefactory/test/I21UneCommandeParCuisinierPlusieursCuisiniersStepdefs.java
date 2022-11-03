package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class I21UneCommandeParCuisinierPlusieursCuisiniersStepdefs {
    private Magasin magasin;
    private Commande commande;


    @Étantdonné("un magasin")
    public void unMagasin() {
        magasin = new Magasin();
    }

    @Et("{int} cuisiniers")
    public void cuisiniers(int nbCuisiniers) {
        for (int i = 0; i < nbCuisiniers; i++) {
            magasin.getGestionnaireDeCuisiniers().ajouterCuisinier(new Cuisinier());
        }
    }

    @Étantdonnéque("tous les cuisiniers n'ont aucune commande")
    public void tousLesCuisiniersNOntAucuneCommande() {
        magasin
                .getGestionnaireDeCuisiniers()
                .getCuisiniers()
                .forEach(
                        cuisinier -> assertTrue(cuisinier
                                .getEdtCuisinier()
                                .getCreneauPreparationCommande()
                                .isEmpty()
                        )
                );
    }

    @Quand("on ajoute une commande")
    public void onAjouteUneCommande() {
        commande = new Commande();
        magasin.getGestionnaireDeCuisiniers().assignerCuisinier(commande);
    }

    @Alors("un cuisinier est assigné à cette commande")
    public void unCuisinierEstAssignéÀCetteCommande() {
        assertTrue(magasin.getGestionnaireDeCuisiniers().getCuisinierAssigne(commande).isPresent());
    }

    @Quand("on ajoute autant de commandes que de cuisiniers,")
    public void onAjouteAutantDeCommandesQueDeCuisiniers() {
        for (int i = 0; i < magasin.getGestionnaireDeCuisiniers().getCuisiniers().size(); i++) {
            commande = new Commande();
            magasin.getGestionnaireDeCuisiniers().assignerCuisinier(commande);
        }
    }

    @Alors("chaque cuisinier est assigné à une commande")
    public void chaqueCuisinierEstAssignéÀUneCommande() {
        magasin
                .getGestionnaireDeCuisiniers()
                .getCuisiniers()
                .forEach(
                        cuisinier -> assertTrue(cuisinier
                                .getEdtCuisinier()
                                .getCreneauPreparationCommande()
                                .size() == 1
                        )
                );
    }
}
