package fr.unice.polytech.cookiefactory.test.magasin;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendreSesCookiesTTCStepdefs {
    private final Magasin magasinRef = new Magasin();
    private Prix prixCommande;
    private Prix prixTTCCommande;
    private Magasin magasin;

    @Etantdonné("une commande de prix {int} centimes")
    public void une_commande_de_prix_en_centimes(Integer prix) {
        prixCommande = new Prix(prix);
    }

    @Etantdonné("un magasin de valeur ajoutée {int}%")
    public void un_magasin_de_valeur_ajoutée(Integer taxe) {
        magasin = new Magasin(taxe);
    }

    @Quand("le client paye la commande")
    public void le_client_paye_la_commande() {
        prixTTCCommande = magasin.ajouterTaxe(prixCommande);
    }

    @Alors("le prix sera celui TTC")
    public void le_prix_sera_celui_ttc() {
        assertTrue(prixTTCCommande.value() > prixCommande.value());
        assertNotEquals(prixTTCCommande.value(), magasinRef.ajouterTaxe(prixCommande).value());
    }
}
