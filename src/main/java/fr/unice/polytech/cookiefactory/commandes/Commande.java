package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.clientelle.Invite;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.Date;

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

    public Commande() {
        super();
    }

    public void appliquerRemise() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
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

    public Etat getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Contenu panier : " + panier +
                '}';
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
