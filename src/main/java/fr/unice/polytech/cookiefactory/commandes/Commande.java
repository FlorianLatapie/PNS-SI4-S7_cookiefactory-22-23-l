package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.IClasseTempsReel;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Commande implements IClasseTempsReel {

    public static int REDUCTION = 10; // en pourcentage
    private final Panier panier = new Panier();
    private ZonedDateTime dateReception;
    private boolean appliquerRemise;
    private GestionnaireDeCommandes gestionnaireDeCommandes;
    private Compte compte;
    private Etat etat = Etat.EN_COURS_DE_PREPARATION;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Commande(Compte compte) {
        this.compte = compte;
    }

    public Commande() {
    }

    public Commande(Magasin magasin) {
        this(magasin, null);
    }

    public Commande(Magasin magasin, Compte compte) {
        this.compte = compte;
        this.gestionnaireDeCommandes = magasin.getGestionnaireDeCommandes();
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public Prix getPrixHorsTaxe() {
        return panier.getLignesCommande().stream().map(LigneCommande::obtenirPrixSelonQuantite).reduce(Prix.ZERO, Prix::ajouter);
    }

    public Prix getPrixAvecTaxe() {
        Prix prixHorsTaxe = getPrixHorsTaxe();
        if (this.appliquerRemise && this.compte instanceof Membre) {
            this.appliquerRemise = false;
            prixHorsTaxe = getPrixHorsTaxeReduction(REDUCTION);
            ((Membre) this.compte).resetReduction();
        }
        return this.gestionnaireDeCommandes.ajouterTaxe(prixHorsTaxe);
    }

    public void appliquerRemise() {
        this.appliquerRemise = true;
    }

    public Prix getPrixHorsTaxeReduction(int pourcentage) {
        return getPrixHorsTaxe().reduction(pourcentage);
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

    @Override
    public void updateHeure(ZonedDateTime zonedDateTime) {
        if (etat == Etat.EN_ATTENTE_DE_RETRAIT && zonedDateTime.isAfter(dateReception.plusHours(2))) {
            etat = Etat.OUBLIEE;
        }
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public Compte getCompte() {
        return this.compte;
    }

    public Panier getPanier() {
        return panier;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public ZonedDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(ZonedDateTime dateReception) {
        this.dateReception = dateReception;
    }

    public GestionnaireDeCommandes getGestionnaireDeCommandes() {
        return gestionnaireDeCommandes;
    }

    public void setGestionnaireDeCommandes(GestionnaireDeCommandes gestionnaireDeCommandes) {
        this.gestionnaireDeCommandes = gestionnaireDeCommandes;
    }

    /* ------------------------------------ Méthodes génériques ------------------------------------ */

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
}
