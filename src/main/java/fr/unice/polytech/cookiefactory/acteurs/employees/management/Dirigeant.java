package fr.unice.polytech.cookiefactory.acteurs.employees.management;

public class Dirigeant extends Responsable {

    public Dirigeant(){
        this("Patrick", "Baudry", "patrick.baudry@cookiefactory.com", "0606060606", "1234", 0);
    }

    public Dirigeant(String nom, String prenom, String email, String telephone, String motDePasse, double solde) {
        super(nom, prenom, email, telephone, motDePasse, solde);
    }
}
