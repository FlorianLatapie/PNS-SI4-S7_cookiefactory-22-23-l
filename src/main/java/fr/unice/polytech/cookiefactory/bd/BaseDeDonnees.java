package fr.unice.polytech.cookiefactory.bd;

public class BaseDeDonnees {
    private static BaseDeDonnees instance;

    private BDCookie bdCookie;

    public static BaseDeDonnees getInstance() {
        if (instance == null) {
            return new BaseDeDonnees();
        }
        return instance;
    }

    private BaseDeDonnees() {
        initBD();
    }

    private void initBD() {
        bdCookie = BDCookie.getInstance();
    }

    public BDCookie getBdCookie() {
        return bdCookie;
    }
}
