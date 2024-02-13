/**
 * The ScenarioMailItem class is used to test the functionality of the MailItem class.
 */
import mail.MailItem;
public class ScenarioMailItem {
    /** The total number of tests executed. */
    static int nbTests = 0;

    /** The number of tests passed. */
    static int nbOK = 0;

    /**
     * The main method to run the test scenarios.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        testMailItem();
        testGetter();
        testPrint();

        System.out.println("Résultat final (pour les test auto): " + nbOK + " / " + nbTests + " tests passés.");
    }

    /**
     * Test method for MailItem constructor.
     */
    public static void testMailItem(){

        System.out.println("   ###TestMailItem : ");
        System.out.println("");
        System.out.println("\t TestCasNormaux : ");

        String from = "Toto";
        String to = "Tata";
        String message = "Hello World";

        MailItem testItem = new MailItem(from, to, message);
        testCasMailItem(testItem, true);

        from = "Titi";
        to = "Tutu";
        message = "dlrow olleh";
        testItem = new MailItem(from, to, message);
        testCasMailItem(testItem, true);
        System.out.println("");
        System.out.println("\t TestCasError : ");
        

        from = "";
        to = "";
        message = "";

        testItem = new MailItem(from, to, message);
        testCasMailItem(testItem, false);

    }

    /**
     * Test method for MailItem constructor.
     * 
     * @param test the mail item instance to test
     * @param result the expected result
     */
    public static void testCasMailItem(MailItem test, boolean result){
        Boolean verif = true;
        if((!test.getFrom().equals(""))&&(!test.getMessage().equals(""))&&(!test.getTo().equals(""))){
            verif = true;
        }else{
            verif = false;
        }

        if(verif == result){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tError !");
        }
        nbTests++;
    }

    /**
     * Test method for MailItem getters.
     */
    public static void testGetter(){

        String from = "Toto";
        String to = "Tata";
        String message = "Hello World";

        MailItem test = new MailItem(from, to, message);

        System.out.println("");
        System.out.println("### Test des Getter (test visuel) : ");
        System.out.println("");
        System.out.println("\tCas Normaux :");
        System.out.println("Expediteur attendu : " + from);
        System.out.println("\tObtenu : " + test.getFrom());
        System.out.println("Message attendu : " + message);
        System.out.println("\tObtenu : " + test.getMessage());
        System.out.println("Receveur attendu : " + to);
        System.out.println("\tObtenu : " + test.getTo());
        System.out.println("");

        from = "";
        to = "";
        message = "";

        test = new MailItem(from, to, message);
        
        System.out.println("\tCas Limite : ");
        System.out.println("Expediteur attendu : " + from);
        System.out.println("\tObtenu : " + test.getFrom());
        System.out.println("Message attendu : " + message);
        System.out.println("\tObtenu : " + test.getMessage());
        System.out.println("Receveur attendu : " + to);
        System.out.println("\tObtenu : " + test.getTo());
        System.out.println("");
    }

    /**
     * Test method for MailItem print method.
     */
    public static void testPrint(){
        String from = "Toto";
        String to = "Tata";
        String message = "Hello World";

        MailItem test = new MailItem(from, to, message);

        System.out.println("### Test de Print (test visuel) : ");
        System.out.println("");
        System.out.println("\tCas Normaux");
        test.print();
        System.out.println("");

        from = "";
        to = "";
        message = "";

        test = new MailItem(from, to, message);

        System.out.println("\tCas limite");
        test.print();
        System.out.println("");
        
        
    }
}
//