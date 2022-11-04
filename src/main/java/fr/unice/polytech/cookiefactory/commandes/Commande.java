package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.Date;
import java.util.Objects;

public class Commande {
    private Date dateReception;
    private boolean appliquerRemise;
    private Prix reduction;

    private Magasin magasin;
    private Invite invite;
    private Etat etat = Etat.EN_COURS_DE_PREPARATION;
    private final Panier panier = new Panier();

    public Commande(Invite invite) {
        this.invite = invite;
    }

    public Commande(Magasin magasin) {
        this.magasin = magasin;
    }

    public Commande() {
        super();
    }

    public void appliquerRemise() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Invite getInvite() {
        return invite;
    }

    public Panier getPanier() {
        return panier;
    }

    public Prix getPrix() {
        return panier.getLignesCommande().stream().map(ligne -> ligne.getCookie().getPrixHorsTaxe().multiply(ligne.getQuantite())).reduce(Prix.ZERO, Prix::add);
    }

    public void changerStatut(Etat etat) {
        this.etat = etat;
    }

    public void commandeConfirmee() {
        changerStatut(Etat.CONFIRME);
        panier.getLignesCommande().forEach(ligne -> ligne.getCookie().getIngredients().forEach(ingredient -> magasin.getStock().retirerIngredient(ingredient, ligne.getQuantite())));
    }

    public Etat getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Contenu panier : " + panier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return appliquerRemise == commande.appliquerRemise && Objects.equals(dateReception, commande.dateReception) && Objects.equals(reduction, commande.reduction) && Objects.equals(magasin, commande.magasin) && Objects.equals(invite, commande.invite) && etat == commande.etat && Objects.equals(panier, commande.panier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateReception, appliquerRemise, reduction, magasin, invite, etat, panier);
    }
}
