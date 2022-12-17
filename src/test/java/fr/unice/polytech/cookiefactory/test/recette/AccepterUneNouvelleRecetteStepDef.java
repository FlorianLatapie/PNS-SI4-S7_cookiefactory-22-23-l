package fr.unice.polytech.cookiefactory.test.recette;


import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.factory.SimpleCookieFactory;
import fr.unice.polytech.cookiefactory.spring.composants.GestionCookies;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Étantdonné;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie.SOUMIS;
import static org.junit.jupiter.api.Assertions.assertTrue;

@CucumberContextConfiguration
@SpringBootTest
public class AccepterUneNouvelleRecetteStepDef {
    @Autowired
    GestionCookies gestionCookies;
    Cookie cookie;
    String nomCookie;

    @Étantdonné("un cookie {string}")
    public void un_cookie(String nomCookie) {
        this.nomCookie = nomCookie;
        SimpleCookieFactory simpleCookieFactory = new SimpleCookieFactory();
        simpleCookieFactory.setValidationCookie(SOUMIS);
        cookie = simpleCookieFactory.creerCookie(nomCookie);
    }

    @Étantdonné("un cuisinier qui soumet un cookie")
    public void un_cuisinier_qui_a_soumis_un_cookie() {
        gestionCookies.ajouterUnCookie(cookie);
    }

    @Alors("un dirigeant valide le cookie")
    public void le_dirigent_valide_le_cookie() {
        gestionCookies.validerCookie(nomCookie);
    }

    @Alors("le cookie est en attente de validation")
    public void leCookieEstEnAttenteDeValidation() {
        Cookie cookie = gestionCookies.getCookieParNom(nomCookie);
        assertTrue(gestionCookies.getCookiesEnAttente().stream().map(Cookie::getId).toList().contains(cookie.getId()));
    }

    @Alors("le cookie est accepté")
    public void leCookieEstAccepté() {
        Cookie cookie = gestionCookies.getCookieParNom(nomCookie);
        assertTrue(gestionCookies.getCookiesValide().stream().map(Cookie::getId).toList().contains(cookie.getId()));
    }
}
