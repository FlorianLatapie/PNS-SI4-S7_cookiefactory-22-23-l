package fr.unice.polytech.cookiefactory.magasin.factory;

import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.time.ZonedDateTime;

public class SimpleMagasinFactory implements MagasinFactory {
    private double valeurTaxe = 0.2;
    private String lieu = "Nice";
    private ZonedDateTime dateOuverture = null; //besoin de spécifier la valeur par défaut
    private ZonedDateTime dateFermeture = null; //besoin de spécifier la valeur par défaut


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
        return new Magasin(nom, valeurTaxe, lieu, dateOuverture, dateFermeture);
    }
}
