package question;

import java.util.ArrayList;

/**
 * ChoiceQuestion
 */
public class ChoiceQuestion extends Question {
    private ArrayList<String> choices;

    public ChoiceQuestion(String text) {
        super(text, ""); /* Chainage explicite */
        this.choices = new ArrayList<String>();
    }

    public static void main(String[] args) {
        ChoiceQuestion q = new ChoiceQuestion("Quelle est la couleur du cheval blanc de Henry IV?");
        q.addChoice("blanc", true);
        q.addChoice("noir", false);
        q.display();
        System.out.println("Reponse: " + q.checkAnswer("1"));
        System.out.println("Reponse: " + q.checkAnswer("2"));
    }

    public void addChoice(String choice, boolean correct) {
        if (choice != null) {
            this.choices.add(choice);
            if (correct) {
                int num = this.choices.size();
                num += 1;
                this.setAnswer(String.valueOf(num));
            }
        }else{
            System.out.println("Error: choice ne peut pas etre null");
        }
    }

    public void display() {
        super.display(); /* Lancement du display hérité */
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i+1) +" : " + this.choices.get(i));
        }
    }
}