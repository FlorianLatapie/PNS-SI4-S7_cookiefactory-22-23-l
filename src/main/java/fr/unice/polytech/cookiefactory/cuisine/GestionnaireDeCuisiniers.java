package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Occasions;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Themes;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.time.ZonedDateTime;
import java.util.*;

public class GestionnaireDeCuisiniers {
    private final List<Cuisinier> cuisiniers;
    private final Magasin magasin;
    private List<Map<ZonedDateTime, List<Cuisinier>>> planning;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public GestionnaireDeCuisiniers(Magasin magasin) {
        this.magasin = magasin;
        cuisiniers = new ArrayList<>();
        planning = creerPlanning(5, magasin.getDate(), magasin.getHeureOuverture(), magasin.getHeureFermeture());
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    private List<Map<ZonedDateTime, List<Cuisinier>>> creerPlanning(int nbJoursSemaine, ZonedDateTime dateSemaine, ZonedDateTime heureOuverture, ZonedDateTime heureFermeture) {
        List<Map<ZonedDateTime, List<Cuisinier>>> res = new ArrayList<>();
        for (int i = 0; i < nbJoursSemaine; i++) {
            res.add(creerJournee(heureOuverture, heureFermeture));
        }
        return res;
    }

    private Map<ZonedDateTime, List<Cuisinier>> creerJournee(ZonedDateTime heureOuverture, ZonedDateTime heureFermeture) {
        Map<ZonedDateTime, List<Cuisinier>> journee = new HashMap<>();

        // pour chaque heure entre l'ouverture et la fermeture du magasin, ajouter une liste vide de cuisiniers toutes les 15 minutes
        for (int i = 0; i < heureFermeture.getHour() - heureOuverture.getHour(); i++) {
            for (int j = 0; j < 60; j += 15) {
                journee.put(heureOuverture.plusHours(i).plusMinutes(j), new ArrayList<>());
            }
        }

        return journee;
    }

    public void assignerCuisinier(Commande commande) {
        int tempsPreparation = commande.calculerDureePreparation();
        var datedeFin = commande.getDateReception();
        var dateDebut = datedeFin.minusMinutes(tempsPreparation);

        for (var cuisinier : cuisiniers) {
            if (cuisinier.estDisponible(dateDebut, datedeFin)) {
                cuisinier.ajouterCommande(commande);
                // pour chaque créneau de 15 min de la commande, ajouter le cuisinier au planning
                for (int i = 0; i < tempsPreparation; i += 15) {
                    planning.get(dateDebut.getDayOfWeek().getValue()).get(dateDebut.plusMinutes(i)).add(cuisinier);
                }

                return;
            }
        }
    }

    public Optional<Cuisinier> getCuisinierAssigne(Commande commande) {
        for (Cuisinier cuisinier : cuisiniers) {
            if (cuisinier.getEdtCuisinier().getCreneauPreparationCommande().stream().anyMatch(creneau -> creneau.getCommande().equals(commande))) {
                return Optional.of(cuisinier);
            }
        }
        return Optional.empty();
    }

    public ChefCookieFestif devenirChefCookieFestif(Cuisinier cuisinier, ArrayList<Themes> themes, ArrayList<Occasions> occasions){
        if(cuisiniers.contains(cuisinier)){
            cuisiniers.remove(cuisinier);
            cuisinier = new ChefCookieFestif(cuisinier.getGestionnaireDeCommandes(), themes, occasions);
            cuisiniers.add(cuisinier);
            return (ChefCookieFestif) cuisinier;
        }
        throw new IllegalArgumentException("Le cuisinier n'est pas dans le magasin sélectionné");
    }

    public boolean ajouterCuisinier(Cuisinier cuisinier) {
        return cuisiniers.add(cuisinier);
    }

    public List<ZonedDateTime> getdisponibilitesDeLaSemaine() {
        List<ZonedDateTime> disponibilites = new ArrayList<>();
        for (Map<ZonedDateTime, List<Cuisinier>> journee : planning) {
            for (Map.Entry<ZonedDateTime, List<Cuisinier>> creneau : journee.entrySet()) {
                if (creneau.getValue().size() < cuisiniers.size()) {
                    disponibilites.add(creneau.getKey());
                }
            }
        }
        return disponibilites;
    }


    public String afficherPlanning() {
        return "Horaires magasin : " + magasin.getHeureOuverture() + " - " + magasin.getHeureFermeture() + System.lineSeparator() +
                afficheSemaine();
    }

    private String afficheSemaine() {
        StringBuilder sb = new StringBuilder();
        for (var journee : planning) {
            sb.append(afficheJournee(journee)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private String afficheJournee(Map<ZonedDateTime, List<Cuisinier>> journee) {
        StringBuilder sb = new StringBuilder();
        // trier les clés par ordre croissant
        journee.keySet().stream()
                .sorted()
                .forEach(
                        creneau -> sb
                                .append(creneau)
                                .append(" ")
                                .append(afficheCreneau(journee.get(creneau)))
                                .append(System.lineSeparator()));
        return sb.toString();
    }

    private String afficheCreneau(List<Cuisinier> cuisiniers) {
        return "creneau : " + cuisiniers;
    }

    /* ------------------------------------------ Getters ------------------------------------------ */

    public List<Cuisinier> getCuisiniers() {
        return cuisiniers;
    }
}
