package fr.unice.polytech.cookiefactory.acteur.clients;

public class Membre extends Client {

    public static final int QUOTA_REDUCTION = 30;
    private int pointsFidelite = 0;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Membre(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Membre(Client client) {
        super(client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), client.getMotDePasse());
    }

    public Membre(String nom, String prenom) {
        super(nom, prenom);
    }

    /* ----------------------------------------- Méthodes ----------------------------------------- */

    public void ajouterPointsFidelite(int pointsFidelite) {
        this.pointsFidelite += pointsFidelite;
    }

    public boolean aReduction() {
        return this.pointsFidelite >= QUOTA_REDUCTION;
    }

    public void resetReduction() {
        this.pointsFidelite -= QUOTA_REDUCTION;
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        if (pointsFidelite < 0) return;
        this.pointsFidelite = pointsFidelite;
    }
}
