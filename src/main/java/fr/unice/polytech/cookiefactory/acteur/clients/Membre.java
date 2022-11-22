package fr.unice.polytech.cookiefactory.acteur.clients;

public class Membre extends Client {

    public static final int QUOTA = 30;
    private int pointsFidelite = 0;

    public Membre(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Membre(Client client) {
        super(client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), client.getMotDePasse());
    }

    public Membre(String nom, String prenom) {
        super(nom, prenom);
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        if (pointsFidelite < 0) return;
        this.pointsFidelite = pointsFidelite;
    }

    public void ajouterPointsFidelite(int pointsFidelite) {
        this.pointsFidelite += pointsFidelite;
    }
}