import mail.MailItem;
import mail.MailServer;

/**
 * ScenarioMailServer
 */
public class ScenarioMailServer {
    static int nbTests = 0, nbOK = 0;

    public static void main(String[] args) {
        testHowManyMailItems();
        testGetNextMailItems();
        testPost();

        System.out.println("Résultat final (pour les test auto): " + nbOK + " / " + nbTests + " tests passés.");
    }

    private static void testHowManyMailItems() {

        
        System.err.println("###Test de How Many Mail Items : ");
        System.out.println("");
        System.out.println("\tCas Normaux : ");
        MailServer testItem = new MailServer();
        

        MailItem Item = new MailItem("Toto", "Tata", "Hello World");
        testItem.post(Item);

        casTestHowManyMailItems(testItem, 1, "Tata");
        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer();

        casTestHowManyMailItems(testItem, 0, "Toto");
        System.out.println("");
    }

    private static void casTestHowManyMailItems(MailServer server, int resultat, String who){
        if(server.howManyMailItems(who) == resultat){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tError !");
        }
        nbTests++;
    }

    private static void testGetNextMailItems() {
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

        casTestGetNextMailItems(testItem, Item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        
        testItem = new MailServer();

        casTestGetNextMailItems(testItem, null, "Toto");
        System.out.println("");
    }

    public static void casTestGetNextMailItems(MailServer server, MailItem resultat, String who){
        if(server.getNextMailItem(who) == resultat){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tError !");
        }
        nbTests++;
    }

    private static void testPost() {
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

        casTestPost(testItem, Item2, "Titi");

        System.out.println("");
        System.out.println("\tCas d'erreur : ");
        Item = new MailItem("", "", "");
        testItem.post(Item);
        testItem = new MailServer();

        casTestPost(testItem, null, "Toto");
        System.out.println("");
    }

    public static void casTestPost(MailServer server, MailItem resultat, String who){
        if(server.getNextMailItem(who) == resultat){
            System.out.println("\tOK");
            nbOK++;
        }else{
            System.out.println("\tError !");
        }
        nbTests++;
    }
}