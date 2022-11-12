package fr.unice.polytech.cookiefactory.test.client;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotifierClientStepdefs {
    private final Magasin magasin = new Magasin();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Commande commande;
    private Invite invite;

    @Etantdonné("un invité \\(notifier)")
    public void unInvitéNotifier() {
        invite = new Invite("Dupont", "Jean", "jean.dupont@gmail.com", "0606060606");
        setUpCheckSystemOut();
    }

    @Et("une de ses commandes")
    public void uneDeSesCommandes() {
        commande = new Commande(magasin, invite);
    }

    @Quand("la commande passe à l'état en attente de retrait")
    public void laCommandePasseÀLÉtatEnAttenteDeRetrait() {
        magasin.getGestionnaireDeCommandes().changerStatut(commande, Etat.EN_ATTENTE_DE_RETRAIT);
    }

    private void setUpCheckSystemOut() {
        System.setOut(new PrintStream(outContent));
    }

    @Alors("le client reçoit un message \\(retrait)")
    public void leClientReçoitUnMessageRetrait() {
        assertTrue(outContent.size() > 0);
        assertTrue(outContent.toString().contains("en attente de reception"));
    }

    @Quand("la commande passe à l'état est receptionnée")
    public void laCommandePasseÀLÉtatEstReceptionnée() {
        magasin.getGestionnaireDeCommandes().commandeReceptionnee(commande);
    }

    @Alors("le client reçoit un message \\(reception)")
    public void leClientReçoitUnMessageReception() {
        assertTrue(outContent.size() > 0);
        assertTrue(outContent.toString().contains("receptionnée"));
    }
}
