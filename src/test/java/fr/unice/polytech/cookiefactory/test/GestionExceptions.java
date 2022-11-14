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
    private final List<Exception> exceptions = new ArrayList<>();

    public void exceptionAttendue() {
        exceptionAttendue = true;
    }

    public void ajouterRuntimeException(RuntimeException e) {
        if (!exceptionAttendue) {
            throw e;
        }
        exceptions.add(e);
    }

    public void ajouterException(Exception e) {
        exceptions.add(e);
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public Exception getPremiereException() {
        return exceptions.get(0);
    }

    public Exception popPremiereException() {
        return exceptions.remove(0);
    }

    public Exception popException(){
        return exceptions.remove(exceptions.size() - 1);
    }
}