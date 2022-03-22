import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static ParseNLP parse;
    static String browseMovies = "movies";
    static String browseBooks = "books";
    static String trivia = "trivia";
    static String request = "request";
    static String objective = "";
    static String sentiment = "Neutral";

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        ChatBot chatBot = new ChatBot();
        Person user1 = new Person();
        PCA pca = new PCA(user1.getUserVector());
        System.out.println(chatBot.getStatement(0));

        //System.out.println(option.size());
        while(!objective.equalsIgnoreCase("exit")){
            System.out.println("Would you like to: browse books, browse movies, play trivia, or request an item?");
            parse = new ParseNLP(reader.readLine());
            ArrayList<String> option = parse.getStringList();
            for (String s:option) {
                if(s.equalsIgnoreCase(browseMovies)){
                    System.out.println("You have selected: browse movies, is that right?");
                    boolean yes = chatBot.testReaction(reader.readLine()); //can pass string here instead
                    if (yes) {
                        objective = browseMovies;
                    }
                }
                else if(s.equalsIgnoreCase(browseBooks)){
                    System.out.println("You have selected: browse books, is that right?");
                    boolean yes = chatBot.testReaction(reader.readLine()); //can pass string here instead
                    if (yes) {
                        objective = browseBooks;
                    }
                }
                else if(s.equalsIgnoreCase(trivia)){
                    System.out.println("You have selected: trivia, is that right?");
                    boolean yes = chatBot.testReaction(reader.readLine()); //can pass string here instead
                    if (yes) {
                        objective = trivia;
                    }
                }
                else if(s.equalsIgnoreCase(request)){
                    System.out.println("You have selected: request a specific item, is that right?");
                    boolean yes = chatBot.testReaction(reader.readLine()); //can pass string here instead
                    if (yes) {
                        objective = request;
                    }
                }
            }
            mainMenu(chatBot, user1, pca);
        }

    }

    public static void mainMenu(ChatBot chatBot, Person user1, PCA pca) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(objective.equalsIgnoreCase(trivia)) {
            //TODO implement trivia , Rich
        }
        else if(objective.equalsIgnoreCase(browseBooks)) {
            user1.setUserVector();
            user1.setPcaVector(pca.getStandardUser());
            user1.setTopThree(pca.getTopThree());
            chatBot.loopGeneraTitle(user1 ,pca,pca.getTopThree(), false);
            System.out.println("Exit");
            objective = "";
        }
        else if(objective.equalsIgnoreCase(browseMovies)) {
            user1.setUserVector();
            user1.setPcaVector(pca.getStandardUser());
            user1.setTopThree(pca.getTopThree());
            chatBot.loopGeneraTitleMovie(user1 ,pca,pca.getTopThree(), false);
            objective = "";
        }
        else if(objective.equalsIgnoreCase(request)) {
            System.out.println("Would you like to request for a book or a movie?");
            //Todo implement request
        }
        System.out.println("Thank you for using this service, would you like to continue browsing or exit?");
        if(!chatBot.testReaction(reader.readLine())){
            objective = "exit";
        }
    }
}
