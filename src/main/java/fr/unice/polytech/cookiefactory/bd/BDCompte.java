package fr.unice.polytech.cookiefactory.bd;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.acteur.clients.Client;
import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.acteur.clients.Membre;

import java.util.ArrayList;
import java.util.List;

public class BDCompte {

    private final List<Compte> comptes;

    public BDCompte(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public BDCompte() {
        this.comptes = new ArrayList<>();
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public List<?> getCompte(Class<?> type) {
        return comptes.stream().filter(c -> c.getClass().equals(type)).toList();
    }

    public void addCompte(Compte compte) {
        this.comptes.add(compte);
    }

    public void devenirClient(Invite invite) {
        this.comptes.remove(invite);
        this.comptes.add(new Client(invite));
    }

    public void devenirMembre(Client client) {
        this.comptes.remove(client);
        this.comptes.add(new Membre(client));
    }
}
