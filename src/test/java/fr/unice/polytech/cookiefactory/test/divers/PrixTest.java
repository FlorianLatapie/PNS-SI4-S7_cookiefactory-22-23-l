package fr.unice.polytech.cookiefactory.test.divers;

import fr.unice.polytech.cookiefactory.divers.Prix;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrixTest {
    @Test
    public void ajouterTest() {
        Prix prix = new Prix(100);
        prix = prix.ajouter(new Prix(100));
        assertEquals(200, prix.getPrixEnCentimes());
    }

    @Test
    public void soustraireTest() {
        Prix prix = new Prix(100);
        prix = prix.soustraire(new Prix(100));
        assertEquals(0, prix.getPrixEnCentimes());
    }

    @Test
    public void multiplierTest() {
        Prix prix = new Prix(100);
        prix = prix.multiplier(2);
        assertEquals(200, prix.getPrixEnCentimes());
    }

    @Test
    public void reductionTest() {
        Prix prix = new Prix(100);
        prix = prix.reduction(50);
        assertEquals(50, prix.getPrixEnCentimes());
    }
}
