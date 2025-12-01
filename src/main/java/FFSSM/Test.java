package FFSSM;

import java.time.LocalDate;

public class Test {
    
    public static void main(String[] args) {
        // Créer un club
        Club club = new Club(null, "Club de Plongée Paris");
        
        // Créer un plongeur
        Plongeur plongeur = new Plongeur(2);
        
        // Créer une licence délivrée aujourd'hui
        LocalDate aujourdhui = LocalDate.now();
        Licence licence = new Licence(plongeur, "LIC-2025-001", aujourdhui, club);
        
        // Test 1: Licence valide aujourd'hui
        System.out.println("Test 1 - Licence valide aujourd'hui ?");
        System.out.println("Résultat: " + licence.estValide(aujourdhui));
        System.out.println("Attendu: true");
    }
}
