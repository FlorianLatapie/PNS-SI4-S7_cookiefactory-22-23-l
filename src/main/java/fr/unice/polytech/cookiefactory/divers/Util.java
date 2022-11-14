package fr.unice.polytech.cookiefactory.divers;

import java.time.ZonedDateTime;

public class Util {
    private Util() {
    }

    public static ZonedDateTime getLundiDeLaSemaineCourante(ZonedDateTime zonedDateTime) {
        return zonedDateTime.minusDays(zonedDateTime.getDayOfWeek().getValue() - 1L);
    }

    public static ZonedDateTime getLundiDeLaSemaineSuivante(ZonedDateTime zonedDateTime) {
        return getLundiDeLaSemaineCourante(zonedDateTime).plusWeeks(1);
    }

    public static ZonedDateTime heurePile(ZonedDateTime zonedDateTime, int heure) {
        return zonedDateTime.withHour(heure).withMinute(0).withSecond(0).withNano(0);
    }

    public static ZonedDateTime heureMinutePile(ZonedDateTime zonedDateTime, int heure, int minute) {
        return zonedDateTime.withHour(heure).withMinute(minute).withSecond(0).withNano(0);
    }
}
