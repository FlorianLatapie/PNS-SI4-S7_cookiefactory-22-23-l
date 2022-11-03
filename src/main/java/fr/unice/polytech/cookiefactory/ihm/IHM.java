package fr.unice.polytech.cookiefactory.ihm;

import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IHM implements IIHM {
    private static final Scanner sc = new Scanner(System.in);
    //private static final IHMEmploye IHM_EMPLOYE = new IHMEmploye();
    private static IHMClients IHM_CLIENT;
    private static IHMGestionnaireCuisinier IHM_CUISINIER;

    private static List<IIHM> IHMS;

    private String MENU;

    private Magasin magasin;

    public IHM() {
        this.magasin = new Magasin();
        IHM_CUISINIER = new IHMGestionnaireCuisinier(magasin);
        IHM_CLIENT = new IHMClients(magasin);

        IHMS = List.of(IHM_CUISINIER, IHM_CLIENT);
    }

    public void lancer() {
        String menu = buildMenu();
        System.out.println(menu);
        int choix;
        do {
            try {
                choix = sc.nextInt();
                if (choix > 0 && choix <= IHMS.size()) {
                    IHMS.get(choix - 1).lancer();
                } else if (choix == IHMS.size() + 1) {
                    quitter();
                    return;
                } else {
                    System.out.println("Choix invalide");
                }
                System.out.println(System.lineSeparator() + menu);
            } catch (Exception e) {
                System.out.println("Choix invalide : entrez un nombre");
                sc.next();
            }
        } while (true);
    }

    private void quitter() {
        System.out.println("IHM quitte");
    }

    private String buildMenu() {
        return IntStream.range(0, IHMS.size()).mapToObj(i -> (i + 1) + " - " + IHMS.get(i).getClass().getSimpleName().substring(3) + System.lineSeparator()).collect(Collectors.joining("", "Choisissez un acteur :" + System.lineSeparator(), (IHMS.size() + 1) + " - Quitter"));
    }
}
