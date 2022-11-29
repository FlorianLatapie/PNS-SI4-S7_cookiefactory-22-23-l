package fr.unice.polytech.cookiefactory.depots;

import java.util.Optional;

public interface Depot<T, ID> {

    // Returns the number of entities available.
    long taille();

    // Deletes all entities managed by the repository.
    void supprimerTout();

    // Deletes the entity with the given id.
    void supprimerParId(ID id);

    // Returns whether an entity with the given id exists.
    boolean existe(ID id);

    // Returns all instances of the type.
    Iterable<T> getTout();

    // Retrieves an entity by its id.
    Optional<T> getParId(ID id);

    // Saves a given entity through its id.
    <S extends T> void sauvegarder(S entity, ID id);

}
