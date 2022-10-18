package fr.unice.polytech.cookiefactory.divers;

public final class Prix {

    public static final Prix ZERO = new Prix(0);
    private final int nbCentimes;

    public Prix(int centimes) {
        this.nbCentimes = centimes;
    }

    public int getNbCentimes() {
        return nbCentimes;
    }

    public Prix add(Prix prix) {
        return new Prix(this.nbCentimes + prix.nbCentimes);
    }
}
