/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiplomeDeMoniteur {

    private final int numeroDiplome;
    private final Plongeur possesseur;
    private List<Embauche> liste_embauches;

    public DiplomeDeMoniteur(Plongeur possesseur, int numeroDiplome) {
        this.numeroDiplome = numeroDiplome;
        this.possesseur = possesseur;
        this.liste_embauches = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur ou null s'il n'en a pas
     */
    public Club employeurActuel() {
        if (liste_embauches.isEmpty()) {
            return null;
        }
        Embauche derniereEmbauche = liste_embauches.get(liste_embauches.size() - 1);
        if (derniereEmbauche.estTerminee()) {
            return null;
        }
        return derniereEmbauche.getEmployeur();
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche embauche = new Embauche(debutNouvelle, this, employeur);
        liste_embauches.add(embauche);	    
    }

    public List<Embauche> emplois() {
         return liste_embauches;
    }

}
