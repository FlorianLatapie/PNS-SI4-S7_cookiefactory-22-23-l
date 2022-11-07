package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;

import java.util.ArrayList;
import java.util.List;

public class RecettesDuMagasin {
    private List<Cookie> cookiesDisponible;
    private List<Cookie> cookiesEnAttenteDeValidation;

    public RecettesDuMagasin(){
        this.cookiesDisponible = new ArrayList<>();
        this.cookiesEnAttenteDeValidation = new ArrayList<>();
    }

    public void soumettreUnCookie(Cookie cookie){
        cookie.changerEtat(ValidationCookie.SOUMIS);
        cookiesEnAttenteDeValidation.add(cookie);
    }

    public void validerUnCookie(Cookie cookie){
        cookie.changerEtat(ValidationCookie.VALIDE);
        cookiesEnAttenteDeValidation.remove(cookie);
        cookiesDisponible.add(cookie);
    }

    public void ajouterRecette(Cookie recette) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void supprimerRecette(Cookie recette) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void ajouterDisponibilite(Cookie recette) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void retirerDisponibilite(Cookie recette) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Prix calculerPrixHorsTaxe(Cookie recette) {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Cookie> recupererCookiesDisponible() {
        // TODO implement here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Cookie> getCookiesDisponible() {
        return cookiesDisponible;
    }

    public List<Cookie> getCookiesEnAttenteDeValidation() {
        return cookiesEnAttenteDeValidation;
    }
}
