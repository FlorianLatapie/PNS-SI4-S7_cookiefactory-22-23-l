package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AnnulerUneCommandeStepDef {
    private Magasin magasin;
    private GestionnaireDeCommandes gestionnaireDeCommandes;
    private Client client;
    private Commande commande;
    private IllegalArgumentException exception;
    private Cuisinier cuisinier;
    private int tailleEdt;

    @Etantdonné("un magasin avec des commandes")
    public void un_magasin_avec_des_commandes() {
        magasin = new Magasin("Cookie!");
        gestionnaireDeCommandes = magasin.getGestionnaireDeCommandes();
    }

    @Et("une commande à annuler")
    public void uneCommandeAAnnuler() {
        client = new Client("Chabanier", "Aurelia");
        commande = new Commande(magasin, client);
        commande.setDateReception(Util.getLundiDeLaSemaineCourante(Util.heurePile(ZonedDateTime.now(), 9)));
    }

    @Et("un cuisinier responsable de la commande à annuler")
    public void unCuisinierResponsableDeLaCommandeÀAnnuler() {
        cuisinier = new Cuisinier(gestionnaireDeCommandes);
        cuisinier.ajouterCommande(commande);
        magasin.getGestionnaireDeCuisiniers().ajouterCuisinier(cuisinier);
        tailleEdt = cuisinier.getEdtCuisinier().getCreneauPreparationCommande().size();
    }

    @Etantdonné("un client ayant une commande n'étant pas encore préparée")
    public void un_client_ayant_une_commande_n_étant_pas_encore_préparée() {
        commande.setEtat(Etat.CONFIRMEE);
        gestionnaireDeCommandes.ajouterCommande(commande);
    }

    @Quand("le client annule sa commande")
    public void le_client_annule_sa_commande() {
        try{
            gestionnaireDeCommandes.annulerCommande(commande);
        }
        catch (IllegalArgumentException error){
            exception = error;
        }
    }

    @Alors("l'état de la commande devient ANNULEE")
    public void l_état_de_la_commande_devient_annulee() {
        assertEquals(Etat.ANNULEE, commande.getEtat());
    }

    @Etantdonné("un client ayant une commande déja commencée")
    public void un_client_ayant_une_commande_déja_commencée() {
        commande = new Commande(magasin, client);
        commande.setEtat(Etat.EN_COURS_DE_PREPARATION);
        gestionnaireDeCommandes.ajouterCommande(commande);
    }

    @Alors("une exception IllegalArgumentException est levée")
    public void une_exception_illegal_argument_exception_est_levée() {
        assertNotNull(exception);
    }

    @Alors("le créneau du cuisinier est libéré")
    public void le_créneau_du_cuisinier_est_libéré() {
        assertNotEquals(tailleEdt, cuisinier.getEdtCuisinier().getCreneauPreparationCommande().size());
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
