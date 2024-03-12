package question;
import java.util.ArrayList;
import java.util.Random;

/**
 * Quiz
 */
public class Quiz {

    /**
     * The Quiz class represents a quiz with a list of questions.
     */
    private ArrayList<Question> questionList;;

    /**
     * Constructs an empty Quiz object.
     */
    public Quiz() {
        this.questionList = new ArrayList<>();
    }

    /**
     * Constructs a Quiz object with the specified list of questions.
     * 
     * @param list the list of questions
     */
    public Quiz(ArrayList<Question> list) {
        this.questionList = list;
    }

    /**
     * Main method to test the Quiz class.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.add(new Question("What is the capital of France?", "Paris"));
        q.add(new Question("What is the capital of Germany?", "Berlin"));
        q.add(new Question("What is the capital of Italy?", "Rome"));
        q.add(new Question("What is the capital of Spain?", "Madrid"));
        q.add(new Question("What is the capital of Portugal?", "Lisbon"));
        q.display();
        System.out.println("Random question: " + q.pickAtRandom().getText());
    }

    /**
     * Picks a question at random from the list of questions.
     * 
     * @return the question picked at random
     */
    public Question pickAtRandom() {
        Random r = new Random();
        int index = r.nextInt(questionList.size());
        return questionList.get(index);
    }

    /**
     * Checks the answer to the question at the specified index.
     * 
     * @param index  the index of the question
     * @return true if the answer is correct, false otherwise
     */
    public String getQuestionText(int index) {
        return questionList.get(index).getText();
    }

    /**
     * Gets the number of questions in the quiz.
     * 
     * @return the number of questions
     */
    public int getQNumber() {
        return questionList.size();
    }

    /**
     * Adds a question to the list of questions.
     * 
     * @param q the question to add
     */
    public void add(Question q) {
        this.questionList.add(q);
    }

    /**
     * Displays the list of questions.
     */
    public void display() {
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println("Question " + (i + 1) + " : " + questionList.get(i).getText());
        }
    }
}