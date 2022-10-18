package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
    private Date dateReception;
    private boolean appliquerRemise;
    private Prix reduction;

    private Magasin magasin;
    private Invite invite;
    private Etat etat;
    private List<Cookie> cookies = new ArrayList<>();

    public void ajouterCookie(Cookie cookie) {
        cookies.add(cookie);
    }

    public void supprimerCookie(Cookie cookie) {
        cookies.remove(cookie);
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public void appliquerRemise() {
        //TODO
    }

    public Prix getPrix() {
        int prix = 0;
        for (Cookie cookie : cookies) {
            prix += cookie.getPrixHorsTaxe().getPrixEnCentimes();
        }
        return new Prix(prix);
    }

    public void changerStatut(Etat etat) {
        this.etat = etat;
    }

    public Etat getEtat() {
        return etat;
    }
}
