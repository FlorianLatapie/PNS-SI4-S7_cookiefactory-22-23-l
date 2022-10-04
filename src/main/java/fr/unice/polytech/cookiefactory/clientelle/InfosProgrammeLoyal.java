package fr.unice.polytech.cookiefactory.clientelle;

public class InfosProgrammeLoyal {
    private int nbDeCookiesCommandes;

    public InfosProgrammeLoyal(int nbDeCookiesCommandes) {
        this.nbDeCookiesCommandes = nbDeCookiesCommandes;
    }

    public void peutAvoirReduction(){}
    public void ajoutBonusFidelite(int n){}
    public void appliquerReduction(){}

    public int getNbDeCookiesCommandes() {
        return nbDeCookiesCommandes;
    }

    public void setNbDeCookiesCommandes(int nbDeCookiesCommandes) {
        this.nbDeCookiesCommandes = nbDeCookiesCommandes;
    }
}
