package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.Date;
import java.util.Objects;

public class Commande {
    private final Panier panier = new Panier();
    private Date dateReception;
    private boolean appliquerRemise;
    private GestionnaireDeCommandes gestionnaireDeCommandes;
    private Invite invite;
    private Etat etat = Etat.EN_COURS_DE_PREPARATION;

    public Commande(Invite invite) {
        this.invite = invite;
    }

    public Commande() {
        super();
    }

    public Commande(Magasin magasin) {
        super();
        gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
    }

    public Commande(Magasin magasin, Invite invite) {
        super();
        gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
        this.invite = invite;
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

    public Prix getPrixReduction() {
        return getPrix().reduction(10);
    }

    public void changerStatut(Etat etat) {
        this.etat = etat;
    }

    public void commandeConfirmee() {
        changerStatut(Etat.CONFIRME);
        panier.getLignesCommande().forEach(ligne -> ligne.getCookie().getRecette().getIngredients().forEach(ingredient -> this.gestionnaireDeCommandes.getMagasin().getStock().retirerIngredient(ingredient, ligne.getQuantite())));
        gestionnaireDeCommandes.ajouterCommande(this);
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
        return appliquerRemise == commande.appliquerRemise && Objects.equals(dateReception, commande.dateReception) && Objects.equals(gestionnaireDeCommandes, commande.gestionnaireDeCommandes) && Objects.equals(invite, commande.invite) && etat == commande.etat && Objects.equals(panier, commande.panier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateReception, appliquerRemise, gestionnaireDeCommandes, invite, etat, panier);
    }
}
