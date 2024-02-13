/**
 * TestMailItem
 */
import mail.MailItem;
public class TestMailItem {
    static int nbTests = 0, nbOK = 0;
    public static void main(String[] args) {
        testMailItem();

        System.out.println("Résultat final (pour les test auto): " + nbOK + " / " + nbTests + " tests passés.");
    }

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

    public static void testGetter(){
        System.out.println("### Test des Getter : ");
    }

    public static void testPrint(){

    }
}
//