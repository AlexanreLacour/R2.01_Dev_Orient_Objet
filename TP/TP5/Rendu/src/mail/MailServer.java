package mail;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The MailServer class represents a simple mail server.
 * It allows users to send and receive mail items.
 */
public class MailServer {

    /** The list of mail items stored in this mail server. */
    private ArrayList<MailItem> items;

    /** The list of filters stored in this mail server. */
    private AntiSpam AntiSpam;

    /**
     * This method MailServer() is a constructor which allows you to create a list (ArrayList) of items (MailItem object)
     */
    public MailServer(ArrayList<String> filters){
        this.items = new ArrayList<MailItem>();
        if(filters != null){
            this.AntiSpam = new AntiSpam(filters);        
        }else{
            System.err.println("Le paramatre n'est pas valide.");
            this.AntiSpam = new AntiSpam(new ArrayList<String>());
        }
    }

    public static void main(String[] args) {
        
    }

    /**
     * Returns the number of mail items for a specific recipient.
     * 
     * @param who the recipient's email address
     * @return the number of mail items for the specified recipient
     */
    public int howManyMailItems(String who){
        int count = 0;
        if(who != null){
            for(MailItem m : this.items){
                if (m.getTo().equals(who)) {
                    count++;
                }
            }
        }else{
            System.out.println("Merci de saisir des parametres valides!");
            count = -1;
        }
        return count;
    }

    /**
     * Retrieves the next mail item for a specific recipient.
     * 
     * @param who the recipient's email address
     * @return the next mail item for the specified recipient, or null if no mail item is found
     */
    public MailItem getNextMailItem(String who){
        MailItem nextItem = null;
        boolean found = false;
        MailItem currentMailItem;

        if(who != null){
            Iterator<MailItem> it =  this.items.iterator();
            while ((it.hasNext()) & (!found)){
                currentMailItem = it.next();
                if(currentMailItem.getTo().equals(who)){
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

    /**
     * This method adds the MailItem type object passed as a parameter to the list of items
     * @param item the MailItem type object
     */
    public void post(MailItem item){
        if (item != null){
            if (this.AntiSpam.scan(item.getMessage())){
                String message_spam = "[SPAM]" + item.getMessage(); 
                MailItem it = new MailItem(item.getFrom(), item.getTo(), message_spam);
                this.items.add(it);
            }else{
                this.items.add(item); 
            } 
        }else{
            System.out.println("Le parametre n'est pas valide.");
        }
    }
}
