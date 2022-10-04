package java.fr.unice.polytech.cookiefactory.cuisine;

import java.fr.unice.polytech.cookiefactory.commandes.Commande;

public class Cuisinier {
    private EDTCuisinier edtCuisinier;

    public Cuisinier(EDTCuisinier edtCuisinier) {
        this.edtCuisinier = edtCuisinier;
    }

    
    public void terminerCommande(Commande c){
        //Todo
    }

    
    public void ajouterCommande(Commande c){
        //Todo
    }

    public EDTCuisinier getEdtCuisinier() {
        return edtCuisinier;
    }

    public void setEdtCuisinier(EDTCuisinier edtCuisinier) {
        this.edtCuisinier = edtCuisinier;
    }
}
