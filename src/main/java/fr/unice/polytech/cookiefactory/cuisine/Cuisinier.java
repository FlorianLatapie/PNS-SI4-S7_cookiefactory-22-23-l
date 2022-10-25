package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;

public class Cuisinier {
    private EDTCuisinier edtCuisinier;

    public Cuisinier() {
        this.edtCuisinier = new EDTCuisinier();
    }

    public void preparerCommande(Commande commande) {
        if (commande.getEtat() != Etat.CONFIRME) {
            throw new IllegalArgumentException("La commande n'est pas en état CONFIRME : " + commande.getEtat());
        }
        commande.changerStatut(Etat.EN_COURS_DE_PREPARATION);
    }

    public void terminerCommande(Commande commande) {
        if (commande.getEtat() != Etat.EN_COURS_DE_PREPARATION) {
            throw new IllegalArgumentException("La commande n'est pas etat EN_COURS_DE_PREPARATION : " + commande.getEtat());
        }
        commande.changerStatut(Etat.EN_ATTENTE_DE_RETRAIT);
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
}
