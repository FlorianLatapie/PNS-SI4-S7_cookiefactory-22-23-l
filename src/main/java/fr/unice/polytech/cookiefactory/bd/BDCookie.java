package fr.unice.polytech.cookiefactory.bd;


import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.*;

public class BDCookie {

    //public static String POP_CHOCO = "Pop-Choco";
    private Map<String, Cookie> cookies;

    public BDCookie(){
        cookies = new HashMap<>();
        cookies.put("Pop-Choco", new Cookie(new Prix(150)));
    }

    public Cookie getCookieParNom(String nom){
        if (!cookies.containsKey(nom)){
            throw new IllegalArgumentException(nom + "n'est pas contenu dans la base de données");
        }
        return cookies.get(nom);
    }
}
