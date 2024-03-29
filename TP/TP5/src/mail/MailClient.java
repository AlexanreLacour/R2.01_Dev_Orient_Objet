package mail;

import java.util.ArrayList;

/**
 * MailClient
 */
public class MailClient {
    private String user;
    private MailServer server; 

    /**
     * Constructs a mail client with a given server and user.
     * 
     * @param server the mail server
     * @param user the user
     */
    public MailClient (MailServer server, String user){
        if((server != null) && (user != null)){
            this.server = server; 
            this.user = user; 
        }else{
            System.err.println("Un ou plusieurs paramètre(s) n'est/ne sont pas valide(s)."); 
            this.user = ""; 
            this.server = new MailServer(new ArrayList<String>()); 
        }
    }

    /**
     * Returns the next mail item for the current user.
     * 
     * @return the next mail item for the current user
     */
    public MailItem getNextMailItem(){
        return this.server.getNextMailItem(this.user); 
    }

    /**
     * Prints the next mail item for the current user.
     * If there is a new mail item, it prints the content of the mail item.
     * If there is no new mail item, it prints "Pas de nouveau message".
     */
    public void printNextMailItem(){
        MailItem m = this.server.getNextMailItem(this.user); 
        if(m != null){
            m.print(); 
        }else{
            System.out.println("Pas de nouveau message"); 
        }
    }


    /**
     * Sends a mail item to the specified recipient.
     * 
     * @param to The email address of the recipient.
     * @param message The content of the email message.
     */
    public void sendMailItem(String to, String message){
        if((to != null) && (message != null)){
            MailItem m = new MailItem(this.user, to, message); 
            this.server.post(m); 
        }else{
            System.err.println("Un ou plusieurs paramètre(s) n'est/ne sont pas valide(s)."); 
        }
    }
}