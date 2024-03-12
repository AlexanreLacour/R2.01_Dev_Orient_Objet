import question.Question;
import question.Quiz;
import question.ChoiceQuestion;
/**
 * ScenarioQuestion
 */
public class ScenarioQuestion {
    public static void main(String[] args) {
        testQuestion();
        //testChoiceQuestion();
        //testQuiz();
    }

    public static void testQuestion(){
        Question q = new Question();
        q.setText("Who was the inventor of Java?");
        q.setAnswer("James Gosling");
        q.display();
        System.out.println("Answer: " + q.checkAnswer("James Gosling"));
        System.out.println("Answer: " + q.checkAnswer("James gosling"));
        System.out.println("Answer: " + q.checkAnswer("James"));
        System.out.println("Answer: " + q.checkAnswer("gosling"));
        System.out.println("Answer: " + q.checkAnswer("ogsling"));
    }

    public static void testChoiceQuestion(){

    }

    public static void testQuiz(){
        
    }

}
