package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChaineDeMagasins {
    static {
        ChaineDeMagasins.getInstance().ajouterMagasin(new Magasin("Magasin 1"));
        ChaineDeMagasins.getInstance().ajouterMagasin(new Magasin("Magasin 2"));
        ChaineDeMagasins.getInstance().ajouterMagasin(new Magasin("Magasin 3"));
    }

    private static ChaineDeMagasins instance;

    private final List<Magasin> magasins;

    private ChaineDeMagasins() {
        magasins = new ArrayList<>();
    }

    public static ChaineDeMagasins getInstance() {
        if (instance == null) {
            instance = new ChaineDeMagasins();
        }
        return instance;
    }

    public void ajouterIngredient(Ingredient ingredient) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void retirerIngredient(Ingredient ingredient) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");

    }

    public List<Magasin> getMagasins(String lieu) {
        return magasins.stream().filter(m -> m.getLieu().equals(lieu)).collect(Collectors.toList());
    }

    public Magasin getMagasin(String nom) {
        return magasins.stream().filter(m -> m.getNom().equals(nom)).findFirst().orElse(null);
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
}
