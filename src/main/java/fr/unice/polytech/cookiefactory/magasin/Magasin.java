package fr.unice.polytech.cookiefactory.magasin;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.GestionnaireDeCuisiniers;
import fr.unice.polytech.cookiefactory.divers.IClasseTempsReel;
import fr.unice.polytech.cookiefactory.divers.Util;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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

    // --- Constructeurs ---
    public Magasin() {
        this("", new Stock());
    }

    public Magasin(String nom, Stock stock) {
        this.nom = nom;
        this.stock = stock;

        this.heureOuverture = Util.heurePile(Util.getLundiDeLaSemaineCourante(ZonedDateTime.now()), 8);
        this.heureFermeture = Util.heurePile(heureOuverture/*.plusDays(4)*/, 18);

        this.gestionnaireDeCommandes = new GestionnaireDeCommandes(this);
        this.gestionnaireDeCuisiniers = new GestionnaireDeCuisiniers(this);
        this.cookiesDuMagasin = new CookiesDuMagasin();

        this.horlogeDuMagasin = new HorlogeDuMagasin(this);
    }

    public Magasin(Integer taxe) {
        this("", new Stock());
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(Stock stock) {
        this("", stock);
    }

    public Magasin(HorlogeDuMagasin horlogeDuMagasin) {
        this("", new Stock());
        this.horlogeDuMagasin = horlogeDuMagasin;
    }

    public Magasin(Integer taxe, Stock stock) {
        this("", stock);
        this.valeurTaxe = taxe.floatValue() / 100;
    }

    public Magasin(String nom, double valeurTaxe, String lieu, ZonedDateTime dateOuverture, ZonedDateTime dateFermeture) {
        this(nom, new Stock());
        this.valeurTaxe = valeurTaxe;
        this.lieu = lieu;
        this.heureOuverture = dateOuverture;
        this.heureFermeture = dateFermeture;
    }

    // ------------------------------------------------------------------------
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
                ", dateOuverture=" + heureOuverture +
                ", dateFermeture=" + heureFermeture +
                //", recettesDuMagasin=" + recettesDuMagasin +
                ", stock=" + stock +
                //", gestionnaireDeCommandes=" + gestionnaireDeCommandes +
                //", gestionnaireDeCuisiniers=" + gestionnaireDeCuisiniers +
                '}';
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

    @Override
    public void updateHeure(ZonedDateTime zonedDateTime) {
        this.setDate(zonedDateTime);
        this.gestionnaireDeCommandes.updateHeure(zonedDateTime);
    }
}
