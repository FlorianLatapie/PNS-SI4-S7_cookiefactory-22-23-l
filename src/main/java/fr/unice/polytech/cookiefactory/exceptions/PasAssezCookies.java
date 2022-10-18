package fr.unice.polytech.cookiefactory.exceptions;

public class PasAssezCookies extends RuntimeException{

    public PasAssezCookies() {
        super("Il n'y a pas assez de cookies");
    }
}
