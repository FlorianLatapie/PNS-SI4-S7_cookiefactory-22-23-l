package java.fr.unice.polytech.cookiefactory.cuisine;

import java.fr.unice.polytech.cookiefactory.commandes.Commande;

public class Cuisinier {
    private EDTCuisinier edtCuisinier;

    public Cuisinier(EDTCuisinier edtCuisinier) {
        this.edtCuisinier = edtCuisinier;
    }

    //To do
    public void terminerCommande(Commande c){

    }

    //To do
    public void ajouterCommande(Commande c){

    }

    public EDTCuisinier getEdtCuisinier() {
        return edtCuisinier;
    }

    public void setEdtCuisinier(EDTCuisinier edtCuisinier) {
        this.edtCuisinier = edtCuisinier;
    }
}
