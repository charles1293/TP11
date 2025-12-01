package FFSSM;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur {
	
    public int niveau;

    public ArrayList<Licence> licences = new ArrayList<>();

    public Plongeur(int niveau) {
        this.niveau = niveau;
    }

    public void ajouterLicence(Licence l, LocalDate delivrance, Club club) {
        licences.add(new Licence(this, l.numero, delivrance, club));
    }

    public Licence derniereLicence() {
        Licence derniere = null;
        for (Licence l : licences) {
            if (derniere == null || l.delivrance.isAfter(derniere.delivrance)) {
                derniere = l;
            }
        }
        return derniere;
    }

}
