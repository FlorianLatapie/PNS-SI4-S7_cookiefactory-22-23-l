package fr.unice.polytech.cookiefactory.test.spring.depots;

import fr.unice.polytech.cookiefactory.spring.composants.GestionCookies;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class CookieDepotTest {
    @Autowired
    GestionCookies gestionCookies;


}
