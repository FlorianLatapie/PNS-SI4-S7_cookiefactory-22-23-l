package fr.unice.polytech.cookiefactory.ihm;

import fr.unice.polytech.cookiefactory.cuisine.Cuisinier;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisinier;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.List;
import java.util.Scanner;

public class IHMGestionnaireCuisinier implements IIHM {
    private final Scanner sc = new Scanner(System.in);
    private String MENU;
    private static final String MESSAGE_D_ACCUEIL = "Bonjour cuisinier" + System.lineSeparator();
    private GestionnaireDeCuisinier gestionnaireDeCuisinier;

    private final int TAILLE_MENU = 2;

    public IHMGestionnaireCuisinier(Magasin magasin) {
        this.gestionnaireDeCuisinier = magasin.getGestionnaireDeCuisinier();
    }

    @Override
    public void lancer() {
        MENU = buildMenu();
        System.out.println(MESSAGE_D_ACCUEIL + MENU);
        int choix;
        do {
            choix = sc.nextInt();
            if (choix == 1) {
                quitter();
                return;
            } else if (choix == 2) {
                nouveauCuisinier();
            } else {
                afficherCuisinier(choix - TAILLE_MENU - 1);
            }
            MENU = buildMenu();
            System.out.println(System.lineSeparator() + MENU);
        } while (true);
    }

    private void afficherCuisinier(int i) {
        Cuisinier cuisinier = gestionnaireDeCuisinier.getCuisiniers().get(i);
        System.out.println(cuisinier);
    }

    private void nouveauCuisinier() {
        System.out.println("Ajout d'un cuisinier ..");
        gestionnaireDeCuisinier.ajouterCuisinier(new Cuisinier());
    }

    private void quitter() {
        System.out.println("IHM Cuisinier quitte");
    }

    public String buildMenu() {
        StringBuilder sb = new StringBuilder("Vous connecter en tant que cuisinier" + System.lineSeparator());
        sb.append("1 - Quitter").append(System.lineSeparator());
        sb.append("2 - Ajouter un cuisinier").append(System.lineSeparator());

        List<Cuisinier> cuisiniers = gestionnaireDeCuisinier.getCuisiniers();
        if (!cuisiniers.isEmpty()) {
            for (Cuisinier cuisinier : cuisiniers) {
                sb.append(cuisiniers.indexOf(cuisinier) + 1 + TAILLE_MENU).append(" - ").append(cuisinier).append(System.lineSeparator());
            }
        } else {
            sb.append("Aucun cuisinier n'est enregistré");
        }
        return sb.toString();
    }
}
