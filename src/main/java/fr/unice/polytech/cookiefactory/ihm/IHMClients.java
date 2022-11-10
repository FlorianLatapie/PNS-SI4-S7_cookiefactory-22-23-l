package fr.unice.polytech.cookiefactory.ihm;

import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.Scanner;

public class IHMClients implements IIHM {
    private final Scanner sc = new Scanner(System.in);
    private String MENU;
    private static final String MESSAGE_D_ACCUEIL = "Bonjour client" + System.lineSeparator();

    private final Magasin magasin;

    public IHMClients(Magasin magasin) {
        this.magasin = magasin;
    }

    public void lancer() {
        System.out.println(MESSAGE_D_ACCUEIL);
        int choix;
        do {
            choix = sc.nextInt();
            if (choix == 1) {
                quitter();
                return;
            } else if (choix == 2) {
                nouveauClient();
            } else {
                //utiliserClient(choix - 3);
            }
        } while (true);
    }

    private void nouveauClient() {
        System.out.println("Ajout d'un client ..");
        // TODO
    }

    private String buildMenu() {
        StringBuilder sb = new StringBuilder("Vous connecter en tant que client" + System.lineSeparator());
        sb.append("1 - Quitter").append(System.lineSeparator());
        sb.append("2 - Ajouter un client").append(System.lineSeparator());
        return sb.toString();
    }

    private static void quitter() {
        System.out.println("Client quitte");
    }
}
