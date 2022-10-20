package fr.unice.polytech.cookiefactory.test;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

public class ConsulterLesCommandesAPreparerStepdef {
    @Étantdonné("un cuisinier {string}")
    public void unCuisinier(String arg0) {

    }

    @Etantdonnéque("le cuisinier {string} a une commande {string} à préparer")
    public void leCuisinierAUneCommandeÀPréparer(String arg0, String arg1) {

    }

    @Quand("le cuisinier {string} consulte les commandes à préparer")
    public void leCuisinierConsulteLesCommandesÀPréparer(String arg0) {
    }

    @Alors("le cuisinier {string} voit la commande {string} à préparer")
    public void leCuisinierVoitLaCommandeÀPréparer(String arg0, String arg1) {
    }

    @Etantdonnéque("le cuisinier {string} n’a pas de commande à préparer")
    public void leCuisinierNAPasDeCommandeÀPréparer(String arg0) {
    }

    @Alors("le cuisinier {string} voit {string}")
    public void leCuisinierVoit(String arg0, String arg1) {
    }
}
