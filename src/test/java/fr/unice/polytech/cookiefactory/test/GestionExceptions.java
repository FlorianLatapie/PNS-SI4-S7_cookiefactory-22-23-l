package fr.unice.polytech.cookiefactory.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Class permettant de récupérer les exceptions levées par les tests Cumcumber
 *
 * L'auteur de ce code est Niel de Wet trouvé sur le <a href="https://stackoverflow.com/questions/17272161/cucumber-jvm-test-if-the-correct-exception-is-thrown">site</a>
 *
 */

public class GestionExceptions {
    private boolean expectException;
    private List<RuntimeException> exceptions = new ArrayList<>();

    public void exceptionAttendue() {
        expectException = true;
    }

    public void ajouteException(RuntimeException e) {
        if (!expectException) {
            throw e;
        }
        exceptions.add(e);
    }

    public List<RuntimeException> getExceptions() {
        return exceptions;
    }

    public RuntimeException getPremiereException() {
        return exceptions.get(0);
    }
}
