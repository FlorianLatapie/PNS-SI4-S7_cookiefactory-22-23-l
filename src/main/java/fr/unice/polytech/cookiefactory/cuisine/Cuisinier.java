package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public class Cuisinier {
    private EDTCuisinier edtCuisinier;

    public Cuisinier() {
        this.edtCuisinier = new EDTCuisinier();
    }

    
    public void terminerCommande(Commande c){
        //TODO
    }

    
    public void ajouterCommande(Commande c){
        //TODO
    }

    public EDTCuisinier getEdtCuisinier() {
        return edtCuisinier;
    }

    public void setEdtCuisinier(EDTCuisinier edtCuisinier) {
        this.edtCuisinier = edtCuisinier;
    }
}
