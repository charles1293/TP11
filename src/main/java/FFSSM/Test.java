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
        System.out.println("Attendu: true\n");
        
        // Test 2: Plongée conforme
        testPlongeeConforme();
        
        // Test 3: Licence expirée
        testLicenceExpiree();
        
        // Test 4: Plongeur dernière licence
        testPlongeurDerniereLicence();
        
        // Test 5: Embauche moniteur
        testEmbaucheMoniteur();
    }
    
    public static void testPlongeeConforme() {
        System.out.println("Test 2 - Plongée conforme ?");
        
        Club club = new Club(null, "Club Test");
        LocalDate aujourdhui = LocalDate.now();
        
        // Créer des plongeurs avec licences valides
        Plongeur p1 = new Plongeur(2);
        Licence l1 = new Licence(p1, "LIC-001", aujourdhui, club);
        
        Plongeur p2 = new Plongeur(3);
        Licence l2 = new Licence(p2, "LIC-002", aujourdhui.minusMonths(6), club);
        
        // Créer une plongée
        Site site = new Site("Site de plongée", "Belle plongée");
        DiplomeDeMoniteur moniteur = new DiplomeDeMoniteur(new Plongeur(4), 123);
        Plongee plongee = new Plongee(site, moniteur, aujourdhui, 20, 45);
        
        plongee.ajouteParticipant(l1);
        plongee.ajouteParticipant(l2);
        
        System.out.println("Résultat: " + plongee.estConforme());
        System.out.println("Attendu: true\n");
    }
    
    public static void testLicenceExpiree() {
        System.out.println("Test 3 - Licence expirée ?");
        
        Club club = new Club(null, "Club Test");
        LocalDate aujourdhui = LocalDate.now();
        
        // Créer une licence expirée (délivrée il y a 2 ans)
        Plongeur plongeur = new Plongeur(2);
        Licence licenceExpiree = new Licence(plongeur, "LIC-003", aujourdhui.minusYears(2), club);
        
        System.out.println("Résultat: " + licenceExpiree.estValide(aujourdhui));
        System.out.println("Attendu: false\n");
    }
    
    public static void testPlongeurDerniereLicence() {
        System.out.println("Test 4 - Dernière licence d'un plongeur ?");
        
        Club club = new Club(null, "Club Test");
        LocalDate aujourdhui = LocalDate.now();
        
        // Créer un plongeur avec plusieurs licences
        Plongeur plongeur = new Plongeur(2);
        
        Licence l1 = new Licence(plongeur, "LIC-004", aujourdhui.minusYears(2), club);
        plongeur.licences.add(l1);
        
        Licence l2 = new Licence(plongeur, "LIC-005", aujourdhui.minusYears(1), club);
        plongeur.licences.add(l2);
        
        Licence l3 = new Licence(plongeur, "LIC-006", aujourdhui, club);
        plongeur.licences.add(l3);
        
        Licence derniere = plongeur.derniereLicence();
        
        System.out.println("Résultat: " + (derniere != null ? derniere.numero : "null"));
        System.out.println("Attendu: LIC-006\n");
    }
    
    public static void testEmbaucheMoniteur() {
        System.out.println("Test 5 - Embauche moniteur ?");
        
        Club club = new Club(null, "Club Employeur");
        LocalDate aujourdhui = LocalDate.now();
        
        // Créer un moniteur
        Plongeur plongeur = new Plongeur(4);
        DiplomeDeMoniteur moniteur = new DiplomeDeMoniteur(plongeur, 456);
        
        // Embaucher le moniteur
        moniteur.nouvelleEmbauche(club, aujourdhui);
        
        // Vérifier l'employeur actuel
        Club employeurActuel = moniteur.employeurActuel();
        
        System.out.println("Résultat: " + (employeurActuel != null ? employeurActuel.getNom() : "null"));
        System.out.println("Attendu: Club Employeur\n");
    }
}
