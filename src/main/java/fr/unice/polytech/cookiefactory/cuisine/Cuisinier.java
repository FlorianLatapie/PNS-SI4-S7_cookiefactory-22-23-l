package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.bd.BDCookie;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

public class Cuisinier {
    private EDTCuisinier edtCuisinier;

    private GestionnaireDeCommandes gestionnaireDeCommandes;

    public Cuisinier(GestionnaireDeCommandes gestionnaireDeCommandes) {
        this.edtCuisinier = new EDTCuisinier();
        this.gestionnaireDeCommandes = gestionnaireDeCommandes;
    }

    public void preparerCommande(Commande commande) {
        if (commande.getEtat() != Etat.CONFIRME) {
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


    public void ajouterCommande(Commande commande) {
        edtCuisinier.nouveauCreneau(commande);
    }

    public EDTCuisinier getEdtCuisinier() {
        return edtCuisinier;
    }

    public boolean estDisponible() {
        return edtCuisinier.getCreneauPreparationCommande().isEmpty();
    }

    public void soumettreUnCookie(Cookie cookie){
        BDCookie.getInstance().ajouterUnCookie(cookie);
    }

    @Override
    public String toString() {
        return "Cuisinier{" +
                "edtCuisinier=" + edtCuisinier +
                '}';
    }
}
