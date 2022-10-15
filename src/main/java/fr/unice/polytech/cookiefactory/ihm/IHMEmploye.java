package fr.unice.polytech.cookiefactory.ihm;

import java.util.Scanner;

public class IHMEmploye implements IIHM {
    private final Scanner sc = new Scanner(System.in);
    private static final String MENU = "Que voulez-vous faire ?" + System.lineSeparator() + "1 - test" + System.lineSeparator() + "2 - Quitter";
    private static final String MESSAGE_D_ACCUEIL = "Bonjour employé" + System.lineSeparator() + MENU;

    public void run() {
        System.out.println(MESSAGE_D_ACCUEIL);
        int choix;
        do {
            try {
                choix = sc.nextInt();
                switch (choix) {
                    case 1 -> System.out.println("test");
                    case 2 -> {
                        quitter();
                        return;
                    }
                    default -> System.out.println("Choix invalide");
                }
                System.out.println(System.lineSeparator() + MENU);
            } catch (Exception e) {
                System.out.println("Choix invalide : entrez un nombre");
                sc.next();
            }
        } while (true);
    }

    private static void quitter() {
        System.out.println("Employé quitte");
    }
}
