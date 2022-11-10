package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.Date;
import java.util.Objects;

public class CreneauPreparationCommande {
    private Date dateDebut;
    private Date dateFin;
    private Commande commande;

    public CreneauPreparationCommande(Date dateDebut, Date dateFin, Commande commande) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commande = commande;
    }

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
