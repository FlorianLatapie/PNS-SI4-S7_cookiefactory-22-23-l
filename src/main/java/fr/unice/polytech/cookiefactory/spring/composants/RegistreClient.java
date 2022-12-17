package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.spring.depots.ClientDepot;
import fr.unice.polytech.cookiefactory.spring.interfaces.ModifierClient;
import fr.unice.polytech.cookiefactory.spring.interfaces.ObtenirClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RegistreClient implements ObtenirClient, ModifierClient {
    private ClientDepot clientDepot;

    @Autowired
    public RegistreClient(ClientDepot clientDepot) {
        this.clientDepot = clientDepot;
    }

    public Optional<Invite> getClient(UUID id) {
        return clientDepot.getParId(id);
    }

    public Optional<Invite> getClient(String nom, String prenom) {
        Invite res = null;
        for (Invite client : clientDepot.getTout()) {
            if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) {
                res = client;
            }
        }
        return Optional.ofNullable(res);
    }

    public void ajouterClient(Invite client) {
        clientDepot.sauvegarder(client, client.getId());
    }

    public void supprimerClient(UUID id) {
        clientDepot.supprimerParId(id);
    }

    public boolean estClient(UUID id) {
        return clientDepot.existe(id);
    }

    public boolean estClient(String nom, String prenom) {
        return getClient(nom, prenom).isPresent();
    }

    public void modifierClientNom(UUID id, String nom) {
        getClient(id).ifPresent(invite -> invite.setNom(nom));
    }

    public void modifierClientPrenom(UUID id, String prenom) {
        getClient(id).ifPresent(invite -> invite.setPrenom(prenom));
    }

    public void modifierClientTelephone(UUID id, String tel) {
        getClient(id).ifPresent(invite -> invite.setTelephone(tel));
    }

    public void modifierClientEmail(UUID id, String email) {
        getClient(id).ifPresent(invite -> invite.setEmail(email));
    }
}
