package fr.unice.polytech.cookiefactory.exceptions;

public class PasAssezCookies extends RuntimeException {

    public PasAssezCookies(int nbARetirer, int nbTotal) {
        super("Le nombre de cookie à retirer est trop important (total : " + nbTotal + " | retirer : " + nbARetirer);
    }


}
