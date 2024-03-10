package mail;

/**
 * The MailItem class represents a mail item.
 * It contains information such as sender, recipient, and message content.
 */
public class MailItem {
    /** The name of the sender of the mail item. */
    private String from;

    /** The name of the recipient of the mail item. */
    private String to;

    /** The message content of the mail item. */
    private String message;

    /**
     * Constructs a new MailItem object with the specified sender, recipient, and message content.
     * 
     * @param from the name of the sender
     * @param to the name of the recipient
     * @param message the message content of the mail item
     */
    public MailItem(String from, String to, String message){
        if((from != null) & (to != null) & (message != null)){
            this.from = from;
            this.to = to;
            this.message = message;
        }else{
            System.out.println("Merci de saisir des parametres valides !");
            this.from = "";
            this.to = "";
            this.message = "";
        }
    }
    
    /**
     * Retrieves the name of the sender.
     * 
     * @return the sender's name
     */
    public String getFrom(){
        return this.from;
    }

    /**
     * Retrieves the name of the recipient.
     * 
     * @return the recipient's name
     */
    public String getTo(){
        return this.to;
    }

    /**
     * Retrieves the message content of the mail item.
     * 
     * @return the message content
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Prints the details of the mail item.
     */
    public void print(){
        System.out.println("");
        System.out.println("---------------------------");
        System.out.println("Mail de " + this.from + " vers " + this.to);
        System.out.println("Message : ");
        System.out.println("\t" + this.message);
        System.out.println("---------------------------");
        System.out.println("");
    }
}
