package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Commande {
    private final Panier panier = new Panier();
    private ZonedDateTime dateReception;
    private boolean appliquerRemise;
    private GestionnaireDeCommandes gestionnaireDeCommandes;
    private Compte compte;
    private Etat etat = Etat.EN_COURS_DE_PREPARATION;

    public Commande(Compte compte) {
        this.compte = compte;
    }

    public Commande() {
    }

    public Commande(Magasin magasin) {
        gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
    }

    public Commande(Magasin magasin, Compte compte) {
        gestionnaireDeCommandes = new GestionnaireDeCommandes(magasin);
        this.compte = compte;
    }

    public Compte getCompte() {
        return this.compte;
    }

    public Panier getPanier() {
        return panier;
    }

    public Prix getPrix() {
        return panier.getLignesCommande().stream().map(LigneCommande::obtenirPrixSelonQuantite).reduce(Prix.ZERO, Prix::ajouter);
    }

    public Prix getPrixAvecTaxe(Prix prix) {
        return gestionnaireDeCommandes.getMagasin().ajouterTaxe(prix);
    }

    public Prix getPrixReduction() {
        return getPrix().reduction(10);
    }

    public void changerStatut(Etat etat) {
        this.etat = etat;
    }

    public void commandeConfirmee() {
        changerStatut(Etat.CONFIRMEE);
        panier.getLignesCommande().forEach(
                ligne -> ligne.getCookie().getRecette().getIngredients()
                        .forEach(
                                ingredient -> this.gestionnaireDeCommandes.getMagasin().getStock().retirerIngredient(ingredient, ligne.getQuantite())
                        )
        );
        gestionnaireDeCommandes.ajouterCommande(this);
    }

    public Etat getEtat() {
        return etat;
    }

    public ZonedDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(ZonedDateTime dateReception) {
        this.dateReception = dateReception;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Compte : " + this.compte +
                ", Contenu panier : " + this.panier +
                ", Etat : " + this.etat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return appliquerRemise == commande.appliquerRemise && Objects.equals(dateReception, commande.dateReception)
                && Objects.equals(gestionnaireDeCommandes, commande.gestionnaireDeCommandes)
                && Objects.equals(compte, commande.compte) && etat == commande.etat
                && Objects.equals(panier, commande.panier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateReception, appliquerRemise, gestionnaireDeCommandes, compte, etat, panier);
    }

    public int calculerDureePreparation() {
        return (panier.getLignesCommande().stream()
                .mapToInt(
                        ligneCommande -> ligneCommande.getCookie().getRecette().getTempsPreparation()
                                *
                                ligneCommande.getQuantite()
                )
                .sum() / 15) * 15 + 15;
    }
}
