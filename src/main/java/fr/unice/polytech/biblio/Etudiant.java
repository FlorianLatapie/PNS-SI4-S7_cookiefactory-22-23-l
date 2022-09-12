package fr.unice.polytech.biblio;

import java.time.LocalDate;
import java.util.*;

/**
 * Ph. Collet
 */
public class Etudiant {

	private String nom;
	private int noEtudiant;
	Bibliotheque bibliotheque;
	Collection<Emprunt> emprunts;

	public Etudiant(Bibliotheque biblio) {
		this.bibliotheque = biblio;
		emprunts = new ArrayList<>();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNoEtudiant() {
		return this.noEtudiant;
	}

	public void setNoEtudiant(int noEtudiant) {
		this.noEtudiant = noEtudiant;
	}

	public Collection<Emprunt> getEmprunt() {
		return emprunts;
	}

	public int getNombreDEmprunt() {
		return emprunts.size();
	}

	public void emprunte(Livre livre) {
		Emprunt e = new Emprunt(LocalDate.now().plusDays(15), this, livre);
		livre.setEmprunte(true);
		emprunts.add(e);
	}

	public void rendre(String titreLivre) {
		List<Collection<Emprunt>> empruntsLoop = List.of(emprunts);
		Emprunt toRemove = null;
		for (Emprunt e : emprunts) {
			if (e.getLivreEmprunte().equals(titreLivre)){
				toRemove = e;
				e.getLivreEmprunte().setEmprunte(false);
				break;
			}
		}
		emprunts.remove(toRemove);
	}
}