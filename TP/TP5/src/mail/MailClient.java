package mail;
/**
 * MailClient
 */
public class MailClient {
    private String user;

    public static void main(String[] args) {
        MailServer server = new MailServer();
        MailClient client = new MailClient(server, "alice");
        MailClient client2 = new MailClient(server, "bob");
        client.sendMailItem("bob", "Hello Bob, how are you?");
        client2.printNextMailItem();
    }
    
    public MailClient(MailServer server, String user){
        this.user = user;
    }

    public MailItem getNextMailItem(){
        return null;
    }

    public void printNextMailItem(){
        MailItem item = getNextMailItem();
        if(item == null){
            System.out.println("Pas de Nouveau Mail.");
        }else{
            item.print();
        }
    }

    public void sendMailItem(String to, String message){
        MailItem item = new MailItem(this.user, to, message);
    }
}