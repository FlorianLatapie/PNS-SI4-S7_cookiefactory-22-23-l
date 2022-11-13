package fr.unice.polytech.cookiefactory.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Class permettant de récupérer les exceptions levées par les tests Cumcumber
 * <p>
 * L'auteur de ce code est Niel de Wet trouvé sur le <a href="https://stackoverflow.com/questions/17272161/cucumber-jvm-test-if-the-correct-exception-is-thrown">site</a>
 */

public class GestionExceptions {
    private boolean exceptionAttendue;
    private final List<RuntimeException> exceptions = new ArrayList<>();

    public void exceptionAttendue() {
        exceptionAttendue = true;
    }

    public void ajouteException(RuntimeException e) {
        if (!exceptionAttendue) {
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
