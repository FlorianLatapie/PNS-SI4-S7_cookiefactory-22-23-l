package fr.unice.polytech.cookiefactory.test.client;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.bd.BDCompte;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevenirMembreStepdefs {

    private final BDCompte baseDeDonnees = ChaineDeMagasins.getInstance().getBd().getBdCompte();
    private Compte compte;

    @Etantdonné("un client qui veut passer son compte Client en compte Membre")
    public void unClientQuiVeutPasserSonCompteClientEnCompteMembre() {
        baseDeDonnees.getComptes().clear();
        this.compte = new Client("Jean", "Dupont", "jean_dupont@gmail.com", "1234567890", "secret");
        baseDeDonnees.addCompte(this.compte);
    }

    @Quand("il veux passer son compte Client en compte Membre")
    public void ilVeuxPasserSonCompteClientEnCompteMembre() {
        baseDeDonnees.devenirMembre((Client) this.compte);
    }

    @Alors("le client devient un membre avec ses avantages")
    public void leClientDevientUnMembreAvecSesAvantages() {
        assertTrue(baseDeDonnees.getCompte(Client.class).isEmpty());
        assertFalse(baseDeDonnees.getCompte(Membre.class).isEmpty());
    }
}