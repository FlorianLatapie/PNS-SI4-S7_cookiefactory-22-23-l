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

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isEstMembre() {
        return estMembre;
    }

    public void setEstMembre(boolean estMembre) {
        this.estMembre = estMembre;
    }

    public InfosProgrammeLoyal getInfosProgrammeLoyal() {
        return infosProgrammeLoyal;
    }

    public void setInfosProgrammeLoyal(InfosProgrammeLoyal infosProgrammeLoyal) {
        this.infosProgrammeLoyal = infosProgrammeLoyal;
    }
}
