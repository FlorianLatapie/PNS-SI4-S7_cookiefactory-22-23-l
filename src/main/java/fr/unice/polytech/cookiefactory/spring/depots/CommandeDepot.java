package fr.unice.polytech.cookiefactory.spring.depots;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CommandeDepot extends DepotBasiqueImplemente<Commande, UUID> {
}
