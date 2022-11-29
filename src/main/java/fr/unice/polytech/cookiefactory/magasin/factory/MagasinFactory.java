package fr.unice.polytech.cookiefactory.magasin.factory;

import fr.unice.polytech.cookiefactory.magasin.Magasin;

public interface MagasinFactory {

    /* --------------------------------------- Méthodes --------------------------------------- */

    Magasin creerMagasin(String nom);
}
