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
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void ajoutBonusFidelite(int n) {
        nbDeCookiesCommandes += n;
    }

    public void appliquerReduction() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
