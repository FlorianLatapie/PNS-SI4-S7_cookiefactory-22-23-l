package fr.unice.polytech.cookiefactory.clientelle;

public class InformationClient {
    private String nom;
    private String prenom;
    private String mail;
    private String numeroDeTelephone;

    public InformationClient(String nom, String prenom, String mail, String numeroDeTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
