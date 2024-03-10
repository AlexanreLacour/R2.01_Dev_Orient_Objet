package mail;
import java.util.Iterator; 
import java.util.ArrayList;

/**
 * 
 */
public class AntiSpam{
    private ArrayList<String> filters; 

    /**
     * 
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

    public static void main(String[] args) {

    }

    /**
     * 
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
     * 
     */
    public void add(String f){
        if((f != null) && (!f.equals(""))){
            this.filters.add(f); 
        }else{
            System.err.println("Le paramatre n'est pas valide.");
        }
        
    }

    /**
     * 
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