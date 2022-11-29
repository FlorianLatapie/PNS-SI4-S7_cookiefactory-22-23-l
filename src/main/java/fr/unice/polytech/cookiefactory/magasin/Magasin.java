package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.commandes.Panier;
import fr.unice.polytech.cookiefactory.cuisine.ChefCookieFestif;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.divers.IClasseTempsReel;
import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public class Magasin implements IClasseTempsReel {
    private final String nom;
    private HorlogeDuMagasin horlogeDuMagasin;
    private double valeurTaxe = 0.2;
    private String lieu;
    private ZonedDateTime heureOuverture;
    private ZonedDateTime heureFermeture;
    private CookiesDuMagasin cookiesDuMagasin;
    private Stock stock;
    private final GestionnaireDeCommandes gestionnaireDeCommandes;

    private final GestionnaireDeCuisiniers gestionnaireDeCuisiniers;
    private ZonedDateTime date;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Magasin() {
        this("");
    }

    public Magasin(String nom) {
        this.nom = nom;
        this.stock = new Stock();

        this.heureOuverture = Util.heurePile(Util.getLundiDeLaSemaineCourante(ZonedDateTime.now()), 8);
        this.heureFermeture = Util.heurePile(heureOuverture/*.plusDays(4)*/, 18);

        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.gestionnaireDeCuisiniers = new GestionnaireDeCuisiniers(this);
        this.cookiesDuMagasin = new CookiesDuMagasin();
        ChaineDeMagasins.getInstance().getBd().getBdCookie().ajouterCookieDuMagasinListener(this.cookiesDuMagasin);
        this.horlogeDuMagasin = new HorlogeDuMagasin(this);
    }

    public Magasin(Integer taxe) {
        this("");
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(HorlogeDuMagasin horlogeDuMagasin) {
        this("");
        this.horlogeDuMagasin = horlogeDuMagasin;
    }

    public Magasin(String nom, double valeurTaxe, String lieu, ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        this(nom);
        this.valeurTaxe = valeurTaxe;
        this.lieu = lieu;
        this.heureOuverture = dateOuverture;
        this.heureFermeture = dateFermeture;
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public HashMap<String, Cookie> getCatalogue() {
        return cookiesDuMagasin
                .getCookies()
                .values()
                .stream()
                .filter(cookie -> estDisponible(cookie)) // On ne prend que les cookies disponiblesn en fonction du stock
                .collect(HashMap::new, (map, cookie) -> map.put(cookie.getNom(), cookie), HashMap::putAll);

    }

    private boolean estDisponible(Cookie cookie) {
        return stock.estDisponible(cookie);
    }
    private void reserverStock(Cookie cookie, int quantite) {
        for (Ingredient ingredient : cookie.getRecette().getIngredients()) {
            stock.retirerIngredient(ingredient, quantite);
        }
    }

    @Override
    public void updateHeure(ZonedDateTime zonedDateTime) {
        this.setDate(zonedDateTime);
        this.gestionnaireDeCommandes.updateHeure(zonedDateTime);
    }

    public boolean possedeChefCookieFestif(){
        return this.gestionnaireDeCuisiniers.getCuisiniers().stream().filter(cuisinier -> cuisinier instanceof ChefCookieFestif).count() > 0;
    }

    public void resreverIngredients(Commande commande) {
        commande.getPanier().getLignesCommande().forEach(ligneCommande -> reserverStock(ligneCommande.getCookie(), ligneCommande.getQuantite()));
    }

    public boolean verifierCommande(Commande commande) {
        return commande.getPanier().getCookies().stream().allMatch(cookie -> stock.estDisponible(cookie));
    }

    public void changerHoraires(ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        if (!dateOuverture.isBefore(dateFermeture)) {
            throw new IllegalArgumentException("La date d'ouverture doit être avant la date de fermeture");
        }
        if (dateOuverture.equals(dateFermeture)) {
            throw new IllegalArgumentException("La date d'ouverture doit être différente de la date de fermeture");
        }
        // si le temps entre les deux dates est inférieur à 1h, on lève une exception
        if (dateOuverture.until(dateFermeture, ChronoUnit.HOURS) < 1) {
            throw new IllegalArgumentException("Le magasin doit être ouvert au moins 1h par jour");
        }
        setHeureOuverture(dateOuverture);
        setHeureFermeture(dateFermeture);
    }

    /* ------------------------------------- Getters & Setters ------------------------------------- */

    public Stock getStock() {
        return stock;
    }

    public CookiesDuMagasin getRecettesDuMagasin() {
        return cookiesDuMagasin;
    }

    public GestionnaireDeCommandes getGestionnaireDeCommandes() {
        return gestionnaireDeCommandes;
    }

    public double getValeurTaxe() {
        return valeurTaxe;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public GestionnaireDeCuisiniers getGestionnaireDeCuisiniers() {
        return gestionnaireDeCuisiniers;
    }

    public ZonedDateTime getHeureOuverture() {
        return heureOuverture;
    }

    public ZonedDateTime getHeureFermeture() {
        return heureFermeture;
    }

    public CookiesDuMagasin getCookiesDuMagasin() {
        return cookiesDuMagasin;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime zonedDateTime) {
        this.date = zonedDateTime;
    }

    private void setHeureOuverture(ZonedDateTime heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    private void setHeureFermeture(ZonedDateTime heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    /* ------------------------------------- Méthodes génériques --------------------------------------- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magasin magasin = (Magasin) o;
        return nom.equals(magasin.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "nom='" + nom + '\'' +
                ", valeurTaxe=" + valeurTaxe +
                ", lieu='" + lieu + '\'' +
                ", dateOuverture=" + heureOuverture +
                ", dateFermeture=" + heureFermeture +
                //", recettesDuMagasin=" + recettesDuMagasin +
                ", stock=" + stock +
                //", gestionnaireDeCommandes=" + gestionnaireDeCommandes +
                //", gestionnaireDeCuisiniers=" + gestionnaireDeCuisiniers +
                '}';
    }
}
