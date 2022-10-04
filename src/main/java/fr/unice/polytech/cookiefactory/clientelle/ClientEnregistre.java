package fr.unice.polytech.cookiefactory.clientelle;

public class ClientEnregistre extends Invite{
    private String nomUtilisateur;
    private String mdp;
    private boolean estMembre;
    private InfosProgrammeLoyal ipl;
    
    public ClientEnregistre() {
        super();
        this.ipl = new InfosProgrammeLoyal(0);
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isEstMembre() {
        return estMembre;
    }

    public void setEstMembre(boolean estMembre) {
        this.estMembre = estMembre;
    }

    public InfosProgrammeLoyal getIpl() {
        return ipl;
    }

    public void setIpl(InfosProgrammeLoyal ipl) {
        this.ipl = ipl;
    }
}
