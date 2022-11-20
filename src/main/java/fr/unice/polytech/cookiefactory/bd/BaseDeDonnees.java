package fr.unice.polytech.cookiefactory.bd;

public class BaseDeDonnees {
    private BDCookie bdCookie;
    private BDIngredient bdIngredient;
    private BDCompte bdCompte;

    public BaseDeDonnees() {
        initBD();
    }

    private void initBD() {
        bdCookie = new BDCookie().init();
        bdIngredient = new BDIngredient().init();
        bdCompte = new BDCompte();
    }

    public BDCookie getBdCookie() {
        return bdCookie;
    }

    public BDIngredient getBdIngredient() {
        return bdIngredient;
    }

    public BDCompte getBdCompte() {
        return bdCompte;
    }
}
