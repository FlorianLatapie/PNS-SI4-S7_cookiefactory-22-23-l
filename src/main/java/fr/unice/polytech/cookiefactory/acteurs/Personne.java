package fr.unice.polytech.cookiefactory.acteurs;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.divers.Prix;

public abstract class Personne {

    private final String nom;
    private final String prenom;
    private String email;
    private String telephone;
    private String motDePasse;
    private Prix solde;

    public Personne(String nom, String prenom, String email, String telephone, String motDePasse, double solde) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.solde = new Prix((int) solde * 100);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void changerEmail(String email) {
        this.email = email;
    }

    public void changerTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void changerMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Prix getSolde() {
        return this.solde;
    }

    public void setSolde(double solde) {
        this.solde = new Prix((int) solde * 100);
    }

    public void payer(Commande commande) {
        this.solde = this.solde.soustraire(commande.getPrix());
    }
}
