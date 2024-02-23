package mail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The MailServer class represents a simple mail server.
 * It allows users to send and receive mail items.
 */
public class MailServer {

    /** The list of mail items stored in this mail server. */
    private ArrayList<MailItem> items;

    /** The list of spams stored in this mail server. */
    private ArrayList<MailItem> spams;

    /** The list of spammers stored in this mail server. */
    private ArrayList<String> spammers;


    /**
     * Constructs a new MailServer object.
     */
    public MailServer(){
        this.items = new ArrayList<MailItem>();
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
     * Posts a mail item to this mail server.
     * 
     * @param item the mail item to be posted
     */
    public void post(MailItem item){
        if(item != null){
            this.items.add(item);
        }else{
            System.err.println("Merci de saisir des parametres valides!");
        }
    }
}
