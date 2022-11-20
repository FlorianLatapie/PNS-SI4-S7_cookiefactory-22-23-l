package fr.unice.polytech.cookiefactory.recette.enums;

public enum Taille {
    L(4, 2),
    XL(5, 3),
    XXL(6, 4);

    private final int multiplicateurPrix;
    private final int multiplicateurQuantite;

    Taille(int multiplicateurPrix, int multiplicateurQuantite) {
        this.multiplicateurPrix = multiplicateurPrix;
        this.multiplicateurQuantite = multiplicateurQuantite;
    }

    public int getMultiplicateurPrix() {
        return multiplicateurPrix;
    }

    public int getMultiplicateurQuantite() {
        return multiplicateurQuantite;
    }
}
