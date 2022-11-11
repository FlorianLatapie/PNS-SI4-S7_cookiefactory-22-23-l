package fr.unice.polytech.cookiefactory.test.commande.cycle_de_vie;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Lorsque;
import io.cucumber.java.fr.Quand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsulterLesCommandesEnAttenteDeRetraitStepdefs {

    private final GestionnaireDeCommandes gestionnaireDeCommandes = new GestionnaireDeCommandes();

    private List<Commande> commandesAVoir;

    @Lorsque("le système contient {int} dont {int} commandes en attente de retrait")
    public void leSystèmeContientCommandesDontRetraitCommandesEnAttenteDeRetrait(int commandes, int retrait) {
        for (int i = 0; i < commandes; i++) {
            Commande commande = new Commande();
            if (i < retrait) {
                commande.changerStatut(Etat.EN_ATTENTE_DE_RETRAIT);
            }
            this.gestionnaireDeCommandes.ajouterCommande(commande);
        }
    }

    @Quand("le caissier consulte les commandes en attente de retrait")
    public void le_caissier_consulte_les_commandes_en_attente_de_retrait() {
        this.commandesAVoir = this.gestionnaireDeCommandes.voirCommandesEnAttenteDeReception();
    }

    @Alors("il {int} commandes en attente de retrait")
    public void ilVoitVoitCommandesEnAttenteDeRetrait(int voit) {
        assertEquals(voit, this.commandesAVoir.size());
    }
}
