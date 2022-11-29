package fr.unice.polytech.cookiefactory.divers;

import java.util.Objects;

public final class Prix {

    public static final Prix ZERO = new Prix(0);
    private final int nbCentimes;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Prix(int centimes) {
        this.nbCentimes = Math.max(centimes, 0);
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public Prix ajouter(Prix prix) {
        return new Prix(this.nbCentimes + prix.nbCentimes);
    }

    public Prix soustraire(Prix prix) {
        return new Prix(this.nbCentimes - prix.nbCentimes);
    }

    public Prix multiplier(double nb) {
        return new Prix((int) (this.nbCentimes * nb));
    }

    public Prix reduction(int pourcentage) {
        return new Prix((int) (Math.ceil(this.nbCentimes * (1 - pourcentage / 100.0))));
    }

    public static Prix convertir(double prix){
        return new Prix((int) (prix * 100));
    }

    /* ------------------------------------------ Getters ------------------------------------------ */

    public int getPrixEnCentimes() {
        return nbCentimes;
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prix prix = (Prix) o;
        return nbCentimes == prix.nbCentimes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbCentimes);
    }

    @Override
    public String toString() {
        return this.nbCentimes / 100.0 + "€";
    }
}
