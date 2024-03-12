/**
 * Question
 */
public class Question {
    private String text;
    private String answer;

    public Question() {
        text = "";
        answer = "";
    }

    public Question(String text, String answer) {
        if((text != null) && (answer != null)){
            this.text = text;
            this.answer = answer;
        }else{
            this.text = "";
            this.answer = "";
            System.out.println("Error: text et reponse ne peuvent pas etre null");
        }
    }

    public static void main(String[] args) {
        Question q = new Question("Quelle est la couleur du cheval blanc de Henry IV?", "blanc");
        q.display();
        System.out.println("Reponse: " + q.checkAnswer("blanc"));
        System.out.println("Reponse: " + q.checkAnswer("noir"));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(text!=null){
            this.text = text;
        }else{
            System.out.println("Error: text ne peut pas etre null");
        }
        
    }

    public void setAnswer(String answer) {
        if(answer!=null){
            this.answer = answer;
        }else{
            System.out.println("Error: answer ne peut pas etre null");
        }
    }

    public boolean checkAnswer(String response) {
        boolean result = false;
        if(response!=null){
            result = response.equalsIgnoreCase(this.answer);
        }else{
            System.out.println("Error: response ne peut pas etre null");
        }
        return result;
    }

    public String getAnswer() {
        return answer;
    }

    public void display() {
        System.out.println(text);
    }
}