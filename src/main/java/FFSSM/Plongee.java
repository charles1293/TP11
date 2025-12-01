/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongee {

	public Site lieu;

	public DiplomeDeMoniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;

	public ArrayList<Licence> licences = new ArrayList<>();

	public Plongee(Site lieu, DiplomeDeMoniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Licence l) {
		licences.add(l);
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		for (Licence l : licences) {
			if (!l.estValide(date)) {
				return false;
			}
		}
		return true;
	}

}
