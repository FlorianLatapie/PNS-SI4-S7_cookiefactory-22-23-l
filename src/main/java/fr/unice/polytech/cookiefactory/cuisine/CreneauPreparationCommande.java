package fr.unice.polytech.cookiefactory.cuisine;

import java.util.Date;

public class CreneauPreparationCommande {
    private Date dateDebut;
    private Date dateFin;

    public CreneauPreparationCommande(Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
