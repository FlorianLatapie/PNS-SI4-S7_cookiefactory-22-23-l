package fr.unice.polytech.cookiefactory.magasin.factory;

import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.time.ZonedDateTime;

public class SimpleMagasinFactory implements MagasinFactory {
    private double valeurTaxe = 0.2;
    private String lieu = "Nice";

    // lundi à 8h
    private ZonedDateTime dateOuverture = null;
    private ZonedDateTime dateFermeture = null;


    public SimpleMagasinFactory setLieu(String lieu) {
        this.lieu = lieu;
        return this;
    }

    public SimpleMagasinFactory setValeurTaxe(double valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
        return this;
    }

    public SimpleMagasinFactory setDateOuverture(ZonedDateTime dateOuverture) {
        this.dateOuverture = dateOuverture;
        return this;
    }

    public SimpleMagasinFactory setDateFermeture(ZonedDateTime dateFermeture) {
        this.dateFermeture = dateFermeture;
        return this;
    }

    @Override
    public Magasin createMagasin(String nom) {
        // renvoyer le lundi de la semaine courante à 8h
        var maintenant = ZonedDateTime.now();
        var lundi = Util.getLundiDeLaSemaineCourante(maintenant);
        dateOuverture = lundi.withHour(8).withMinute(0).withSecond(0).withNano(0);
        dateFermeture = dateOuverture.plusHours(12);

        return new Magasin(nom, valeurTaxe, lieu, dateOuverture, dateFermeture);
    }
}
