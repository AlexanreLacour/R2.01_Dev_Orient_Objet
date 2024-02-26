package mail;

import java.util.Iterator;
import mail.MailItem;

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
        MailItem nextItem = null;
        boolean found = false;
        MailItem currentMailItem;

        if(user != null){
            Iterator<MailItem> it =  this.items.iterator();
            while ((it.hasNext()) & (!found)){
                currentMailItem = it.next();
                if(currentMailItem.getTo().equals(user)){
                    nextItem = currentMailItem;
                    it.remove();
                    found = true;
                }
            }
        }else{
            System.out.println("Merci de saisir des parametres valides!");
        }

        return nextItem;
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