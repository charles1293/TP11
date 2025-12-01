/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Club {

    @Getter @Setter
    public DiplomeDeMoniteur president;

    @Getter @Setter
    public String nom;

    @Getter @Setter
    public String adresse;

    @Getter @Setter
    public String telephone;

    public ArrayList<Plongee> liste_plongees = new ArrayList<>();

    public Club(DiplomeDeMoniteur president, String nom) {
        this.president = president;
        this.nom = nom;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> nonConformes = new HashSet<>();
        for (Plongee p : liste_plongees) {
            if (!p.estConforme()) {
                nonConformes.add(p);
            }
        }
        return nonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        liste_plongees.add(p);
    }


    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
}
