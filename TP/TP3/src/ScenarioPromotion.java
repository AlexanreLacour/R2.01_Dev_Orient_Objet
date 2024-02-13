/**
 * ScenarioPromotion
 */
public class ScenarioPromotion {

    public static void main(String[] args) {
        // initialisation de la pomotion (10 élèves)
        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant[] etudiant = new Etudiant[10];

        for (int i = 0; i < etudiant.length; i++) {
            etudiant[i] = new Etudiant("etudiant"+i, matieres, coefficients, nbNotes);
        }

        Promotion promo = new Promotion("Promo1", etudiant);

        //methode de test
        testPromotion(promo);
        testSetNom(promo, "promo 2023-2024");
        passageParReff();
        testMoyenne(promo); 
        testMoyenneMax(promo); 
        testMoyenneMin(promo); 
        testMoyenneMatiere(promo); 
        testGetMajor(promo); 
        testGetEtudiant(promo); 
        testToString(promo);
    }

    public static void testPromotion(Promotion promo){
        // Affichage des informations avec les getters
        
        //getMajor
        System.out.println("## Major de promo :");
        System.out.println(promo.getMajor());
        //getNom
        System.out.println("##GetNom");
        System.out.println(promo.getNom());

    }

    public static void testSetNom(Promotion promo, String nom){
        System.out.println("avant");
        System.out.println(promo.toString());
        promo.setNom(nom);
        System.out.println("apres");
        System.out.println(promo.toString());
    }

    public static void passageParReff(){
        // initialisation de la pomotion de (10 élèves)
        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant[] etudiant = new Etudiant[10];

        for (int i = 0; i < etudiant.length; i++) {
            etudiant[i] = new Etudiant("etudiant"+i, matieres, coefficients, nbNotes);
        }

        Promotion promo = new Promotion("Promo1", etudiant);

        

        System.out.println("//// Avant changement :");
        System.out.println(promo.toString());

        etudiant = new Etudiant[20];
        for (int i = 0; i < etudiant.length; i++) {
            etudiant[i] = new Etudiant("etudiant"+i, matieres, coefficients, nbNotes);
        }
        promo = new Promotion("Promo1", etudiant);

        etudiant = new Etudiant[10];
        for (int i = 0; i < etudiant.length; i++) {
            etudiant[i] = new Etudiant("etudiant"+i, matieres, coefficients, nbNotes);
        }
        promo = new Promotion("Promo1", etudiant);

        System.out.println("//// Apres changement :");
        System.out.println(promo.toString());
    }

    public static void testMoyenne(Promotion promo){
        System.out.println("## Test Get Moyenne");
        System.out.println("Moyenne général de la promotion : ");
        System.out.println(promo.moyenne());
        System.out.println("");
    }

    public static void testMoyenneMax(Promotion promo){
        System.out.println("## Test Get Moyenne Max");
        System.out.println("Moyenne Max de la promotion : ");
        System.out.println(promo.moyenneMax());
        System.out.println("");
    }

    public static void testMoyenneMin(Promotion promo){
        System.out.println("## Test Get Moyenne Min");
        System.out.println("Moyenne Min de la promotion : ");
        System.out.println(promo.moyenneMin());
        System.out.println("");
    }

    public static void testMoyenneMatiere(Promotion promo){
        System.out.println("## Test Get Moyenne Matiere");
        System.out.println("Moyenne Matiere de la Matiere 1 : ");
        System.out.println(promo.moyenneMatiere(1));
        System.out.println("");
        System.out.println("## Test Get Moyenne Matiere");
        System.out.println("Moyenne Matiere de la Matiere 2 : ");
        System.out.println(promo.moyenneMatiere(2));
        System.out.println("");
    }

    public static void testGetMajor(Promotion promo){
        System.out.println("## Test Get Major");
        System.out.println("Nom du major de Promotion : ");
        System.out.println(promo.getMajor().getNom());
        System.out.println("");
    }

    public static void testGetEtudiant(Promotion promo){
        System.out.println("## Test Get Etudiant");
        System.out.println("Les infos de l'étuidant n1 : ");
        System.out.println(promo.getEtudiant("etudiant0"));
        System.out.println("");

        System.out.println("Les infos de null : ");
        System.out.println(promo.getEtudiant(null));
        System.out.println("");
    }

    public static void testToString(Promotion promo){
        System.out.println("## Test To String");
        System.out.println("Les infos de la promotion n1 : ");
        System.out.println(promo.toString());
        System.out.println("");
    }
}