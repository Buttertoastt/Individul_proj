package com.company;
import java.util.*;

public class Quiz {
    public ArrayList<quizQuestion> quizQuestionsSet;
    public Quiz(){

        quizQuestionsSet = new ArrayList<quizQuestion>();
        String q = " What is the second Harry Potter book called? Harry Potter &";
        String [] a = {"The Goblet of Wizzards" , "The Cursed Child" , "The Chamber of Secrets" , "Half-Blood Prince"};
        quizQuestionsSet.add(new quizQuestion(q, a, "The Chamber of Secrets"));
        q = "In The Hobbit, what sort of creature is Smaug?";
        a = new String[]{"Dragon", "Wyvern", "Snake", "Rabbit"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Dragon"));
        q = "The most sold book in the world.?";
        a =a = new String[] {"Bible", "Dictionary", "Travel guides", "Coding for dummies"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Bible"));
        q = "Who was the author of the famous storybook ‘Alice’s Adventures in Wonderland'?";
        a  = new String[]{"Rudyard Kipling", "John Keats", "Lewis Carroll", "H G Wells"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Lewis Carroll"));
        q = "Name the book which opens with the line ‘All children, except one grew up’?";
        a  = new String[]{"The Railway Children", "Winnie the Poo", "Jungle book", "Peter Pan"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Peter Pan"));
        q = "Who wrote the famous 1855 poem ‘The Charge of the Light Brigade’?";
        a  = new String[]{"Lord Alfred Tennyson", "Christopher Marlowe", "Johannes Gutenberg","René Descartes"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Lord Alfred Tennyson"));
        q = "Which is the first Harry Potter book?";
        a  = new String[]{"HP and the Goblet of Fire", "HP and the Philosopher’s Stone", "HP and the Chamber of Secrets", "HP and the God of small Things"};
        quizQuestionsSet.add(new quizQuestion(q, a, "HP and the Philosopher’s Stone"));
        q = "What was the nationality of Robert Louis Stevenson, writer of ‘Treasure Island'? ";
        a = new String[]{"Scottish", "Welsh", "Irish", "French"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Scottish"));
        q = "What is the book ‘Lord of the Flies’ about";
        a = new String[]{"A round trip around the USA","A swarm of killer flies", "Schoolboys on the desert island", "None of the above"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Schoolboys on the desert island"));
        q = "Which book won the first Man Booker Prize?";
        a = new String[]{"Troubles", "Something to Answer For", "The Conservationist","Heat and Dust"};
        quizQuestionsSet.add(new quizQuestion(q, a, "Something to Answer For"));
        q = "Who wrote the fantasy novel ‘The Lord of the Rings'?";
        a = new String[]{"J. R. R. Tolkien", "Peter Jackson", "S. Lewis", "J. K. Rowling "};
        quizQuestionsSet.add(new quizQuestion(q, a, "J. R. R. Tolkien"));
        Collections.shuffle(quizQuestionsSet, new Random());
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        int score = 0;
        //Question generation
        for (int question =0; question<5; question++){
            System.out.println(quizQuestionsSet.get(question).getQuizQuestion());
            int numOptions = quizQuestionsSet.get(question).getOptions().size();

            //Show options available for each question
            for(int option= 0; option < numOptions; option++){
                System.out.println((option + 1)+": "+ quizQuestionsSet.get(question).getOptions().get(option));
            }
            int userChoice = sc.nextInt();
            ArrayList<String> optionSet =
                    quizQuestionsSet.get(question).getOptions();
            String correctOption = quizQuestionsSet.get(question).getAnswer();
            int correctOptionIndex = optionSet.indexOf(correctOption);
            if (userChoice == correctOptionIndex+1){
                score++;
            }
        }
        //sc.close();
        System.out.println("You scored: " + score + "/5\n");
        //System.out.println("To retry the quiz reply: quiz, test me\nTo get book recommendations reply, recommendation, rec, book\n");
    }

}
