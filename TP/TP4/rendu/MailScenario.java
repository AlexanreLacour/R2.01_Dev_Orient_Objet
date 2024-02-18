import mail.MailItem;
import mail.MailServer;

/**
 * The MailScenario class is used to test the functionality of MailServer class methods.
 */
public class MailScenario {
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
        testHowManyMailItems();
        testGetNextMailItems();
        testPost();

        System.out.println("Résultat final (pour les tests automatisés) : " + nbOK + " / " + nbTests + " tests passés.");
    }

    /**
     * Test method for howManyMailItems.
     */
    public static void testHowManyMailItems() {
        System.err.println("###Test de How Many Mail Items : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        MailServer testItem = new MailServer();
        
        MailItem Item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(Item);

        testHowManyMailItemsCase(testItem, 1, "Tata");
        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer();

        testHowManyMailItemsCase(testItem, 0, "Toto");
        System.out.println("");
    }

    /**
     * Test method for howManyMailItems.
     * 
     * @param server the mail server instance
     * @param result the expected result
     * @param who the recipient's name
     */
    public static void testHowManyMailItemsCase(MailServer server, int result, String who){
        if(server.howManyMailItems(who) == result){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tErreur !");
        }
        nbTests++;
    }

    /**
     * Test method for getNextMailItems.
     */
    public static void testGetNextMailItems() {
        System.err.println("###Test de Get Next Mail Items : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        MailServer testItem = new MailServer();
        
        MailItem Item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(Item);
        MailItem Item2 = new MailItem("Toto", "Titi", "Hello World");
        testItem.post(Item2);
        MailItem Item3 = new MailItem("Toto", "Tutu", "Hello World");
        testItem.post(Item3);

        testGetNextMailItemsCase(testItem, Item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer();

        testGetNextMailItemsCase(testItem, null, "Toto");
        System.out.println("");
    }

    /**
     * Test method for getNextMailItems.
     * 
     * @param server the mail server instance
     * @param result the expected result
     * @param who the recipient's name
     */
    public static void testGetNextMailItemsCase(MailServer server, MailItem result, String who){
        if(server.getNextMailItem(who) == result){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tErreur !");
        }
        nbTests++;
    }

    /**
     * Test method for post.
     */
    public static void testPost() {
        System.err.println("###Test de Post : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        MailServer testItem = new MailServer();
        
        MailItem Item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(Item);
        MailItem Item2 = new MailItem("Toto", "Titi", "Hello World");
        testItem.post(Item2);
        MailItem Item3 = new MailItem("Toto", "Tutu", "Hello World");
        testItem.post(Item3);

        testPostCase(testItem, Item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        Item = new MailItem("", "", "");
        testItem.post(Item);
        testItem = new MailServer();

        testPostCase(testItem, null, "Toto");
        System.out.println("");
    }

    /**
     * Test method for post.
     * 
     * @param server the mail server instance
     * @param result the expected result
     * @param who the recipient's name
     */
    public static void testPostCase(MailServer server, MailItem result, String who){
        if(server.getNextMailItem(who) == result){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tErreur !");
        }
        nbTests++;
    }
}
