package fr.unice.polytech.cookiefactory.spring.depots;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CommandeDepot extends DepotBasiqueImplemente<Invite, UUID> {
}
