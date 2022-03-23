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
        while(!objective.contains(exit)){
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
            System.out.println("\nNo books borrowed");
        }
        if(user1.getTempMovieList().size()>0){
            System.out.println("Movies borrowed:");
            for (int i = 0; i < user1.getTempMovieList().size(); i++) {
                System.out.println(user1.getTempMovieList().get(i).getMovieDetails());
            }
        }
        else{
            System.out.println("\nNo movies borrowed");
        }
        System.out.println("Enjoy, until next time!");

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
        else if(objective.contains(request)) {
            System.out.println("Would you like to request for a book or a movie?");
            setObjective(chatBot);
            if(objective.contains(browseBooks)){
                System.out.println("What book would you like to search for? (Enter title)");
                //Book tempB = new Book();
                searchByTitle(chatBot, user1, library);
            }
            else if(objective.contains(browseMovies)){
                System.out.println("What movie would you like to search for? (Enter title)");
                //Movie tempM = new Movie();
                searchByTitleMovie(chatBot, user1, gallery);
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
            if(s.contains(browseMovies)){
                objective = browseMovies;
            }
            else if(s.equalsIgnoreCase(browseBooks)){
                objective = browseBooks;
            }
            else if(s.equalsIgnoreCase(trivia)){
                objective = trivia;
            }
            else if(s.equalsIgnoreCase(request)){
                objective = request;
            }
            else if(s.equalsIgnoreCase(exit)){
                objective = exit;
            }
            else{
                objective = unclear;
            }
        }
    }
    public static void searchByTitle(ChatBot chatBot, Person user1 , Library library) throws IOException{
        Book b = new Book();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        parse = new ParseNLP(reader.readLine());
        ArrayList<String> option = parse.getStringList();
        int i = 0;
        for(String s: option){
            //String a = s.toLowerCase();
            //String c = library.getBookList().get(i).getTitle().toLowerCase();
            //if(c.contains(a)){
            String a = library.getBookList().get(i).getTitle();
            if(s.equalsIgnoreCase(a)){
                System.out.println("Would you like to add "+ a + " to your checkout list?");
                if(chatBot.testReaction(reader.readLine())){
                    b = library.getBookList().get(i);
                    user1.updateTempBookList(b);
                    System.out.println(b.getTitle() + " successfully added to checkout!");
                }

            }
            i++;
        }
        if(b.getTitle() == null){
            System.out.println("Apologies, book not found in library");
        }
    }
    public static void searchByTitleMovie(ChatBot chatBot, Person user1,Gallery gallery) throws IOException{
        Movie m = new Movie();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        parse = new ParseNLP(reader.readLine());
        ArrayList<String> option = parse.getStringList();
        int i = 0;
        for(String s: option){
            System.out.println(s);

            //String a = s.toLowerCase();
            //String c = gallery.getMovieList().get(i).getTitle().toLowerCase();
            //if(c.contains(a)){
            String a = gallery.getMovieList().get(i).getTitle();
            if(s.equalsIgnoreCase(a)){
                System.out.println("Would you like to add "+ a + " to your checkout list?");
                if(chatBot.testReaction(reader.readLine())){
                    m = gallery.getMovieList().get(i);
                    user1.updateTempMovieList(m);
                    System.out.println(m.getTitle() + " successfully added to checkout!");
                }
            }
            i++;
        }
        if(m.getTitle() == null){
            System.out.println("Apologies, movie not found in gallery");
        }
    }
}
