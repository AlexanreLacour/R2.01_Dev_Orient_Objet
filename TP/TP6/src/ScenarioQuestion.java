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
        testQuestion();
        //testChoiceQuestion();
        //testQuiz();

        System.out.println("Résultat final : " + nbOK + " / " + nbTests + " tests passés.");
    }

    public static void testQuestion(){
        System.out.println("### Test Question ###");
        System.out.println();
        System.out.println("Test Cas Normaux :");
        System.out.println();
        
        
        Question q1 = new Question("", "");
        checkAnswer(q1.getAnswer(), "");

        
        Question q = new Question("Quelle est la capitale de la France ?", "Paris");
        checkAnswer(q.getAnswer(), "Paris");

        
        Question q3 = new Question("Qu'est-ce que 2 + 2 ?", "4");
        checkAnswer(q3.getAnswer(), "4");

        
        Question q4 = new Question("Quelle est la couleur du ciel ?", "Bleu");
        checkAnswer(q4.getAnswer(), "Bleu");

        
        Question q5 = new Question("Quelle est la capitale de l'Allemagne ?", "berlin");
        checkAnswer(q5.getAnswer(), "berlin");

        
        Question q6 = new Question("Quelle est la capitale de l'Italie ?", "  Rome  ");
        checkAnswer(q6.getAnswer(), "  Rome  ");

        
        Question q7 = new Question("Quel est le symbole du sodium ?", "Na");
        checkAnswer(q7.getAnswer(), "Na");

        
        Question q8 = new Question("Quelle est la plus grande planète de notre système solaire ?", "Jupiter");
        checkAnswer(q8.getAnswer(), "Jupiter");

        
        Question q9 = new Question("Qu'est-ce que 10 divisé par 2 ?", "5");
        checkAnswer(q9.getAnswer(), "5");

        
        Question q10 = new Question("QuElLe eSt lA cApItAlE dU cAnAdA ?", "Ottawa");
        checkAnswer(q10.getAnswer(), "Ottawa");

        System.out.println();
        System.out.println("Test Cas Limite :");
        System.out.println();

        System.out.println();
        System.out.println("Test Cas Limite :");
        System.out.println();

        // Test case 11: Question avec une réponse vide
        Question q11 = new Question("Quelle est la capitale de la France ?", "");
        checkAnswer(q11.getAnswer(), "");

        // Test case 12: Question avec une question vide
        Question q12 = new Question("", "Paris");
        checkAnswer(q12.getAnswer(), "Paris");

        // Test case 13: Question avec une réponse null
        Question q13 = new Question("Quelle est la capitale de la France ?", null);
        checkAnswer(q13.getAnswer(), null);

        // Test case 14: Question avec une question null
        Question q14 = new Question(null, "Paris");
        checkAnswer(q14.getAnswer(), "Paris");

        // Test case 15: Question avec une réponse contenant uniquement des espaces
        Question q15 = new Question("Quelle est la capitale de la France ?", "   ");
        checkAnswer(q15.getAnswer(), "   ");

        // Test case 16: Question avec une question contenant uniquement des espaces
        Question q16 = new Question("   ", "Paris");
        checkAnswer(q16.getAnswer(), "Paris");

        // Test case 17: Question avec une réponse contenant des caractères spéciaux
        Question q17 = new Question("Quelle est la capitale de la France ?", "P@ris");
        checkAnswer(q17.getAnswer(), "P@ris");

        // Test case 18: Question avec une question contenant des caractères spéciaux
        Question q18 = new Question("Qu@lle est la capit@le de l@ Fr@nce ?", "Paris");
        checkAnswer(q18.getAnswer(), "Paris");

        // Test case 19: Question avec une réponse vide et une question vide
        Question q19 = new Question("", "");
        checkAnswer(q19.getAnswer(), "");

        // Test case 20: Question avec une réponse null et une question null
        Question q20 = new Question(null, null);
        checkAnswer(q20.getAnswer(), null);


    }

    public static void checkAnswer(String saisie, String reponse){
        if(saisie.equals(reponse)){
            System.out.println("OK");
            nbOK++;
        }else{
            System.out.println("ERROR");
        }
        nbTests++;
    }

    public static void testChoiceQuestion(){

    }

    public static void testQuiz(){
        
    }

}
