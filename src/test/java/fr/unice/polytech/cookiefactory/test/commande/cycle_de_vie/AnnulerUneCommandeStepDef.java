package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

public class AnnulerUneCommandeStepDef {
    @Etantdonné("un magasin avec des commandes")
    public void un_magasin_avec_des_commandes() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Etantdonné("un client ayant une commande n'étant pas encore préparée")
    public void un_client_ayant_une_commande_n_étant_pas_encore_préparée() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Quand("le client annule sa commande")
    public void le_client_annule_sa_commande() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Alors("l'état de la commande devient ANNULEE")
    public void l_état_de_la_commande_devient_annulee() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Etantdonné("un client ayant une commande déja commencée")
    public void un_client_ayant_une_commande_déja_commencée() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Alors("une exception IllegalArgumentException est levée")
    public void une_exception_illegal_argument_exception_est_levée() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Etantdonné("un cuisinier assigné à cette commande")
    public void un_cuisinier_assigné_à_cette_commande() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Alors("le créneau du cuisinier est libéré")
    public void le_créneau_du_cuisinier_est_libéré() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Alors("on rajoute dans le stock les ingrédients nécessaires à la commande")
    public void on_rajoute_dans_le_stock_les_ingrédients_nécessaires_à_la_commande() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Alors("le client est remboursé de la valeur de sa commande")
    public void le_client_est_remboursé_de_la_valeur_de_sa_commande() {
        // Write code here that turns the phrase above into concrete actions
    }

}
