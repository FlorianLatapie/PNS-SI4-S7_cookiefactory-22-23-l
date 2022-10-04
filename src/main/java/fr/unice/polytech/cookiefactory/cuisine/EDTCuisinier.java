package java.fr.unice.polytech.cookiefactory.cuisine;

public class EDTCuisinier {
    private CreneauPreparationCommande creneauPreparationCommande;

    public EDTCuisinier(CreneauPreparationCommande creneauPreparationCommande) {
        this.creneauPreparationCommande = creneauPreparationCommande;
    }

    public CreneauPreparationCommande getCreneauPreparationCommande() {
        return creneauPreparationCommande;
    }

    public void setCreneauPreparationCommande(CreneauPreparationCommande creneauPreparationCommande) {
        this.creneauPreparationCommande = creneauPreparationCommande;
    }

    public void nouveauCreneau(){
        // TODO
    }
}
