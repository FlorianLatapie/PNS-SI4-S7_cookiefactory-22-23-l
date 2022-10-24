package fr.unice.polytech.cookiefactory.test;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreparerUneCommandeStepdef {
    private Commande commande;
    private Cuisinier cuisinier;

    @Étantdonné("une Commande en état {string}")
    public void uneCommandeEnÉtat(String etat) {
        cuisinier = new Cuisinier();

        Etat etatEntre = Etat.valueOf(etat);
        commande = new Commande();
        commande.setEtat(etatEntre);
    }

    @Quand("le cuisinier commence la préparation de la commande")
    public void jeCommenceLaPréparationDeLaCommande() {
        cuisinier.preparerCommande(commande);
    }

    @Quand("le cuisinier termine la préparation de la commande")
    public void jeTermineLaPréparationDeLaCommande() {
        jeCommenceLaPréparationDeLaCommande();
        cuisinier.terminerCommande(commande);
    }

    @Alors("la commande est en état {string}")
    public void laCommandeEstEnÉtat(String etat) {
        Etat etatAttendu = Etat.valueOf(etat);
        assertEquals(etatAttendu, commande.getEtat());
    }
}
