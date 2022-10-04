package fr.unice.polytech.cookiefactory.clientelle;

public class InfosProgrammeLoyal {
    private int nbDeCookiesCommandes;

    public InfosProgrammeLoyal() {
        this.nbDeCookiesCommandes = 0;
    }

    public InfosProgrammeLoyal(int nbDeCookiesCommandes) {
        this.nbDeCookiesCommandes = nbDeCookiesCommandes;
    }

    public void peutAvoirReduction() {
        //TODO
    }

    public void ajoutBonusFidelite(int n) {
        //TODO
    }

    public void appliquerReduction() {
        //TODO
    }

    public int getNbDeCookiesCommandes() {
        return nbDeCookiesCommandes;
    }

    public void setNbDeCookiesCommandes(int nbDeCookiesCommandes) {
        this.nbDeCookiesCommandes = nbDeCookiesCommandes;
    }
}
