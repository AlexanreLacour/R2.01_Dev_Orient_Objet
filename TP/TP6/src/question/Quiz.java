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


    public Question pickAtRandom() {
        Random r = new Random();
        int index = r.nextInt(questionList.size());
        return questionList.get(index);
    }

    public String getQuestionText(int index) {
        return null;
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