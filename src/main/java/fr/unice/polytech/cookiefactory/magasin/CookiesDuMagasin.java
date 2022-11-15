package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesDuMagasin {
    private final List<Cookie> cookiesDisponibles;

    public CookiesDuMagasin() {
        this.cookiesDisponibles = new ArrayList<>();
    }

    public void ajouterRecette(Cookie recette) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void supprimerRecette(Cookie recette) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void ajouterDisponibilite(Cookie recette) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void retirerDisponibilite(Cookie recette) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Prix calculerPrixHorsTaxe(Cookie recette) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Cookie> getCookiesDisponibles() {
        return cookiesDisponibles;
    }

}
