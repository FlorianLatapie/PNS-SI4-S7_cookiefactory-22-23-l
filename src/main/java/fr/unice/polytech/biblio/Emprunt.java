package fr.unice.polytech.biblio;

import java.time.LocalDate;
/**
 * Ph. Collet
 */
public class Emprunt {

	private LocalDate dateDeRetourMax;
	private Livre livreEmprunte;
	private Etudiant emprunteur;

	public Emprunt(LocalDate d, Etudiant e, Livre l) {
		dateDeRetourMax = d;
		emprunteur = e;
		livreEmprunte = l;
	}

	public Livre getLivreEmprunte() {
		return livreEmprunte;
	}

	public Etudiant getEmprunteur() {
		return emprunteur;
	}

	public LocalDate getDateDeRetourMax() {
		return dateDeRetourMax;
	}

}