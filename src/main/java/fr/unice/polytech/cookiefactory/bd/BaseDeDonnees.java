package fr.unice.polytech.cookiefactory.bd;

public class BaseDeDonnees {
    private BDCookie bdCookie;
    private BDIngredient bdIngredient;

    public BaseDeDonnees() {
        initBD();
    }

    private void initBD() {
        bdCookie = new BDCookie();
        bdIngredient = new BDIngredient();
    }

    public BDCookie getBdCookie() {
        return bdCookie;
    }

    public BDIngredient getBdIngredient() {
        return bdIngredient;
    }
}
