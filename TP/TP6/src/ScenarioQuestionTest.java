public static void testQuestion(){
    System.out.println("### Test Question ###");
    System.out.println();
    System.out.println("Test Cas Normaux :");
    System.out.println();
    
    // Test case 1: Question vide et réponse vide
    Question q1 = new Question("", "");
    checkAnswer(q1.getAnswer(), "");

    // Test case 2: Question avec des caractères spéciaux
    Question q2 = new Question("Quelle est la capitale de la France ?", "Paris");
    checkAnswer(q2.getAnswer(), "Paris");

    // Test case 3: Question avec des chiffres
    Question q3 = new Question("Qu'est-ce que 2 + 2 ?", "4");
    checkAnswer(q3.getAnswer(), "4");

    // Test case 4: Question avec plusieurs mots dans la réponse
    Question q4 = new Question("Quelle est la couleur du ciel ?", "Bleu");
    checkAnswer(q4.getAnswer(), "Bleu");

    // Test case 5: Question avec une réponse insensible à la casse
    Question q5 = new Question("Quelle est la capitale de l'Allemagne ?", "berlin");
    checkAnswer(q5.getAnswer(), "berlin");

    // Test case 6: Question avec des espaces avant et après dans la réponse
    Question q6 = new Question("Quelle est la capitale de l'Italie ?", "  Rome  ");
    checkAnswer(q6.getAnswer(), "  Rome  ");

    // Test case 7: Question avec des caractères spéciaux dans la réponse
    Question q7 = new Question("Quel est le symbole du sodium ?", "Na");
    checkAnswer(q7.getAnswer(), "Na");

    // Test case 8: Question avec plusieurs mots dans la question
    Question q8 = new Question("Quelle est la plus grande planète de notre système solaire ?", "Jupiter");
    checkAnswer(q8.getAnswer(), "Jupiter");

    // Test case 9: Question avec des chiffres dans la question
    Question q9 = new Question("Qu'est-ce que 10 divisé par 2 ?", "5");
    checkAnswer(q9.getAnswer(), "5");

    // Test case 10: Question avec une question insensible à la casse
    Question q10 = new Question("QuElLe eSt lA cApItAlE dU cAnAdA ?", "Ottawa");
    checkAnswer(q10.getAnswer(), "Ottawa");

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