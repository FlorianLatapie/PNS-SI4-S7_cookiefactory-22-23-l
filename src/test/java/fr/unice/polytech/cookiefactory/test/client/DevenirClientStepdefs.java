package fr.unice.polytech.cookiefactory.test.client;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.bd.BDCompte;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevenirClientStepdefs {

    private final BDCompte baseDeDonnees = ChaineDeMagasins.getInstance().getBd().getBdCompte();
    private Compte compte;

    @Etantdonné("un invité qui veut passer son compte Invité en compte Client")
    public void unInvitéQuiVeutPasserSonCompteInvitéEnCompteClient() {
        baseDeDonnees.getComptes().clear();
        this.compte = new Invite("Jean", "Dupont", "jean_dupont@gmail.com", "1234567890", "secret");
        baseDeDonnees.addCompte(this.compte);
    }

    @Quand("il veux passer son compte invité en compte client")
    public void ilVeuxPasserSonCompteInvitéEnCompteClient() {
        baseDeDonnees.devenirClient((Invite) this.compte);
    }

    @Alors("l'invité devient un client avec ses avantages")
    public void lInvitéDevientUnClientAvecSesAvantages() {
        assertTrue(baseDeDonnees.getCompte(Invite.class).isEmpty());
        assertFalse(baseDeDonnees.getCompte(Client.class).isEmpty());
    }
}