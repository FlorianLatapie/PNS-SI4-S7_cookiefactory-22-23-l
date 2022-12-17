package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.spring.depots.ClientDepot;
import fr.unice.polytech.cookiefactory.spring.interfaces.ConsulterPanier;
import fr.unice.polytech.cookiefactory.spring.interfaces.ModifierPanier;
import fr.unice.polytech.cookiefactory.spring.interfaces.PayerComande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GestionPanier implements ModifierPanier, ConsulterPanier {

    private ClientDepot clientDepot;
    private PayerComande payerComande;

    @Autowired
    public GestionPanier(ClientDepot clientDepot, PayerComande payerComande) {
        this.clientDepot = clientDepot;
        this.payerComande = payerComande;
    }
    @Override
    public List<Cookie> getCookies(Invite invite) {
        return invite.getPanier().getCookies();
    }

    @Override
    public int getNbCookies(Invite invite) {
        return invite.getPanier().getNbCookies();
    }


    @Override
    public void ajouterCookies(Invite invite, Cookie cookie, int quantite) {
        invite.getPanier().ajouterCookies(cookie, quantite);
    }

    @Override
    public void supprimerCookies(Invite invite, Cookie cookie, int quantite) {
        invite.getPanier().supprimerCookies(cookie, quantite);
    }
}
