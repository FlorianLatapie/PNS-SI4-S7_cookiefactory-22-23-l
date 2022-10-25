package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.ArrayList;
import java.util.List;

public class EDTCuisinier {
    private List<CreneauPreparationCommande> creneauPreparationCommande;

    public EDTCuisinier() {
        this.creneauPreparationCommande = new ArrayList<>();
    }

    public void nouveauCreneau(Commande commande) {
        creneauPreparationCommande.add(new CreneauPreparationCommande(commande));
    }

    public List<CreneauPreparationCommande> getCreneauPreparationCommande() {
        return creneauPreparationCommande;
    }
}
