package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.time.ZonedDateTime;
import java.util.Objects;

public class CreneauPreparationCommande {
    private final ZonedDateTime dateDebut;
    private final ZonedDateTime dateFin;
    private final Commande commande;

    public CreneauPreparationCommande(Commande commande) {
        this.commande = commande;
        this.dateFin = commande.getDateReception();
        this.dateDebut = dateFin.minusMinutes(commande.calculerDureePreparation());
    }

    public String toString() {
        return "Cr" + commande.getDateReception() + " : " + dateDebut + " - " + dateFin;
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

    public boolean estContenuDans(ZonedDateTime dateDebut, ZonedDateTime dateFin) {
        return (this.dateDebut.equals(dateDebut) || this.dateFin.equals(dateFin))
                ||
                (this.dateDebut.isAfter(dateDebut) && this.dateFin.isBefore(dateFin));
    }
}
