package fr.unice.polytech.cookiefactory.test.magasin;

import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.magasin.factory.SimpleMagasinFactory;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GererLesMagasinsStepdefs {

    private Magasin magasin;
    private String nom;

    @Etantdonné("un magasin s'appelant {string}")
    public void unMagasinSAppelantSeSituantÀ(String nom) {
        this.nom = nom;
        magasin = new SimpleMagasinFactory().createMagasin(nom);
    }

    @Quand("j'ajoute le nouveau magasin")
    public void jAjouteLeNouveauMagasin() {
        ChaineDeMagasins.getInstance().ajouterMagasin(magasin);
    }

    @Alors("le magasin est présent dans la chaine de magasins")
    public void leMagasinEstPrésentDansLaChaineDeMagasins() {
        assertEquals(magasin, ChaineDeMagasins.getInstance().getMagasin(nom).orElse(null));
    }

    @Etantdonné("le magasin appartenant à la chaine de magasins")
    public void leMagasinAppartenantÀLaChaineDeMagasins() {
        jAjouteLeNouveauMagasin();
    }

    @Quand("je supprime le magasin de la chaine de magasins")
    public void jeSupprimeLeMagasinDeLaChaineDeMagasins() {
        ChaineDeMagasins.getInstance().retirerMagasin(nom);
    }

    @Alors("le magasin est absent de la chaine de magasins")
    public void leMagasinEstAbsentDeLaChaineDeMagasins() {
        assertNull(ChaineDeMagasins.getInstance().getMagasin(nom).orElse(null));
    }
}
