package fr.unice.polytech.cookiefactory.cuisine;

import java.util.ArrayList;
import java.util.List;

public class EDTCuisinier {
    private List<CreneauPreparationCommande> creneauPreparationCommande;

    public EDTCuisinier() {
        this.creneauPreparationCommande = new ArrayList<>();
    }

    public List<CreneauPreparationCommande> getCreneauPreparationCommande() {
        return creneauPreparationCommande;
    }

    public void setCreneauPreparationCommande(List<CreneauPreparationCommande> creneauPreparationCommande) {
        this.creneauPreparationCommande = creneauPreparationCommande;
    }

    public void nouveauCreneau(){
        // TODO
    }
}
