package fr.unice.polytech.cookiefactory.spring.depots;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class DepotBasiqueImplemente<T, ID> implements Depot<T, ID> {

    private HashMap<ID,T> stockage = new HashMap<>();

    @Override
    public long taille() {
        return stockage.size();
    }

    @Override
    public void supprimerTout() {
        stockage.clear();
    }

    @Override
    public void supprimerParId(ID id) {
        stockage.remove(id);
    }

    @Override
    public boolean existe(ID id) {
        return stockage.containsKey(id);
    }

    @Override
    public List<T> getTout() {
        return stockage.values().stream().toList();
    }
    @Override
    public Optional<T> getParId(ID id) {
        return Optional.ofNullable(stockage.get(id));
    }

    @Override
    public <S extends T> void sauvegarder(S entity, ID id) {
        stockage.put(id,entity);
    }

}
