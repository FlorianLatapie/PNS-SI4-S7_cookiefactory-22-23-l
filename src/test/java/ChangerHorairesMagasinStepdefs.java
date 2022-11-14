import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;
import io.cucumber.java.sl.In;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangerHorairesMagasinStepdefs {
    Magasin magasin;

    @Étantdonné("un magasin ouvert de {int}h à {int}h")
    public void unMagasinOuvertDeHÀH(int arg0, int arg1) {
        magasin = new Magasin();
    }


    @Alors("le magasin est ouvert de {int} à {int}")
    public void leMagasinEstOuvertDeHeureDOuvertureÀHeureDeFermeture(int ouverture, int fermeture) {
        assertEquals(ouverture, magasin.getHeureOuverture().getHour());
        assertEquals(fermeture, magasin.getHeureFermeture().getHour());
    }


    @Quand("je change les horaires d'ouvertures du magasin pour {int} à {int}")
    public void jeChangeLesHorairesDOuverturesDuMagasinPourHeureDOuvertureÀHeureDeFermeture(int ouverture, int fermeture) {
        var dateOuverture = Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), ouverture));
        var dateFermeture = Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), fermeture));
        magasin.changerHoraires(dateOuverture, dateFermeture);
    }

    @Alors("une erreur est levée")
    public void uneErreurEstLevée() {
    }
}

