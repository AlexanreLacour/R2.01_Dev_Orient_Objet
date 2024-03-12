import question.Question;
import question.Quiz;
import question.ChoiceQuestion;
/**
 * ScenarioQuestion
 */
public class ScenarioQuestion {

    /** The total number of tests executed. */
    static int nbTests = 0;
    
    /** The number of tests passed. */
    static int nbOK = 0;

    public static void main(String[] args) {
        //testQuestion();
        testChoiceQuestion();
        //testQuiz();

        System.out.println("Résultat final : " + nbOK + " / " + nbTests + " tests passés.");
    }

    public static void testQuestion(){
        System.out.println("### Test Question ###");
        System.out.println();

        System.out.println();
        System.out.println("\t- Test Setter:");
        System.out.println();

        System.out.println("test 1");
        Question question1 = new Question();
        question1.setText("Quelle est la capitale de la France ?");
        question1.setAnswer("Paris");
        testReponse(question1.getText(), "Quelle est la capitale de la France ?", false);
        testReponse(question1.getAnswer(), "Paris", false);

        System.out.println("test 2");
        Question question2 = new Question();
        question2.setText("Quelle est la capitale de l'Allemagne ?");
        question2.setAnswer("Berlin");
        testReponse(question2.getText(), "Quelle est la capitale de l'Allemagne ?", false);
        testReponse(question2.getAnswer(), "Berlin", false);


        System.out.println();
        System.out.println("\t - Test Constructeur et GetAnswer :");
        System.out.println();
        System.out.println("Test Cas Normaux :");
        System.out.println();
        
        
        Question q1 = new Question("", "");
        testReponse(q1.getAnswer(), "",false);

        Question q2 = new Question("Qu'est-ce que 2 + 2 ?", "4");
        testReponse(q2.getAnswer(), "4",false);

        Question q3 = new Question("Quelle est la capitale de l'Allemagne ?", "berlin");
        testReponse(q3.getAnswer(), "berlin",false);

        Question q4 = new Question("Quel est le symbole du sodium ?", "Na");
        testReponse(q4.getAnswer(), "Na",false);

        Question q5 = new Question("Qu'est-ce que 10 divisé par 2 ?", "5");
        testReponse(q5.getAnswer(), "5",false);

        System.out.println();
        System.out.println("Test Cas Limite :");
        System.out.println();

        Question q6 = new Question("Quelle est la capitale de la France ?", "");
        testReponse(q6.getAnswer(), "",false);

        Question q7 = new Question("Quelle est la capitale de la France ?", "   ");
        testReponse(q7.getAnswer(), "   ",false);

        Question q8 = new Question("Quelle est la capitale de la France ?", "P@ris");
        testReponse(q8.getAnswer(), "P@ris",false);

        Question q9 = new Question("", "");
        testReponse(q9.getAnswer(), "", false);

        System.out.println();
        System.out.println("Test Cas Erreur :");
        System.out.println();

        Question q10 = new Question(null, "Paris");
        testReponse(q10.getAnswer(), "Paris", true);

        Question q11 = new Question("Quelle est la capitale de la France ?", null);
        testReponse(q11.getAnswer(), null, true);

        Question q12 = new Question(null, null);
        testReponse(q12.getAnswer(), null, true);

        System.out.println();
        System.out.println("\t - Test CheckAnswer :");
        System.out.println();

        Question check1 = new Question("Quelle est la capitale de la France ?", "Paris");
        testReponsebool(check1.checkAnswer("Paris"), true, false);

        Question check2 = new Question("Quelle est la capitale de l'Espagne ?", "Madrid");
        testReponsebool(check2.checkAnswer("Madrid"), true, false);
    }

    public static void testReponse(String saisie, String reponse, boolean isErrorExpected){
        if(isErrorExpected){
            System.out.println("OK");
            nbOK++;
        }else{
            if(saisie.equals(reponse)){
                System.out.println("OK");
                nbOK++;
            }else{
                System.out.println("ERROR");
            }
        }
        nbTests++;
    }

    public static void testReponsebool(boolean saisie, boolean reponse, boolean isErrorExpected){
        if(isErrorExpected){
            System.out.println("OK");
            nbOK++;
        }else{
            if(saisie == reponse){
                System.out.println("OK");
                nbOK++;
            }else{
                System.out.println("ERROR");
            }
        }
        nbTests++;
    }

    public static void testChoiceQuestion(){
        
    }

    public static void testQuiz(){
        
    }

}
