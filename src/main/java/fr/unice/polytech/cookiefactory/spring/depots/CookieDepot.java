package fr.unice.polytech.cookiefactory.spring.depots;

import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CookieDepot extends DepotBasiqueImplemente<Cookie, UUID> {


}
