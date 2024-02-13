public class EssaiRationnel {
    static int nbTests = 0, nbOK = 0;

    public static void main(String[] args) {
        testConstructeur();
        testSetter();
        testInverse();
        testAjout();
        testSoustrait();
        testMultiplie();
        testEgale();
        testToString();

        System.out.println("Résultat final : " + nbOK + " / " + nbTests + " tests passés.");
    }

    public static void testConstructeur() {
        System.out.println("=== Test du Constructeur ===");

        // Cas -3/-4
        Rationnel r1 = new Rationnel(-3, -4);
        afficheResultat(r1, 3, 4);

        // Cas 0/0
        Rationnel r2 = new Rationnel(0, 0);
        afficheResultat(r2, 0, 0);

        // Cas 3/0
        Rationnel r3 = new Rationnel(3, 0);
        afficheResultat(r3, 0, 0);

        // Cas 12/18
        Rationnel r4 = new Rationnel(12, 18);
        afficheResultat(r4, 2, 3);

        // Cas nominal : 2/3
        Rationnel r5 = new Rationnel(2, 3);
        afficheResultat(r5, 2, 3);

        // Cas avec dénominateur < 0 : -5/2
        Rationnel r6 = new Rationnel(-5, -2);
        afficheResultat(r6, 5, 2);

        // Cas avec dénominateur = 0 : affiche message d'erreur
        Rationnel r7 = new Rationnel(4, 0);
        afficheResultat(r7, 0, 0);
    }

    public static void testSetter() {
        System.out.println("=== Test du Setter ===");

        // Cas nominal : modifier le numérateur
        Rationnel r1 = new Rationnel(3, 5);
        r1.setNumerateur(7);
        afficheResultat(r1, 7, 5);

        // Cas avec numérateur nul : ne devrait pas changer
        Rationnel r2 = new Rationnel(2, 4);
        r2.setNumerateur(0);
        afficheResultat(r2, 0, 4);

        // Cas avec dénominateur nul : ne devrait pas changer
        Rationnel r3 = new Rationnel(1, 3);
        r3.setNumerateur(6);
        afficheResultat(r3, 6, 3);

        // Cas avec numérateur et dénominateur nuls : ne devrait pas changer
        Rationnel r4 = new Rationnel(0, 0);
        r4.setNumerateur(2);
        afficheResultat(r4, 0, 0);

        // Cas avec dénominateur < 0 : le numérateur devrait changer de signe
        Rationnel r5 = new Rationnel(4, -7);
        r5.setNumerateur(8);
        afficheResultat(r5, -8, -7);

        // Cas avec dénominateur = 0 : affiche message d'erreur
        Rationnel r6 = new Rationnel(2, 3);
        r6.setNumerateur(5);
        afficheResultat(r6, 2, 3);
    }

    public static void testInverse() {
        System.out.println("=== Test de la Méthode Inverse ===");

        // Cas nominal : inverse de 3/5
        Rationnel r1 = new Rationnel(3, 5);
        Rationnel inverse1 = r1.inverse();
        afficheResultat(inverse1, 5, 3);

        // Cas avec numérateur nul : ne devrait pas changer
        Rationnel r2 = new Rationnel(0, 8);
        Rationnel inverse2 = r2.inverse();
        afficheResultat(inverse2, 0, 8);

        // Cas avec dénominateur nul : affiche message d'erreur
        Rationnel r3 = new Rationnel(7, 0);
        Rationnel inverse3 = r3.inverse();
        afficheResultat(inverse3, 0, 0);

        // Cas avec dénominateur < 0 : inverse de -2/3
        Rationnel r4 = new Rationnel(-2, 3);
        Rationnel inverse4 = r4.inverse();
        afficheResultat(inverse4, -3, 2);

        // Cas avec dénominateur = 0 : affiche message d'erreur
        Rationnel r5 = new Rationnel(4, 0);
        Rationnel inverse5 = r5.inverse();
        afficheResultat(inverse5, 0, 0);
    }

    public static void testAjout() {
        System.out.println("=== Test de la Méthode Ajout ===");

        // Cas nominal : addition de 2/3 et 3/4
        Rationnel r1 = new Rationnel(2, 3);
        Rationnel r2 = new Rationnel(3, 4);
        Rationnel resultat1 = r1.ajoute(r2);
        afficheResultat(resultat1, 17, 12);

        // Cas avec numérateur nul : addition de 0/5 et 1/2
        Rationnel r3 = new Rationnel(0, 5);
        Rationnel r4 = new Rationnel(1, 2);
        Rationnel resultat2 = r3.ajoute(r4);
        afficheResultat(resultat2, 1, 2);

        // Cas avec dénominateur nul : affiche message d'erreur
        Rationnel r5 = new Rationnel(7, 0);
        Rationnel r6 = new Rationnel(4, 3);
        Rationnel resultat3 = r5.ajoute(r6);
        afficheResultat(resultat3, 0, 0);

        // Cas avec dénominateur < 0 : addition de -1/2 et 3/4
        Rationnel r7 = new Rationnel(-1, 2);
        Rationnel r8 = new Rationnel(3, 4);
        Rationnel resultat4 = r7.ajoute(r8);
        afficheResultat(resultat4, 1, 4);

        // Cas avec dénominateur = 0 : affiche message d'erreur
        Rationnel r9 = new Rationnel(2, 3);
        Rationnel r10 = new Rationnel(4, 0);
        Rationnel resultat5 = r9.ajoute(r10);
        afficheResultat(resultat5, 0, 0);
    }

    public static void testSoustrait() {
        System.out.println("=== Test de la Méthode Soustrait ===");

        // Cas nominal : soustraction de 3/4 et 2/3
        Rationnel r1 = new Rationnel(3, 4);
        Rationnel r2 = new Rationnel(2, 3);
        Rationnel resultat1 = r1.soustrait(r2);
        afficheResultat(resultat1, 1, 12);

        // Cas avec numérateur nul : soustraction de 0/5 et 1/2
        Rationnel r3 = new Rationnel(0, 5);
        Rationnel r4 = new Rationnel(1, 2);
        Rationnel resultat2 = r3.soustrait(r4);
        afficheResultat(resultat2, -1, 2);

        // Cas avec dénominateur nul : affiche message d'erreur
        Rationnel r5 = new Rationnel(7, 0);
        Rationnel r6 = new Rationnel(4, 3);
        Rationnel resultat3 = r5.soustrait(r6);
        afficheResultat(resultat3, 0, 0);

        // Cas avec dénominateur < 0 : soustraction de -1/2 et 3/4
        Rationnel r7 = new Rationnel(-1, 2);
        Rationnel r8 = new Rationnel(3, 4);
        Rationnel resultat4 = r7.soustrait(r8);
        afficheResultat(resultat4, -5, 4);

        // Cas avec dénominateur = 0 : affiche message d'erreur
        Rationnel r9 = new Rationnel(2, 3);
        Rationnel r10 = new Rationnel(4, 0);
        Rationnel resultat5 = r9.soustrait(r10);
        afficheResultat(resultat5, 0, 0);
    }


    public static void testMultiplie() {
        System.out.println("=== Test de la Méthode Multiplie ===");
    
        // Cas nominal : 2/3 * 3/4 = 6/12
        Rationnel r1 = new Rationnel(2, 3);
        Rationnel r2 = new Rationnel(3, 4);
        Rationnel result1 = r1.multiplie(r2);
        afficheResultat(result1, 6, 12);
    
        // Cas avec numérateur et dénominateur négatifs : -2/3 * -3/4 = 6/12
        Rationnel r3 = new Rationnel(-2, -3);
        Rationnel r4 = new Rationnel(-3, -4);
        Rationnel result2 = r3.multiplie(r4);
        afficheResultat(result2, 6, 12);
    
        // Cas avec numérateur négatif : -2/3 * 3/4 = -6/12
        Rationnel r5 = new Rationnel(-2, 3);
        Rationnel r6 = new Rationnel(3, 4);
        Rationnel result3 = r5.multiplie(r6);
        afficheResultat(result3, -6, 12);
    
        // Cas avec dénominateur négatif : 2/3 * -3/4 = -6/12
        Rationnel r7 = new Rationnel(2, 3);
        Rationnel r8 = new Rationnel(-3, 4);
        Rationnel result4 = r7.multiplie(r8);
        afficheResultat(result4, -6, 12);
    
        // Cas avec zéro : 0/1 * 3/4 = 0/4
        Rationnel r9 = new Rationnel(0, 1);
        Rationnel r10 = new Rationnel(3, 4);
        Rationnel result5 = r9.multiplie(r10);
        afficheResultat(result5, 0, 4);
    
        // Cas avec dénominateur égal à zéro : affiche message d'erreur
        Rationnel r11 = new Rationnel(2, 3);
        Rationnel r12 = new Rationnel(0, 0);
        Rationnel result6 = r11.multiplie(r12);
        afficheResultat(result6, 0, 0);
    }
    
    public static void testEgale() {
        System.out.println("=== Test de la Méthode Egale ===");
    
        // Cas égaux : 2/3 est égal à 2/3
        Rationnel r1 = new Rationnel(2, 3);
        Rationnel r2 = new Rationnel(2, 3);
        boolean result1 = r1.egale(r2);
        afficheResultatEgale(result1, true);
    
        // Cas non égaux : 2/3 n'est pas égal à 3/4
        Rationnel r3 = new Rationnel(2, 3);
        Rationnel r4 = new Rationnel(3, 4);
        boolean result2 = r3.egale(r4);
        afficheResultatEgale(result2, false);
    
        // Cas avec numérateur négatif : -2/3 est égal à -2/3
        Rationnel r5 = new Rationnel(-2, 3);
        Rationnel r6 = new Rationnel(-2, 3);
        boolean result3 = r5.egale(r6);
        afficheResultatEgale(result3, true);
    
        // Cas avec dénominateur négatif : 2/3 n'est pas égal à -2/3
        Rationnel r7 = new Rationnel(2, 3);
        Rationnel r8 = new Rationnel(-2, 3);
        boolean result4 = r7.egale(r8);
        afficheResultatEgale(result4, false);
    
        // Cas avec zéro : 0/1 est égal à 0/2
        Rationnel r9 = new Rationnel(0, 1);
        Rationnel r10 = new Rationnel(0, 2);
        boolean result5 = r9.egale(r10);
        afficheResultatEgale(result5, true);
    
    }
    
    public static void testToString() {
        System.out.println("=== Test de la Méthode ToString ===");
    
        // Cas nominal : 2/3
        Rationnel r1 = new Rationnel(2, 3);
        String result1 = r1.toString();
        afficheResultatToString(result1, "2/3");
    
        // Cas avec numérateur négatif : -2/3
        Rationnel r2 = new Rationnel(-2, 3);
        String result2 = r2.toString();
        afficheResultatToString(result2, "-2/3");
    
        // Cas avec dénominateur négatif : 2/-3
        Rationnel r3 = new Rationnel(2, -3);
        String result3 = r3.toString();
        afficheResultatToString(result3, "-2/3");
    
        // Cas avec numérateur et dénominateur négatifs : -2/-3
        Rationnel r4 = new Rationnel(-2, -3);
        String result4 = r4.toString();
        afficheResultatToString(result4, "2/3");
    
        // Cas avec zéro : 0/1
        Rationnel r5 = new Rationnel(0, 1);
        String result5 = r5.toString();
        afficheResultatToString(result5, "0/1");
    
        // Cas avec dénominateur égal à zéro : gestion de null
        Rationnel r6 = new Rationnel(2, 0);
        String result6 = r6.toString();
        afficheResultatToString(result6, null);
    }    

    // Méthode utilitaire pour afficher le résultat du test
    private static void afficheResultat(Rationnel r, int numerateurAttendu, int denominateurAttendu) {
        nbTests++;
        if (r != null && r.getNumerateur() == numerateurAttendu && r.getDenominateur() == denominateurAttendu) {
            nbOK++;
            System.out.println("Test OK");
        } else {
            System.out.println("Test ERREUR");
        }
    }

    // Surcharge de la méthode utilitaire pour traiter la méthode toString
    private static void afficheResultatToString(String resultatAttendu, String resultatObtenu) {
        nbTests++;
        if ((resultatAttendu == null && resultatObtenu == null) || (resultatAttendu != null && resultatAttendu.equals(resultatObtenu))) {
            nbOK++;
            System.out.println("Test OK");
        } else {
            System.out.println("Test ERREUR");
        }
    }

    // Surcharge de la méthode utilitaire pour traiter la méthode egale
    private static void afficheResultatEgale(boolean resultatAttendu, Boolean resultatObtenu) {
        nbTests++;
        if (resultatAttendu == resultatObtenu) {
            nbOK++;
            System.out.println("Test OK");
        } else {
            System.out.println("Test ERREUR");
        }
    }

}
