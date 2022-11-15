package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ValiderUneCommandeDelivreeStepdef {
    private final Magasin magasin = new Magasin();
    private final GestionnaireDeCommandes gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
    private Commande commandeEnAttente;

    @Étantdonné("une Commande pour {string} {string} en état {string}")
    public void uneCommandePourEnÉtat(String prenom, String nom, String etat) {
        Commande commande = new Commande(magasin, new Invite(nom, prenom, prenom + "_" + nom + "@gmail.com", "1234567890", "secret"));
        commande.changerStatut(Etat.valueOf(etat));
        gestionnaireDeCommandes.ajouterCommande(commande);
    }

    @Quand("je veux valider la commande de {string} {string}")
    public void je_veux_valider_la_commande(String prenom, String nom) {
        Optional<Commande> commande = gestionnaireDeCommandes.obtenirCommandeCompte(prenom, nom);
        if (commande.isPresent()) {
            commandeEnAttente = commande.get();
        } else {
            fail("La commande n'existe pas");
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
