package question;
/**
 * Question
 */
/**
 * The Question class represents a question with its corresponding answer.
 */
public class Question {
    private String text;
    private String answer;

    /**
     * Constructs an empty Question object.
     */
    public Question() {
        text = "";
        answer = "";
    }

    /**
     * Constructs a Question object with the specified text and answer.
     * 
     * @param text   the text of the question
     * @param answer the answer to the question
     */
    public Question(String text, String answer) {
        if ((text != null) && (answer != null)) {
            this.text = text;
            this.answer = answer;
        } else {
            this.text = "";
            this.answer = "";
            System.out.println("Error: text and answer cannot be null");
        }
    }

    /**
     * Main method to test the Question class.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Question q = new Question("Quelle est la couleur du cheval blanc de Henry IV?", "blanc");
        q.display();
        System.out.println("Reponse: " + q.checkAnswer("blanc"));
        System.out.println("Reponse: " + q.checkAnswer("noir"));
    }

    /**
     * Gets the text of the question.
     * 
     * @return the text of the question
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the question.
     * 
     * @param text the text of the question
     */
    public void setText(String text) {
        if (text != null) {
            this.text = text;
        } else {
            System.out.println("Error: text cannot be null");
        }
    }

    /**
     * Sets the answer to the question.
     * 
     * @param answer the answer to the question
     */
    public void setAnswer(String answer) {
        if (answer != null) {
            this.answer = answer;
        } else {
            System.out.println("Error: answer cannot be null");
        }
    }

    /**
     * Checks if the given response matches the answer to the question.
     * 
     * @param response the response to check
     * @return true if the response is correct, false otherwise
     */
    public boolean checkAnswer(String response) {
        boolean result = false;
        if (response != null) {
            result = response.equalsIgnoreCase(this.answer);
        } else {
            System.out.println("Error: response cannot be null");
        }
        return result;
    }

    /**
     * Gets the answer to the question.
     * 
     * @return the answer to the question
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Displays the text of the question.
     */
    public void display() {
        System.out.println(text);
    }

    /**
     * Gets the text of the question.
     * 
     * @return the text of the question
     * @throws UnsupportedOperationException if the method is not implemented
     */
    public String getQuestionText() {
        throw new UnsupportedOperationException("Unimplemented method 'getQuestionText'");
    }
}