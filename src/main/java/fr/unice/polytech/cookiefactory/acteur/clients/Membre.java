package fr.unice.polytech.cookiefactory.acteur.clients;

public class Membre extends Client {

    public Membre(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Membre(Client client) {
        super(client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), client.getMotDePasse());
    }

    public Membre(String nom, String prenom) {
        super(nom, prenom);
    }
}
