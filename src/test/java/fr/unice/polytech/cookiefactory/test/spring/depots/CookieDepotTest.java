package fr.unice.polytech.cookiefactory.test.spring.depots;

import fr.unice.polytech.cookiefactory.spring.component.GestionCookies;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.unice.polytech.cookiefactory.spring.depots.CookieDepot;
import org.springframework.boot.test.mock.mockito.MockBean;

@CucumberContextConfiguration
@SpringBootTest
public class CookieDepotTest {
    @Autowired
    GestionCookies gestionCookies;


}
