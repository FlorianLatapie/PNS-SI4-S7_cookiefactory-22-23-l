package fr.unice.polytech.cookiefactory.recette.cookie;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.enums.Cuisson;
import fr.unice.polytech.cookiefactory.recette.enums.Melange;
import fr.unice.polytech.cookiefactory.recette.ingredient.Garniture;
import fr.unice.polytech.cookiefactory.recette.ingredient.Pate;
import fr.unice.polytech.cookiefactory.recette.ingredient.Saveur;

import java.util.List;

public record Recette(String nom, Pate pate, Saveur saveur, List<Garniture> garnitures, Cuisson cuisson,
                      Melange melange, int tempsPreparation) {
    public Recette {
        if (nom == null || pate == null || saveur == null || garnitures == null || cuisson == null || melange == null || tempsPreparation <= 0) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être null");
        }
        if (garnitures.size() > 3) {
            throw new IllegalArgumentException("Un cookie ne peut pas avoir plus de 3 garnitures");
        }
    }

    public boolean estDisponible() {
        return this.pate.estDisponible() && this.saveur.estDisponible() && this.garnitures.stream().allMatch(Garniture::estDisponible);
    }

    public Prix prix() {
        return new Prix(this.pate.getPrix().add(this.saveur.getPrix()).add(this.garnitures.stream().map(Garniture::getPrix).reduce(Prix.ZERO, Prix::add)).getPrixEnCentimes() * 2);
    }
}
