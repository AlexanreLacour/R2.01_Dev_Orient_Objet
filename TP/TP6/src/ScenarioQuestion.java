import question.Question;
import question.Quiz;
import question.ChoiceQuestion;

/**
 * The `ScenarioQuestion` class represents a scenario for testing different types of questions and quizzes.
 * It contains methods to test various question types, such as `Question`, `ChoiceQuestion`, and `Quiz`.
 * The class also tracks the number of tests executed and the number of tests passed.
 */
public class ScenarioQuestion {

    /** The total number of tests executed. */
    static int nbTests = 0;
    
    /** The number of tests passed. */
    static int nbOK = 0;

    public static void main(String[] args) {
        //testQuestion();
        //testChoiceQuestion();
        testQuiz();

        System.out.println("Résultat final : " + nbOK + " / " + nbTests + " tests automatiques passés.");
    }


    /**
     * Tests the `Question` class.
     * 
     * The method tests the following methods of the `Question` class:
     * - The `setText` and `setAnswer` methods
     * - The `Question` constructor and the `getAnswer` method
     * - The `checkAnswer` method
     */
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
        testReponseBool(check1.checkAnswer("Paris"), true, false);

        Question check2 = new Question("Quelle est la capitale de l'Espagne ?", "Madrid");
        testReponseBool(check2.checkAnswer("Madrid"), true, false);
    }

    /**
     * Tests the test class.
     * @param saisie the user input
     * @param reponse the expected response
     * @param isErrorExpected true if an error is expected, false otherwise
     */
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

    /**
     * Tests the test class but for bool.
     * @param saisie the user input
     * @param reponse the expected response
     * @param isErrorExpected true if an error is expected, false otherwise
     */
    public static void testReponseBool(boolean saisie, boolean reponse, boolean isErrorExpected){
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

    /**
     * Tests the test class but for int.
     * @param saisie the user input
     * @param reponse the expected response
     * @param isErrorExpected true if an error is expected, false otherwise
     */
    public static void testReponseInt(int saisie, int reponse, boolean isErrorExpected){
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


    /**
     * Tests the `ChoiceQuestion` class.
     */
    public static void testChoiceQuestion(){
        System.out.println();
        System.out.println();
        System.out.println("### Test ChoiceQuestion ###");
        System.out.println();

        System.out.println();
        System.out.println("\t- Test addChoice & display & constructeur :");
        System.out.println();

        ChoiceQuestion question1 = new ChoiceQuestion("Quelle est la capitale de la France?");
        question1.addChoice("Paris", true);
        question1.addChoice("London", false);
        question1.addChoice("Berlin", false);

        question1.display();

        System.out.println();

        ChoiceQuestion question2 = new ChoiceQuestion("Quelle est la plus grande planete du systeme solaire?");
        question2.addChoice("Mars", false);
        question2.addChoice("Jupiter", true);
        question2.addChoice("Saturn", false);

        question2.display();

        System.out.println();

        ChoiceQuestion question3 = new ChoiceQuestion("Qui est l'auteur de 'Pride and Prejudice'?");
        question3.addChoice("Jane Austen", true);
        question3.addChoice("Emily Bronte", false);
        question3.addChoice("Charlotte Bronte", false);

        question3.display();

        System.out.println();
    }


    /**
     * Tests the `Quiz` class.
     */
    public static void testQuiz(){
        System.out.println();
        System.out.println();
        System.out.println("### Test Quiz ###");
        System.out.println();

        System.out.println();
        System.out.println("\t- Test add & display & constructeur :");
        System.out.println();

        Quiz q = new Quiz();
        q.add(new Question("What is the capital of France?", "Paris"));
        q.add(new Question("What is the capital of Germany?", "Berlin"));
        q.add(new Question("What is the capital of Italy?", "Rome"));
        q.add(new Question("What is the capital of Spain?", "Madrid"));
        q.add(new Question("What is the capital of Portugal?", "Lisbon"));
        q.display();
        System.out.println("Random question: " + q.pickAtRandom().getText());

        System.out.println();

        Quiz q2 = new Quiz();
        q2.add(new ChoiceQuestion("Quelle est la capitale de la France?"));
        q2.add(new ChoiceQuestion("Quelle est la plus grande planete du systeme solaire?"));
        q2.add(new ChoiceQuestion("Qui est l'auteur de 'Pride and Prejudice'?"));
        q2.display();
        System.out.println("Random question: " + q2.pickAtRandom().getText());

        System.out.println();

        Quiz q3 = new Quiz();
        q3.add(new ChoiceQuestion("Quelle est la capitale de la France?"));
        q3.add(new ChoiceQuestion("Quelle est la plus grande planete du systeme solaire?"));
        q3.add(new ChoiceQuestion("Qui est l'auteur de 'Pride and Prejudice'?"));
        q3.display();
        System.out.println("Random question: " + q3.pickAtRandom().getText());

        System.out.println();

        System.out.println();
        System.out.println("\t- Test getQuestion & getQNumber :");
        System.out.println();

        Quiz q4 = new Quiz();
        q4.add(new Question("What is the capital of France?", "Paris"));
        q4.add(new Question("What is the capital of Germany?", "Berlin"));
        q4.add(new Question("What is the capital of Italy?", "Rome"));
        q4.add(new Question("What is the capital of Spain?", "Madrid"));
        q4.add(new Question("What is the capital of Portugal?", "Lisbon"));
        testReponse(q4.getQuestionText(0), "What is the capital of France?", false);
        testReponse(q4.getQuestionText(1), "What is the capital of Germany?", false);
        testReponse(q4.getQuestionText(2), "What is the capital of Italy?", false);
        testReponse(q4.getQuestionText(3), "What is the capital of Spain?", false);
        testReponse(q4.getQuestionText(4), "What is the capital of Portugal?", false);
        testReponseInt(q4.getQNumber(), 5, false);

        System.out.println();

        Quiz q5 = new Quiz();
        q5.add(new ChoiceQuestion("Quelle est la capitale de la France?"));
        q5.add(new ChoiceQuestion("Quelle est la plus grande planete du systeme solaire?"));
        q5.add(new ChoiceQuestion("Qui est l'auteur de 'Pride and Prejudice'?"));
        testReponse(q5.getQuestionText(0), "Quelle est la capitale de la France?", false);
        testReponse(q5.getQuestionText(1), "Quelle est la plus grande planete du systeme solaire?", false);
        testReponse(q5.getQuestionText(2), "Qui est l'auteur de 'Pride and Prejudice'?", false);
        testReponseInt(q5.getQNumber(), 3, false);

    }

}
