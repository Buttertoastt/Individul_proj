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
    static String unclear = "unclear";
    static String exit = "exit";
    static String objective = "";

    static String sentiment = "Neutral";

    public static void main(String[] args) throws IOException{
        Library library = new Library();
        Gallery gallery = new Gallery();
        ChatBot chatBot = new ChatBot();
        Person user1 = new Person();
        PCA pca = new PCA(user1.getUserVector());
        System.out.println(chatBot.getStatement(0));

        //System.out.println(option.size());
        while(!objective.equalsIgnoreCase(exit)){
            System.out.println("Main menu: browse books, browse movies, play trivia, or request an item?");
            setObjective(chatBot);
            mainMenu(chatBot, user1, pca, library, gallery);
        }
        //Print books and movies borrowed during session.
        if(user1.getTempBookList().size()>0){
            System.out.println("Books borrowed:");
            for (int i = 0; i < user1.getTempBookList().size(); i++) {
                System.out.println(user1.getTempBookList().get(i).getBookDetails());
            }
        }
        else{
            System.out.println("\n No books borrowed");
        }
        if(user1.getTempMovieList().size()>0){
            System.out.println("Movies borrowed:");
            for (int i = 0; i < user1.getTempBookList().size(); i++) {
                System.out.println(user1.getTempMovieList().get(i).getMovieDetails());
            }
        }
        else{
            System.out.println("\n No movies borrowed");
        }

    }

    public static void mainMenu(ChatBot chatBot, Person user1, PCA pca, Library library, Gallery gallery) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(objective.equalsIgnoreCase(trivia)) {
            //TODO implement trivia , Rich
        }
        else if(objective.equalsIgnoreCase(browseBooks)) {
            user1.setUserVector();
            user1.setPcaVector(pca.getStandardUser());
            user1.setTopThree(pca.getTopThree());
            chatBot.loopGeneraTitle(user1 ,pca,pca.getTopThree(), false);
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
            setObjective(chatBot);
            if(objective.equalsIgnoreCase(browseBooks)){
                System.out.println("What book would you like to search for? (Enter title)");
                //Todo search by title
                //library.byTitle();
            }
            else if(objective.equalsIgnoreCase(browseMovies)){
                System.out.println("What movie would you like to search for? (Enter title)");
                //Todo search by title
                //gallery.byTitle();
            }
        }

        System.out.println("Thank you for using this service, would you like to continue browsing or exit?");
        setObjective(chatBot);


    }

    public static void setObjective(ChatBot chatBot) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
            else if(s.equalsIgnoreCase(exit)){
                objective = exit;
            }
            else{
                objective = unclear;
            }
        }
    }
}
