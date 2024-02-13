package mail;
/**
 * MailItem
 */
public class MailItem {
    private String from;
    private String to;
    private String message;

    public static void main(String[] args) {
        String from = "Toto";
        String to = "Tata";
        String message = "Hello World";

        MailItem test = new MailItem(from, to, message);

        test.print();
    }

    public MailItem(String from, String to, String message){
        if((from!=null)&(to !=null)&(message!=null)){
            this.from = from;
            this.to = to;
            this.message = message;
        }else{
            System.out.println("Veuillez mettre des parametres valides !");
            this.from ="";
            this.to = "";
            this.message = "";
        }
    }
    
    public String getFrom(){
        return this.from;
    }

    public String getTo(){
        return this.to;
    }

    public String getMessage(){
        return this.message;
    }

    public void print(){
        System.out.println("");
        System.out.println("---------------------------");
        System.out.println("Mail de " + this.from + " vers " + this.to);
        System.out.println("Contenue : ");
        System.out.println("\t" + this.message);
        System.out.println("---------------------------");
        System.out.println("");
    }
}