package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.junit.jupiter.api.Assertions.*;

public class ValiderUneCommandeDelivreeStepdef {
    private Magasin magasin = new Magasin();
    private GestionnaireDeCommandes gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
    private Commande commandeEnAttente;

    @Étantdonné("une Commande pour {string} {string} en état {string}")
    public void uneCommandePourEnÉtat(String prenom, String nom, String etat) {
        Commande commande = new Commande(new Invite(nom, prenom));
        commande.changerStatut(Etat.valueOf(etat));
        gestionnaireDeCommandes.ajouterCommande(commande);
    }

    @Quand("je veux valider la commande de {string} {string}")
    public void je_veux_valider_la_commande(String prenom, String nom) {
        var rechercheCommande = gestionnaireDeCommandes.obtenirCommandeInvite(prenom, nom);
        if (rechercheCommande.isPresent()) {
            commandeEnAttente = rechercheCommande.get();
        } else {
            fail();
        }
        gestionnaireDeCommandes.commandeReceptionnee(commandeEnAttente);
    }

    @Alors("la commande est enlevée de la liste des commandes en attente de retrait")
    public void laCommandeEstEnlevéeDeLaListeDesCommandesEnAttenteDeRetrait() {
        assertFalse(gestionnaireDeCommandes.getCommandes().contains(commandeEnAttente));
        assertFalse(gestionnaireDeCommandes.getCommandes().isEmpty());
    }

    @Et("la commande est marquée comme {string}")
    public void laCommandeEstMarquéeComme(String etatCommande) {
        assertEquals(commandeEnAttente.getEtat(), Etat.valueOf(etatCommande));
    }
}
