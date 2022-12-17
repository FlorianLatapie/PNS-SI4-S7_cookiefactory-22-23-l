package fr.unice.polytech.cookiefactory.acteur;

import fr.unice.polytech.cookiefactory.acteur.clients.Membre;

import java.util.UUID;

public abstract class Compte {
    private final UUID id = UUID.randomUUID();

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String motDePasse;

    protected Compte(String nom, String prenom, String email, String telephone, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
    }

    protected Compte(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    protected Compte() {
        this.nom = "";
        this.prenom = "";
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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

    @Override
    public String toString() {
        return "Compte{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }
}
