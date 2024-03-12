package question;
import java.util.ArrayList;
import java.util.Random;

/**
 * Quiz
 */
public class Quiz {

    private ArrayList<Question> questionList;;

    public Quiz() {
        this.questionList = new ArrayList<>();
    }

    public Quiz(ArrayList<Question> list) {
        this.questionList = list;
    }

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

    public Question pickAtRandom() {
        Random r = new Random();
        int index = r.nextInt(questionList.size());
        return questionList.get(index);
    }

    public String getQuestionText(int index) {
        return questionList.get(index).getText();
    }

    public int getQNumber() {
        return questionList.size();
    }

    public void add(Question q) {
        this.questionList.add(q);
    }

    public void display() {
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println("Question " + (i + 1) + " : " + questionList.get(i).getText());
        }
    }
}