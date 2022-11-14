package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.bd.BaseDeDonnees;
import fr.unice.polytech.cookiefactory.magasin.factory.MagasinFactory;
import fr.unice.polytech.cookiefactory.magasin.factory.SimpleMagasinFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChaineDeMagasins {
    private static ChaineDeMagasins instance;

    static {
        MagasinFactory factory = new SimpleMagasinFactory();
        List<Magasin> magasins = new ArrayList<>();
        magasins.add(factory.createMagasin("Magasin 1"));
        magasins.add(factory.createMagasin("Magasin 2"));
        magasins.add(factory.createMagasin("Magasin 3"));

        magasins.forEach(magasin -> ChaineDeMagasins.getInstance().ajouterMagasin(magasin));
    }

    private final List<Magasin> magasins;
    private final BaseDeDonnees bd;

    private ChaineDeMagasins() {
        magasins = new ArrayList<>();
        bd = new BaseDeDonnees();
    }

    public static ChaineDeMagasins getInstance() {
        if (instance == null) {
            instance = new ChaineDeMagasins();
        }
        return instance;
    }

    public List<Magasin> getAllMagasins() {
        return magasins;
    }

    public List<Magasin> getMagasins(String lieu) {
        return magasins.stream().filter(m -> m.getLieu().equals(lieu)).collect(Collectors.toList());
    }

    public Optional<Magasin> getMagasin(String nom) {
        return magasins.stream().filter(m -> m.getNom().equals(nom)).findFirst();
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

    public BaseDeDonnees getBd() {
        return bd;
    }
}
