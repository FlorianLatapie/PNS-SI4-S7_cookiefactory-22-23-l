package fr.unice.polytech.cookiefactory.divers;

import java.util.Objects;

public final class Prix {

    public static final Prix ZERO = new Prix(0);
    private final int nbCentimes;

    public Prix(int centimes) {
        this.nbCentimes = centimes;
    }

    public int getPrixEnCentimes() {
        return nbCentimes;
    }

    public Prix add(Prix prix) {
        return new Prix(this.nbCentimes + prix.nbCentimes);
    }

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
        return "Prix{" +
                "nbCentimes=" + nbCentimes +
                '}';
    }

}
