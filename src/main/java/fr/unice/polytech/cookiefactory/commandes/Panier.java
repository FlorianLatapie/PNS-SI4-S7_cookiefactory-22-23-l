package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Panier {
    private final List<LigneCommande> lignesCommande = new ArrayList<>();

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

        lignesCommande.add(new LigneCommande(cookie, quantite));
    }

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

    public List<Cookie> getCookies() {
        return lignesCommande.stream().map(LigneCommande::getCookie).collect(Collectors.toList());
    }

    public int getNbCookies() {
        return lignesCommande.stream().mapToInt(LigneCommande::getQuantite).sum();
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    @Override
    public String toString() {
        return "Panier{" + lignesCommande + '}';
    }
}
