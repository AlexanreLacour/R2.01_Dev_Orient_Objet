package mail;
/**
 * MailServer
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MailServer {

    private ArrayList<MailItem> items;

    public MailServer(){
        this.items = new ArrayList<MailItem>();
    }

    public int howManyMailItems(String who){
        int ret = 0;
        if(who != null){
            for(MailItem m : this.items){
                if (m.getTo().equals(who)) {
                    ret = ret +1;
                }
            }
        }else{
            System.out.println("Veuillez mettre des parametres valides !");
            ret = -1;
        }
        return ret;
    }

    public MailItem getNextMailItem(String who){
        MailItem ret = null;
        boolean trouver = false;
        MailItem m;

        if(who != null){
            Iterator<MailItem> it =  this.items.iterator();
            while ((it.hasNext())&(!trouver)){
                m = it.next();
                if(m.getTo().equals(who)){
                    ret = m;
                    it.remove();
                    trouver = true;
                }

            }
        }else{
            System.out.println("Veuillez mettre des parametres valides !");
        }

        return ret;
    }

    public void post(MailItem item){
        if(item != null){
            this.items.add(item);
        }else{
            System.err.println("Veuillez mettre des parametres valides !");
        }
    }
}