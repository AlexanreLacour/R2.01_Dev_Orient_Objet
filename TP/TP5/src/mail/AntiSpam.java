package mail;
import java.util.Iterator; 
import java.util.ArrayList;


/**
 * The AntiSpam class represents a spam filter that scans messages for spam keywords.
 * It stores a list of filters and provides methods to scan messages, add new filters, and display the list of filters.
 */
public class AntiSpam{
    private ArrayList<String> filters; 

    
    /**
     * Constructs an AntiSpam object with the specified list of filters.
     * 
     * @param filters the list of filters to be used for spam detection
     * @throws IllegalArgumentException if the filters parameter is null
     */
    public AntiSpam(ArrayList<String> filters){
        if((filters != null)){
            this.filters = new ArrayList<String>(); 
            for(String s : filters){
                this.filters.add(s);                
            }  
        }else{
            System.err.println("Le paramatre n'est pas valide.");
            this.filters = new ArrayList<String>(); 
        }
    }

    /**
     * Scans the specified message for spam keywords.
     * 
     * @param message the message to be scanned
     * @return true if the message contains any of the spam keywords, false otherwise
     */
    public boolean scan(String message){
        boolean result = false; 
        if((message != null)){
            Iterator<String> it = this.filters.iterator(); 
            while((it.hasNext()) && (!result)){
                if(message.indexOf(it.next())> -1){
                    result = true; 
                }
            }
        }else{
            System.err.println("Le paramatre n'est pas valide.");
        }
        return result;
    }

    /**
     * Adds a new filter to the list of filters.
     * 
     * @param f the filter to be added
     */
    public void add(String f){
        if((f != null) && (!f.equals(""))){
            this.filters.add(f); 
        }else{
            System.err.println("Le paramatre n'est pas valide.");
        }
        
    }

    /**
     * Displays the list of filters.
     * 
     * @return the list of filters
     */
    public String toString(){
        String result; 
        result = "Les mots consideres comme etant des filtres spam sont : ";
        for(String s : this.filters){
            result += "- ";
            result += s; 
            result += "\n"; 
        }
        return result; 
    }

}