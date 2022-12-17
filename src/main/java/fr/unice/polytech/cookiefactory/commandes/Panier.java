package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.CookieFestif;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final List<LigneCommande> lignesCommande = new ArrayList<>();
    private Magasin magasinCommande = new Magasin("Test");

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public void ajouterCookies(Cookie cookie, int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("quantite : " + quantite + " doit être positive");
        }

        for (LigneCommande ligne : lignesCommande) {
            if (ligne.getCookie().equals(cookie)) {
                ligne.ajouterQuantite(quantite);
                return;
            }
        }

        if (cookie instanceof CookieFestif) {
            if (!magasinCommande.possedeChefCookieFestif()) {
                throw new IllegalArgumentException("Pas de chefs cookies festifs dans ce magasin");
            }
        }

        lignesCommande.add(new LigneCommande(cookie, quantite));
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public void supprimerCookies(Cookie cookie, int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("quantite : " + quantite + " doit être positive");
        }

        for (LigneCommande ligne : lignesCommande) {
            if (ligne.getCookie().equals(cookie)) {
                ligne.enleverQuantite(quantite);
                if (ligne.getQuantite() == 0) {
                    lignesCommande.remove(ligne);
                }
                return;
            }
        }
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public List<Cookie> getCookies() {
        return lignesCommande.stream().map(LigneCommande::getCookie).toList();
    }

    public int getNbCookies() {
        return lignesCommande.stream().mapToInt(LigneCommande::getQuantite).sum();
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }
    public Magasin getMagasinCommande() {
        return magasinCommande;
    }

    public void setMagasinCommande(Magasin magasin) {
        magasinCommande = magasin;
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */


    @Override
    public String toString() {
        return "Panier{" + lignesCommande + '}';
    }
}
