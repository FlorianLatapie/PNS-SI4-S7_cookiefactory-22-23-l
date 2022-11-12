package fr.unice.polytech.cookiefactory.divers;

import java.time.ZonedDateTime;

public class Util {
    public static ZonedDateTime getLundiDeLaSemaineCourante(ZonedDateTime zonedDateTime) {
        return zonedDateTime.minusDays(zonedDateTime.getDayOfWeek().getValue() - 1);
    }

    public static ZonedDateTime getLundiDeLaSemaineSuivante(ZonedDateTime zonedDateTime) {
        return getLundiDeLaSemaineCourante(zonedDateTime).plusWeeks(1);
    }
}
