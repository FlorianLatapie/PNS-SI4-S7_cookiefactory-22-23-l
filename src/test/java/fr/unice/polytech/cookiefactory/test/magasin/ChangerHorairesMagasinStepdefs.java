package fr.unice.polytech.cookiefactory.test.magasin;

import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.test.GestionExceptions;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangerHorairesMagasinStepdefs {
    Magasin magasin;
    GestionExceptions gestionExceptions = new GestionExceptions();

    @Étantdonné("un magasin ouvert de {int} h à {int} h")
    public void un_magasin_ouvert_de_h_à_h(Integer int1, Integer int2) {
        magasin = new Magasin();
    }

    @Alors("le magasin est ouvert de {int} à {int}")
    public void le_magasin_est_ouvert_de_à(Integer int1, Integer int2) {
        assertEquals(int1, magasin.getHeureOuverture().getHour());
        assertEquals(int2, magasin.getHeureFermeture().getHour());
    }




    @Alors("une erreur est levée")
    public void uneErreurEstLevée() {
        assertEquals(IllegalArgumentException.class, gestionExceptions.popException().getClass());
    }



    @Quand("je change les horaires d ouvertures du magasin pour {int} à {int}")
    public void jeChangeLesHorairesDOuverturesDuMagasinPourHeureDOuvertureÀHeureDeFermeture(Integer ouverture, Integer fermeture) {
        var dateOuverture = Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), ouverture));
        var dateFermeture = Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), fermeture));
        try {
            magasin.changerHoraires(dateOuverture, dateFermeture);
        } catch (Exception e) {
            gestionExceptions.ajouterException(e);
        }
    }
}
