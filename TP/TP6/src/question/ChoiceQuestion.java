package question;

import java.util.ArrayList;

/**
 * ChoiceQuestion
 */
public class ChoiceQuestion extends Question {
    private ArrayList<String> choices;

    /**
     * Represents a multiple-choice question.
     * Inherits from the Question class.
     */
    public ChoiceQuestion(String text) {
        super(text, ""); /* Chainage explicite */
        this.choices = new ArrayList<String>();
    }
    
    /**
     * Adds a choice to the multiple-choice question.
     * 
     * @param choice the choice to add
     * @param correct true if the choice is correct, false otherwise
     */
    public void addChoice(String choice, boolean correct) {
        if (choice != null) {
            this.choices.add(choice);
            if (correct) {
                int num = this.choices.size();
                //num += 1;
                this.setAnswer(String.valueOf(num));
            }
        }else{
            System.out.println("Error: choice ne peut pas etre null");
        }
    }

    /**
     * Displays the question and its choices.
     * Overrides the display method from the superclass.
     * Prints the index and content of each choice.
     */
    public void display() {
        super.display(); /* Lancement du display hérité */
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i+1) +" : " + this.choices.get(i));
        }
    }
}