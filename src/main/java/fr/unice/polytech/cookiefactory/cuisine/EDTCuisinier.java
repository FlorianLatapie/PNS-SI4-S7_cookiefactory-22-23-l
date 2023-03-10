package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class EDTCuisinier {
    private final List<CreneauPreparationCommande> creneauPreparationCommande;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public EDTCuisinier() {
        this.creneauPreparationCommande = new ArrayList<>();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public boolean estDisponible(ZonedDateTime dateDebut, ZonedDateTime datedeFin) {
        // pour chaque crénau de préparation, s'il existe, c'est qu'il n'est pas disponible
        for (var creneau : creneauPreparationCommande) {
            if (creneau.estContenuDans(dateDebut, datedeFin)) {
                return false;
            }
        }
        return true;
    }

    public void nouveauCreneau(Commande commande) {
        creneauPreparationCommande.add(new CreneauPreparationCommande(commande));
    }

    /* ------------------------------------------ Getters ------------------------------------------ */

    public List<CreneauPreparationCommande> getCreneauPreparationCommande() {
        return creneauPreparationCommande;
    }

    @Override
    public String toString() {
        return "EDTCuisinier{" +
                "creneaux=" + creneauPreparationCommande +
                '}';
    }
}
