import java.util.ArrayList;

import mail.AntiSpam;
import mail.MailClient;
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
        //testHowManyMailItems();
        //testGetNextMailItems();
        //testPost();
        //testAntiSpam();
        testMailClient();

        System.out.println("Résultat final (pour les tests automatisés) : " + nbOK + " / " + nbTests + " tests passés.");
    }

    /**
     * Test method for howManyMailItems.
     */
    public static void testHowManyMailItems() {
        System.err.println("###Test de How Many Mail Items : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        MailServer testItem = new MailServer(null);
        
        MailItem item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(item);

        testHowManyMailItemsCase(testItem, 1, "Tata");
        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer(null);

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
        MailServer testItem = new MailServer(null);
        
        MailItem item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(item);
        MailItem item2 = new MailItem("Toto", "Titi", "Hello World");
        testItem.post(item2);
        MailItem item3 = new MailItem("Toto", "Tutu", "Hello World");
        testItem.post(item3);

        testGetNextMailItemsCase(testItem, item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer(null);

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
        MailServer testItem = new MailServer(null);
        
        MailItem item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(item);
        MailItem item2 = new MailItem("Toto", "Titi", "Hello World");
        testItem.post(item2);
        MailItem item3 = new MailItem("Toto", "Tutu", "Hello World");
        testItem.post(item3);

        testPostCase(testItem, item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        item = new MailItem("", "", "");
        testItem.post(item);
        testItem = new MailServer(null);

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

    /**
     * Test method for AntiSpam.
     */
    public static void testAntiSpam() {
        System.err.println("###Test de AntiSpam : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        
        ArrayList<String> filters = new ArrayList<String>();
        filters.add("spam");
        AntiSpam antiSpam = new AntiSpam(filters);
        
        testCasAntiSpam(antiSpam, true, "This is a spam message");
        testCasAntiSpam(antiSpam, false, "This is a normal message");
        
        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        antiSpam = new AntiSpam(null);
        
        testCasAntiSpam(antiSpam, false, null);
        System.out.println("");
    }

    /**
     * Test method for AntiSpam.
     * 
     * @param antiSpam the AntiSpam instance
     * @param result the expected result
     * @param message the message to scan
     */
    public static void testCasAntiSpam(AntiSpam antiSpam, boolean result, String message){
        if(antiSpam.scan(message) == result){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tErreur !");
        }
        nbTests++;
    }

    /**
     * Test method for MailClient.
     */
    public static void testMailClient() {
        System.err.println("###Test de MailClient : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        
        MailServer server = new MailServer(new ArrayList<String>());
        MailClient client = new MailClient(server, "Alice");
        
        client.sendMailItem("Bob", "Hello Bob");
        testMailClientCase(client, "Alice", "Bob", "Hello Bob");
        
        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        client = new MailClient(null, null);
        
        testMailClientCase(client, "", "", "");
        System.out.println("");
    }

    /**
     * Test method for MailClient.
     * 
     * @param client the MailClient instance
     * @param from the expected sender
     * @param to the expected recipient
     * @param message the expected message
     */
    public static void testMailClientCase(MailClient client, String from, String to, String message){
        MailItem item = client.getNextMailItem();
        if(item != null && item.getFrom().equals(from) && item.getTo().equals(to) && item.getMessage().equals(message)){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tErreur !");
        }
        nbTests++;
    }

}
