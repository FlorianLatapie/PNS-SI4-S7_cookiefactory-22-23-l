package fr.unice.polytech.cookiefactory.bd;

public class BaseDeDonnees {
    private GererRecettesGlobales gererRecettesGlobales;
    private BDIngredient bdIngredient;
    private BDCompte bdCompte;


    public void initBD() {
        bdIngredient = new BDIngredient();
        gererRecettesGlobales = new GererRecettesGlobales();
        bdCompte = new BDCompte();
    }

    public GererRecettesGlobales getBdCookie() {
        return gererRecettesGlobales;
    }

    public BDIngredient getBdIngredient() {
        return bdIngredient;
    }

    public BDCompte getBdCompte() {
        return bdCompte;
    }
}
