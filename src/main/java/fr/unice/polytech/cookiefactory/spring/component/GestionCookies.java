package fr.unice.polytech.cookiefactory.spring.component;

import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.cookie.Recette;
import fr.unice.polytech.cookiefactory.recette.enums.ValidationCookie;
import fr.unice.polytech.cookiefactory.spring.depots.CookieDepot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.unice.polytech.cookiefactory.spring.interfaces.*;

import java.util.*;

@Component
public class GestionCookies implements ConsulterCookieGlobales, ModifierCookieGlobales {
    private CookieDepot cookieDepot;

    @Autowired
    public GestionCookies(CookieDepot cookieDepot) {
        this.cookieDepot = cookieDepot;
        init();
    }

    @Override
    public Cookie getCookieParNom(String nom) {
        return getCookies().stream()
                .filter(cookie -> cookie.getNom().equals(nom))
                .findFirst().orElseThrow(
                        () -> new IllegalArgumentException(nom + "n'est pas contenu dans la base de données")
                );
    }

    @Override
    public void ajouterUnCookie(Cookie cookie) {
        cookieDepot.sauvegarder(cookie, cookie.getId());
    }

    @Override
    public void validerCookie(String nom) {
        Cookie cookie = getCookieParNom(nom);
        if (cookie == null) {
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        cookie.changerEtat(ValidationCookie.VALIDE);
    }

    @Override
    public List<Cookie> getCookies() {
        List<Cookie> res = new ArrayList<>();
        cookieDepot.getTout().forEach(res::add);
        return res;
    }

    @Override
    public List<Cookie> getCookiesEnAttente() {
        return getCookies().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.SOUMIS)).toList();
    }

    @Override
    public List<Cookie> getCookiesValide() {
        return getCookies().stream().filter(cookie -> cookie.getEtat().equals(ValidationCookie.VALIDE)).toList();
    }

    private void init() {
        Cookie cookiePopChoco = new Cookie(
                "Pop-Choco",
                new Recette()
                        .setSaveur("Amande", 10)
                        .setGarnitures(List.of("Chocolat", "Chocolat blanc"), 10)
                        .setCuisson("CROQUANT"),
                new Prix(150));
        ajouterUnCookie(cookiePopChoco);
        validerCookie("Pop-Choco");
    }
}
