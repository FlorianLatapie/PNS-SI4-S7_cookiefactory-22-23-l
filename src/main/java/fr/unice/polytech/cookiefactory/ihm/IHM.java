package fr.unice.polytech.cookiefactory.ihm;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IHM implements IIHM {
    private static final Scanner sc = new Scanner(System.in);
    private static final IHMEmploye IHM_EMPLOYE = new IHMEmploye();
    private static final IHMClient IHM_CLIENT = new IHMClient();

    private static final List<IIHM> IHMS = List.of(IHM_EMPLOYE, IHM_CLIENT);

    private String MENU;

    public void run() {
        String menu = buildMenu();
        System.out.println(menu);
        int choix;
        do {
            try {
                choix = sc.nextInt();
                if (choix > 0 && choix <= IHMS.size()) {
                    IHMS.get(choix - 1).run();
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
        return IntStream.range(0, IHMS.size()).mapToObj(i -> (i + 1) + " - " + IHMS.get(i).getClass().getSimpleName().substring(3) + System.lineSeparator()).collect(Collectors.joining("", "Choisissez :" + System.lineSeparator(), (IHMS.size() + 1) + " - Quitter"));
    }
}
