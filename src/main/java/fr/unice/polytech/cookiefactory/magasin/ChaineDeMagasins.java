package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.magasin.factory.MagasinFactory;
import fr.unice.polytech.cookiefactory.magasin.factory.SimpleMagasinFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChaineDeMagasins {

    private static ChaineDeMagasins instance;
    private List<Magasin> magasins;
    private BaseDeDonnees bd;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    private ChaineDeMagasins() {
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    private void init() {
        bd = new BaseDeDonnees();
        bd.initBD();
        magasins = new ArrayList<>();
        initMagasin();
    }

    private void initMagasin(){
        MagasinFactory factory = new SimpleMagasinFactory();
        magasins.add(factory.creerMagasin("Magasin 1"));
        magasins.add(factory.creerMagasin("Magasin 2"));
        magasins.add(factory.creerMagasin("Magasin 3"));
    }

    public static ChaineDeMagasins getInstance() {
        if (instance == null) {
            instance = new ChaineDeMagasins();
            instance.init();
        }
        return instance;
    }

    public void ajouterMagasin(Magasin magasin) {
        magasins.add(magasin);
    }

    public void retirerMagasin(Magasin magasin) {
        magasins.remove(magasin);
    }

    public void retirerMagasin(String nomMagasin) {
        magasins.removeIf(magasin -> magasin.getNom().equals(nomMagasin));
    }

    /* --------------------------------------- Getters & Setters --------------------------------------- */

    public List<Magasin> getAllMagasins() {
        return magasins;
    }

    public List<Magasin> getMagasins(String lieu) {
        return magasins.stream().filter(m -> m.getLieu().equals(lieu)).toList();
    }

    public Optional<Magasin> getMagasin(String nom) {
        return magasins.stream().filter(m -> m.getNom().equals(nom)).findFirst();
    }

    public BaseDeDonnees getBd() {
        return bd;
    }
}
