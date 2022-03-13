package com.company;

import java.text.ParseException;
import java.util.*;
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Parse parse = new Parse();
        Library library = new Library();
        ChatBot chatBot = new ChatBot();
        Person user1 = new Person();
        Patterns p1 = new Patterns();
        //Quiz quiz = new Quiz();
        //PCA pca = new PCA(user1.getUserVector()); //create pca object using user1 person object
        String in = "";
        int gate;
        /*
        System.out.println(p1.getWelcome());
        user1.setName(sc.next());
        System.out.println(user1.getName() + p1.getIntro());
        System.out.println(user1.getName() + p1.getRobot(sc.next()));
        System.out.println(user1.getName() + p1.getRobot(sc.nextLine()));
        System.out.println(user1.getName() + p1.getRobot(sc.nextLine()));
        System.out.println(user1.getName() + p1.getRobot(sc.nextLine()));
        */
        System.out.println(chatBot.getStatement(0));
        System.out.println(chatBot.getQuestion(0));
        user1.setName(parse.getWord());
        System.out.println(chatBot.getQuestion(1, user1.getName()));
        user1.setAge(parse.getWord());
        System.out.println(chatBot.getQuestion(2, user1.getName()));
        user1.setOccupation(parse.getWord());
        System.out.println(chatBot.getQuestion(3, user1.getName()));
        user1.setFavoriteBook(sc.nextLine());
        System.out.println(chatBot.getQuestion(4, user1.getName()));
        user1.setFavoriteGenera(sc.nextLine());
        /*
        user1.setUserVector();
        user1.setPcaVector(pca.getStandardUser());
        user1.setTopThree(pca.getTopThree());
        chatBot.loopGeneraTitle(user1,pca,pca.getTopThree(), false);
        */
        //System.out.println(chatBot.getStatement(1));
        //in = sc.nextLine();

        gate = 1;

        chatBot.mainMenu(user1);
        System.out.println(chatBot.getStatement(14));
        if(user1.getTempList().size() > 0){
            for (int i = 0; i < user1.getTempList().size(); i++) {
                System.out.println(user1.getTempList().get(i).getBookDetails());
            }
        }
        else{
            System.out.println("No books checked out.");
        }
        System.out.println("We look forward to your next visit!");//Output templist or permlist? or something else.

    }

}
