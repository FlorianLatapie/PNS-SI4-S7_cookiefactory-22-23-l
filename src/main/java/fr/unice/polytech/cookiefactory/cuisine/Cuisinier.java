package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Occasions;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Themes;
import fr.unice.polytech.cookiefactory.magasin.ChaineDeMagasins;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Cuisinier {
    private final EDTCuisinier edtCuisinier;
    private final GestionnaireDeCommandes gestionnaireDeCommandes;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Cuisinier(GestionnaireDeCommandes gestionnaireDeCommandes) {
        this.edtCuisinier = new EDTCuisinier();
        this.gestionnaireDeCommandes = gestionnaireDeCommandes;
    }

    /* --------------------------------------- Méthodes --------------------------------------- */

    public void preparerCommande(Commande commande) {
        if (commande.getEtat() != Etat.CONFIRMEE) {
            throw new IllegalArgumentException("La commande n'est pas en état CONFIRME : " + commande.getEtat());
        }
        gestionnaireDeCommandes.changerStatut(commande, Etat.EN_COURS_DE_PREPARATION);
    }

    public void terminerCommande(Commande commande) {
        if (commande.getEtat() != Etat.EN_COURS_DE_PREPARATION) {
            throw new IllegalArgumentException("La commande n'est pas etat EN_COURS_DE_PREPARATION : " + commande.getEtat());
        }
        gestionnaireDeCommandes.changerStatut(commande, Etat.EN_ATTENTE_DE_RETRAIT);
    }

    public void annulerCommande(Commande commande) {
        if (commande.getEtat() != Etat.CONFIRMEE) {
            throw new IllegalArgumentException("Vous ne pouvez pas annuler votre commande maintenant! ");
        }
        edtCuisinier.getCreneauPreparationCommande().remove(obtenirCreneauPourCommande(commande));
    }

    public CreneauPreparationCommande obtenirCreneauPourCommande(Commande commande) {
        return edtCuisinier.getCreneauPreparationCommande().stream().filter(creneauPreparationCommande -> creneauPreparationCommande.getCommande() == commande).findAny().get();
    }

    public void ajouterCommande(Commande commande) {
        edtCuisinier.nouveauCreneau(commande);
    }

    public void soumettreUnCookie(Cookie cookie) {
        ChaineDeMagasins.getInstance().getBd().getBdCookie().ajouterUnCookie(cookie);
    }

    public boolean estDisponible(ZonedDateTime dateDebut, ZonedDateTime datedeFin) {
        return edtCuisinier.estDisponible(dateDebut, datedeFin);
    }

    /* --------------------------------------- Getters --------------------------------------- */

    public EDTCuisinier getEdtCuisinier() {
        return edtCuisinier;
    }

    public GestionnaireDeCommandes getGestionnaireDeCommandes() {
        return gestionnaireDeCommandes;
    }

    /* --------------------------------- Méthodes génériques --------------------------------- */

    @Override
    public String toString() {
        return "Cuisinier{" +
                "edtCuisinier=" + edtCuisinier +
                '}';
    }
}
