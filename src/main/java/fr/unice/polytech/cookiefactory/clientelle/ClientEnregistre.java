package fr.unice.polytech.cookiefactory.clientelle;

public class ClientEnregistre extends Invite {
    private String nomUtilisateur;
    private String motDePasse;
    private boolean estMembre;
    private InfosProgrammeLoyal infosProgrammeLoyal;

    public ClientEnregistre(String nom, String prenom, String mail, String numeroDeTelephone, String nomUtilisateur, String mdp) {
        super(nom, prenom, mail, numeroDeTelephone);
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = mdp;
        this.infosProgrammeLoyal = new InfosProgrammeLoyal();
    }

    public ClientEnregistre(String nom, String prenom, String mail, String numeroDeTelephone) {
        super(nom, prenom, mail, numeroDeTelephone);
    }
}
