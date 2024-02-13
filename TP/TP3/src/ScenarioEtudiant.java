public class ScenarioEtudiant {
    static int nbTests = 0, nbOK = 0;
    public static void main(String[] args) {
        testEtudiant();
        testSetNom();
        testGetNom();
        testCasGetNbMatieres();
        testGetUneNote();
        testMoyenneMatiere();
        testMoyenneGenerale();
        testMeilleurNote();
        testToString();

        System.out.println("Résultat final (pour les test auto): " + nbOK + " / " + nbTests + " tests passés.");
    }

    public static void testSetNom(){
        System.out.println("--- Test Set Nom ---");

        System.out.println(" ");

        System.out.println("## Cas normaux");
        testCasSetNom("Petit");
        testCasSetNom("Laurent");
        testCasSetNom("Petit-Jean");
        testCasSetNom("Guillouet");
        testCasSetNom("Paul Mirabelle");

        System.out.println(" ");

        System.out.println("## Cas limite"); //0
        testCasSetNom("");

        System.out.println(" ");

        System.out.println("## Cas d'ERREUR"); //null
        testCasSetNom(null);

        System.out.println(" ");
        System.out.println(" ");
    }

    public static void testCasSetNom(String nom){
        nbTests++;

        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant etudiant = new Etudiant("toto", matieres, coefficients, nbNotes);

        etudiant.setNom(nom);
        String nomModifier = etudiant.getNom();

        if(nomModifier == nom){
            System.out.println("OK");
            nbOK++;
        }else{
            System.out.println("ERROR : ");
        }
    }

    public static void testEtudiant(){
        System.out.println("--- Test Etudiant ---");
    
        System.out.println(" ");
    
        // Création d'un étudiant avec des notes spécifiques
        String[] matieres = {"Math", "Physique", "Chimie", "SVT"};
        double[] coefficients = {0.3, 0.4, 0.3,0.5};
        int nbNotes = 5;
        Etudiant etudiant = new Etudiant("toto", matieres, coefficients, nbNotes);
    
        // Affichage des informations avec les getters
        System.out.println("Nom : " + etudiant.getNom());
        System.out.println("Nombre de matières : " + etudiant.getNbMatieres());
    
        // Affichage de la moyenne générale
        System.out.println("Moyenne générale : " + etudiant.moyenneGeneral());
    
        // Affichage de la meilleure note
        System.out.println("Meilleure note : " + etudiant.meilleurNote());
    
        System.out.println(" ");
    }

    public static void testGetNom(){
        System.out.println("--- Test Get Nom ---");

        System.out.println(" ");

        System.out.println("## Cas normaux");
        testCasGetNom("Petit");
        testCasGetNom("Laurent");
        testCasGetNom("Petit-Jean");
        testCasGetNom("Guillouet");
        testCasGetNom("Paul Mirabelle");

        System.out.println(" ");

        System.out.println("## Cas limite"); //0
        testCasGetNom("");

        System.out.println(" ");

        System.out.println("## Cas d'ERREUR"); //null
        testCasGetNom(null);

        System.out.println(" ");
        System.out.println(" ");
    }

    public static void testCasGetNom(String nom){
        nbTests++;

        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant etudiant = new Etudiant(nom, matieres, coefficients, nbNotes);

        if(etudiant.getNom().equals(nom)){
            System.out.println("OK");
            nbOK++;
        }else if((nom == null)&&(etudiant.getNom().equals(""))){
            System.out.println("OK");
            nbOK++;
        }else{
            System.out.println("ERROR");

        }
    }

    public static void testCasGetNbMatieres(){
        System.out.println("--- Test Get Nb Matieres ---");

        System.out.println(" ");

        System.out.println("## Cas normaux");
        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant etudiant = new Etudiant("toto", matieres, coefficients, nbNotes);

        System.out.println("Doit renvoyer 3");
        System.out.println("Renvois : "+ etudiant.getNbMatieres());


        System.out.println(" ");

        System.out.println("## Cas limite"); 
        String[] matieres2 = {};

        Etudiant etudiant2 = new Etudiant("toto", matieres2, coefficients, nbNotes);

        System.out.println("Doit renvoyer 0");
        System.out.println("Renvois : "+ etudiant2.getNbMatieres());

        System.out.println(" ");

        String[] matieres3 = null;

        Etudiant etudiant3 = new Etudiant("toto", matieres3, coefficients, nbNotes);

        System.out.println("Doit renvoyer 0");
        System.out.println("Renvois : "+ etudiant3.getNbMatieres());

        System.out.println(" ");
        System.out.println(" ");

    }

    public static void testGetUneNote() {
        System.out.println("--- Test Get Une Note ---");

        System.out.println("## Cas normaux");

        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant etudiant = new Etudiant("toto", matieres, coefficients, nbNotes);

        // Afficher le tableau des notes pour chaque matière
        for (int i = 0; i < etudiant.getNbMatieres(); i++) {
            for (int j = 0; j < nbNotes; j++) {
                System.out.println("Note de " + matieres[i] + ": "
                        + etudiant.getUneNote(i, j));
            }
        }

        System.out.println(" ");
        System.out.println(" ");
    }

    @SuppressWarnings("null")
    public static void testMoyenneMatiere() {

        System.out.println("## Test de Moyenne Matiere");
        System.out.println("");

        System.out.println("Cas normal avec trois matières et cinq notes :");
        System.out.println("");
        String[] matieres7 = {"Math", "Physique", "Chimie"};
        double[] coefficients7 = {0.3, 0.4, 0.3};
        int nbNotes7 = 5;
        Etudiant etudiant7 = new Etudiant("toto", matieres7, coefficients7, nbNotes7);
        for (int i = 0; i < etudiant7.getNbMatieres(); i++) {
            System.out.println("Moyenne de " + matieres7[i] + ": " + etudiant7.moyenneMatiere(i));
        }
        System.out.println("");
        System.out.println("Cas limite avec zéro note");
        System.out.println("");
        String[] matieres8 = {"Math"};
        double[] coefficients8 = {0.3};
        int nbNotes8 = 0;
        Etudiant etudiant8 = new Etudiant("toto", matieres8, coefficients8, nbNotes8);
        for (int i = 0; i < etudiant8.getNbMatieres(); i++) {
            System.out.println("Moyenne de " + matieres8[i] + ": " + etudiant8.moyenneMatiere(i));
        }
        System.out.println("");
        System.out.println("Cas limite avec matière nulle");
        System.out.println("");
        String[] matieres9 = null;
        double[] coefficients9 = null;
        int nbNotes9 = 5;
        Etudiant etudiant9 = new Etudiant("toto", matieres9, coefficients9, nbNotes9);
        for (int i = 0; i < etudiant9.getNbMatieres(); i++) {
            System.out.println("Moyenne de " + matieres9[i] + ": " + etudiant9.moyenneMatiere(i));
        }

        System.out.println(" ");
        System.out.println(" ");
    }

    public static void testMoyenneGenerale() {

        System.out.println("## Test Moyenne Generale");
        System.out.println("");
        System.out.println("Cas normal avec trois matières");
        System.out.println("");
        String[] matieres10 = {"Math", "Physique", "Chimie"};
        double[] coefficients10 = {0.3, 0.4, 0.3};
        int nbNotes10 = 5;
        Etudiant etudiant10 = new Etudiant("toto", matieres10, coefficients10, nbNotes10);
        System.out.println("Moyenne générale : " + etudiant10.moyenneGeneral());
        System.out.println("");
        System.out.println("Cas limite avec zéro matière");
        System.out.println("");
        String[] matieres11 = {};
        double[] coefficients11 = {};
        int nbNotes11 = 5;
        Etudiant etudiant11 = new Etudiant("toto", matieres11, coefficients11, nbNotes11);
        System.out.println("Moyenne générale : " + etudiant11.moyenneGeneral());
        System.out.println("");
        System.out.println("Cas limite avec matières nulles");
        System.out.println("");
        String[] matieres12 = null;
        double[] coefficients12 = null;
        int nbNotes12 = 5;
        Etudiant etudiant12 = new Etudiant("toto", matieres12, coefficients12, nbNotes12);
        System.out.println("Moyenne générale : " + etudiant12.moyenneGeneral());

        System.out.println(" ");
        System.out.println(" ");
    }

    public static void testMeilleurNote() {
        System.out.println("");
        System.out.println("## Test Meilleur Note");
        System.out.println("");
        System.out.println("Cas normal avec trois matières et cinq notes");
        System.out.println("");
        String[] matieres13 = {"Math", "Physique", "Chimie"};
        double[] coefficients13 = {0.3, 0.4, 0.3};
        int nbNotes13 = 5;
        Etudiant etudiant13 = new Etudiant("toto", matieres13, coefficients13, nbNotes13);
        System.out.println(etudiant13.meilleurNote());
        System.out.println("");
        System.out.println("Cas limite avec zéro note");
        System.out.println("");
        String[] matieres14 = {"Math"};
        double[] coefficients14 = {0.3};
        int nbNotes14 = 0;
        Etudiant etudiant14 = new Etudiant("toto", matieres14, coefficients14, nbNotes14);
        System.out.println(etudiant14.meilleurNote());
        System.out.println("");
        System.out.println("Cas limite avec matière nulle");
        System.out.println("");
        String[] matieres15 = null;
        double[] coefficients15 = null;
        int nbNotes15 = 5;
        Etudiant etudiant15 = new Etudiant("toto", matieres15, coefficients15, nbNotes15);
        System.out.println(etudiant15.meilleurNote());

        System.out.println(" ");
        System.out.println(" ");
    }

    public static void testToString() {
        System.out.println("");
        System.out.println("## Tests de To String");
        System.out.println("");
        System.out.println("Cas normal avec trois matières");
        System.out.println("");
        String[] matieres16 = {"Math", "Physique", "Chimie"};
        double[] coefficients16 = {0.3, 0.4, 0.3};
        int nbNotes16 = 5;
        Etudiant etudiant16 = new Etudiant("toto", matieres16, coefficients16, nbNotes16);
        System.out.println(etudiant16.toString());
        System.out.println("");
        System.out.println("Cas limite avec zéro matière");
        System.out.println("");
        String[] matieres17 = {};
        double[] coefficients17 = {};
        int nbNotes17 = 5;
        Etudiant etudiant17 = new Etudiant("toto", matieres17, coefficients17, nbNotes17);
        System.out.println(etudiant17.toString());
        System.out.println("");
        System.out.println("Cas limite avec matières nulles");
        System.out.println("");
        String[] matieres18 = null;
        double[] coefficients18 = null;
        int nbNotes18 = 5;
        Etudiant etudiant18 = new Etudiant("toto", matieres18, coefficients18, nbNotes18);
        System.out.println(etudiant18.toString());
        System.out.println(" ");
        System.out.println(" ");
    }
}