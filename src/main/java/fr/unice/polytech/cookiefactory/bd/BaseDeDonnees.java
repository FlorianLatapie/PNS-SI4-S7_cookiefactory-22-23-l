package fr.unice.polytech.cookiefactory.bd;

public class BaseDeDonnees {
    private BDCookie bdCookie;
    private BDIngredient bdIngredient;
    private BDCompte bdCompte;

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public void initBD() {
        bdIngredient = new BDIngredient();
        bdCookie = new BDCookie();
        bdCompte = new BDCompte();
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

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
