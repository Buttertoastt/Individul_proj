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
        Quiz quiz = new Quiz();
        PCA pca = new PCA(user1.getUserVector()); //create pca object using user1 person object
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
        System.out.println(chatBot.getQuestion(5, user1.getName()));
        System.out.println(chatBot.getStatement(1));
        in = sc.nextLine();

        gate = 1;
        while(gate == 1){
            //System.out.println("1");

            if(in.equalsIgnoreCase("random title")){
                System.out.println(chatBot.getStatement(13));
                Book ran = library.getTitleRandom();
                System.out.println(ran.getBookDetails());
                //System.out.println(chatBot.getStatement(3));
                if(chatBot.testReaction(sc.nextLine())){ //
                    user1.updateTempList(ran);
                }
                //System.out.println(user1.getTempList());
            }
            else if(in.equalsIgnoreCase("random book in genre")){
                System.out.println("Search by genre: ");
                Book ran = library.getGeneraRand(sc.nextLine());
                System.out.println(chatBot.getStatement(13));
                System.out.println(ran.getBookDetails());
                if(chatBot.testReaction(sc.nextLine())){ //
                    user1.updateTempList(ran);
                }
            }
            else if(in.equalsIgnoreCase("title")){
                System.out.println("Search by title: ");
                Book ran = library.byTitle(sc.nextLine());
                System.out.println(chatBot.getStatement(13));
                System.out.println(ran.getBookDetails());
                if(chatBot.testReaction(sc.nextLine())){ //
                    user1.updateTempList(ran);
                }
            }
            else if(in.equalsIgnoreCase("author")){
                System.out.println("Search by author: ");
                Book ran = library.getAuthRand(sc.nextLine());


                if(ran.getTitle() == null){
                    System.out.println(chatBot.getStatement(9));
                }
                else{
                    //System.out.println(chatBot.getStatement(3));
                    System.out.println(chatBot.getStatement(13));
                    System.out.println(ran.getBookDetails());
                    if(chatBot.testReaction(sc.nextLine())){ //
                        user1.updateTempList(ran);
                    }
                }
            }
            else if(in.equalsIgnoreCase("pages")){
                System.out.println("Search by pages: ");
                Book ran = library.byPages(sc.nextLine());
                if(ran.getTitle() == null){
                    System.out.println(chatBot.getStatement(9));
                }
                else{
                    //System.out.println(chatBot.getStatement(3));
                    System.out.println(chatBot.getStatement(11));
                    System.out.println(ran.getBookDetails());
                    if(chatBot.testReaction(sc.nextLine())){ //
                        user1.updateTempList(ran);
                    }
                }
            }
            else if(in.equalsIgnoreCase("pca")){
                System.out.println("Quick questions!");
                System.out.println("These potshots won't stop until you accept at least one genre!");
                user1.setUserVector();
                user1.setPcaVector(pca.getStandardUser());
                //System.out.println("pass1");
                user1.setTopThree(pca.getTopThree());
                //System.out.println("pass2");
                chatBot.loopGeneraTitle(user1,pca,pca.getTopThree(), false);
            }
            else if(in.equalsIgnoreCase("quiz")){
                quiz.play();
            }

            else if(in.equalsIgnoreCase("getcartlist")){
                System.out.println(user1.getTempList().toString());
            }

            else{
                System.out.println("Service unavailable");

            }
            System.out.println(chatBot.getQuestion(6, user1.getName()));
            in = sc.nextLine();
            //System.out.println("in: "+ in);
            if(in.equalsIgnoreCase("yes")){
                System.out.println(chatBot.getQuestion(5, user1.getName()));
                in = sc.nextLine();
            }
            else{
                gate = 0;
                break;
            }
            System.out.println();



        }
        System.out.println(chatBot.getStatement(14));
        for (int i = 0; i < user1.getTempList().size(); i++) {
            System.out.println(user1.getTempList().get(i).getBookDetails());
        }
        System.out.println("We look forward to your next visit!");//Output templist or permlist? or something else.

    }

}
