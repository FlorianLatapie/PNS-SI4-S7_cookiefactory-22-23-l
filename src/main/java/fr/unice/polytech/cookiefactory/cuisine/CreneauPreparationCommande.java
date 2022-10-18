package fr.unice.polytech.cookiefactory.cuisine;

import java.util.Date;

public class CreneauPreparationCommande {
    private Date dateDebut;
    private Date dateFin;

    public CreneauPreparationCommande(Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
}
