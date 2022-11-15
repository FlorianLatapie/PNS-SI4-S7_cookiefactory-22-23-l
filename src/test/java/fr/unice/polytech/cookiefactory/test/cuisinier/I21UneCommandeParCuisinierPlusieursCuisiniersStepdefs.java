package fr.unice.polytech.cookiefactory.test.cuisinier;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class I21UneCommandeParCuisinierPlusieursCuisiniersStepdefs {
    private Magasin magasin;
    private Commande commande;
    private List<Commande> commandes;


    @Étantdonné("un magasin")
    public void unMagasin() {
        magasin = new Magasin();
        commande = null;
        commandes = null;
    }

    @Et("{int} cuisiniers")
    public void cuisiniers(int nbCuisiniers) {
        for (int i = 0; i < nbCuisiniers; i++) {
            magasin.getGestionnaireDeCuisiniers().ajouterCuisinier(new Cuisinier(magasin.getGestionnaireDeCommandes()));
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
        commande.setDateReception(Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), 9)));
        magasin.getGestionnaireDeCuisiniers().assignerCuisinier(commande);
    }

    @Alors("un cuisinier est assigné à cette commande")
    public void unCuisinierEstAssignéÀCetteCommande() {
        assertTrue(magasin.getGestionnaireDeCuisiniers().getCuisinierAssigne(commande).isPresent());
    }

    @Quand("on ajoute autant de commandes que de cuisiniers,")
    public void onAjouteAutantDeCommandesQueDeCuisiniers() {
        for (int i = 0; i < magasin.getGestionnaireDeCuisiniers().getCuisiniers().size(); i++) {
            var tmp = new Commande();
            tmp.setDateReception(Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), 9)));
            magasin.getGestionnaireDeCuisiniers().assignerCuisinier(tmp);
        }
    }

    @Alors("chaque cuisinier est assigné à une commande")
    public void chaqueCuisinierEstAssignéÀUneCommande() {
        magasin
                .getGestionnaireDeCuisiniers()
                .getCuisiniers()
                .forEach(
                        cuisinier -> assertEquals(1, cuisinier
                                .getEdtCuisinier()
                                .getCreneauPreparationCommande()
                                .size())
                );
    }

    @Etqu("il est {int}h{int}")
    public void ilEstH(int heure, int min) {
        magasin.setDate(Util.getLundiDeLaSemaineCourante(ZonedDateTime.now().withHour(heure).withMinute(min)));
    }

    @Quand("on ajoute {int} commandes à {int}h{int}")
    public void onAjouteCommandesÀH(int nbCommandes, int heure, int minute) {
        commandes = new ArrayList<>();
        for (int i = 0; i < nbCommandes; i++) {
            var temp = new Commande();
            // copie de la date du magasin
            temp.setDateReception(Util.heureMinutePile(magasin.getDate(), heure, minute));
            commandes.add(new Commande());
            magasin.getGestionnaireDeCuisiniers().assignerCuisinier(temp);
        }
    }

    @Alors("chaque cuisinier est assigné à {int} commande en même temps")
    public void chaqueCuisinierEstAssignéÀCommandeEnMêmeTemps(int nbCommandesParCuisinier) {
        for (var cuisinier : magasin.getGestionnaireDeCuisiniers().getCuisiniers()) {
            assertEquals(nbCommandesParCuisinier, cuisinier.getEdtCuisinier().getCreneauPreparationCommande().size());
        }
    }

    public void disponibilite(){
        magasin.getGestionnaireDeCuisiniers().getdisponibilitesDeLaSemaine();
    }
}
