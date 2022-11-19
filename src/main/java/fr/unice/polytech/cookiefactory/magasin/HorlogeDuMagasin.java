package fr.unice.polytech.cookiefactory.magasin;

import java.time.ZonedDateTime;

public class HorlogeDuMagasin {
    private static final long SECONDE = 1000L;
    private static final int DELAI = 10;

    public HorlogeDuMagasin(Magasin magasin) {

        lancer(magasin);
    }

    private void lancer(Magasin magasin) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(DELAI * SECONDE);
                    notifierMagasin(magasin);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public void notifierMagasin(Magasin magasin) {
        notifierMagasin(magasin, ZonedDateTime.now());
    }
    public void notifierMagasin(Magasin magasin, ZonedDateTime date) {
        magasin.updateHeure(date);
    }
}
