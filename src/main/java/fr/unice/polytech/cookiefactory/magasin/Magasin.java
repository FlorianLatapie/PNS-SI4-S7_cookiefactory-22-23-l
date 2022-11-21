package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.divers.Prix;
import fr.unice.polytech.cookiefactory.divers.Util;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;
import fr.unice.polytech.cookiefactory.recette.ingredient.Ingredient;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

public class Magasin {
    private final String nom;
    private double valeurTaxe = 0.2;
    private String lieu;
    private ZonedDateTime dateOuverture;
    private ZonedDateTime dateFermeture;

    private CookiesDuMagasin cookiesDuMagasin;
    private Stock stock;
    private final GestionnaireDeCommandes gestionnaireDeCommandes;

    private final GestionnaireDeCuisiniers gestionnaireDeCuisiniers;
    private ZonedDateTime date;

    // --- Constructeurs ---
    public Magasin() {
        this("");
    }

    public Magasin(String nom) {
        this.nom = nom;
        this.stock = new Stock();

        this.dateOuverture = Util.heurePile(Util.getLundiDeLaSemaineCourante(ZonedDateTime.now()), 8);
        this.dateFermeture = Util.heurePile(dateOuverture/*.plusDays(4)*/, 18);

        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.gestionnaireDeCuisiniers = new GestionnaireDeCuisiniers(this);
        this.cookiesDuMagasin = new CookiesDuMagasin();

        ChaineDeMagasins.getInstance().getBd().getBdCookie().getCookiesValide().forEach(this::ajouterCookie);
    }

    public Magasin(Integer taxe) {
        this("");
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(String nom, double valeurTaxe, String lieu, ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        this(nom);
        this.valeurTaxe = valeurTaxe;
        this.lieu = lieu;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
    }

    // ------------------------------------------------------------------------

    public Prix ajouterTaxe(Prix p) {
        double prix = p.getPrixEnCentimes();
        double prixAvecTaxe = prix * (1 + valeurTaxe);
        return new Prix((int) prixAvecTaxe);
    }

    public void ajouterCookie(Cookie cookie) {
        for ( Ingredient ingredient : cookie.getRecette().getIngredients() ) {
                if (!getStock().contientIngredient(ingredient)) {
                    System.out.println("Le magasin ne contient pas l'ingredient " + ingredient.getNom());
                    return;
                }
        }
        cookiesDuMagasin.ajouterCookie(cookie);
    }
    public void ajouterIngredient(Ingredient ingredient) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void retirerIngredient(Ingredient ingredient) {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Cookie> recupererCookiesDuMagasin() {
        // TODO - Provient de l'UML
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Stock getStock() {
        return stock;
    }

    public CookiesDuMagasin getCookiesDuMagasin() {
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
        return dateOuverture;
    }

    public ZonedDateTime getHeureFermeture() {
        return dateFermeture;
    }

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

    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "nom='" + nom + '\'' +
                ", valeurTaxe=" + valeurTaxe +
                ", lieu='" + lieu + '\'' +
                ", dateOuverture=" + dateOuverture +
                ", dateFermeture=" + dateFermeture +
                //", recettesDuMagasin=" + recettesDuMagasin +
                ", stock=" + stock +
                //", gestionnaireDeCommandes=" + gestionnaireDeCommandes +
                //", gestionnaireDeCuisiniers=" + gestionnaireDeCuisiniers +
                '}';
    }

    public void setDate(ZonedDateTime zonedDateTime) {
        this.date = zonedDateTime;
    }

    private void setDateOuverture(ZonedDateTime dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    private void setDateFermeture(ZonedDateTime dateFermeture) {
        this.dateFermeture = dateFermeture;
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
        setDateOuverture(dateOuverture);
        setDateFermeture(dateFermeture);
    }
}
