package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;

import java.util.UUID;

public interface ModifierClient {

    void supprimerClient(UUID id);

    void ajouterClient(Invite client);

    void modifierClientNom(UUID id, String nom);

    void modifierClientPrenom(UUID id, String prenom);

    void modifierClientTelephone(UUID id, String tel);

    void modifierClientEmail(UUID id, String email);
}
