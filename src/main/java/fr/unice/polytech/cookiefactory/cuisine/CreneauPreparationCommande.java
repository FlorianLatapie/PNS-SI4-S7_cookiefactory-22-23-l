package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.time.ZonedDateTime;
import java.util.Objects;

public class CreneauPreparationCommande {
    private ZonedDateTime dateDebut;
    private ZonedDateTime dateFin;

    private int dureeReservee; // en minutes
    private Commande commande;

    public CreneauPreparationCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreneauPreparationCommande that = (CreneauPreparationCommande) o;
        return Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin) && Objects.equals(commande, that.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDebut, dateFin, commande);
    }
}
