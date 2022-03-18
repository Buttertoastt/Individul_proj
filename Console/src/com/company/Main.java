import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ParseNLP parse;
    static String browseMovies = "movies";
    static String browseBooks = "books";
    static String trivia = "trivia";
    static String request = "request";
    static String objective = "";
    static String sentiment = "Neural";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        ChatBot chatBot = new ChatBot();
        Person user1 = new Person();
        System.out.println(chatBot.getStatement(0));
        System.out.println("Would you like to: browse books, browse movies, play trivia, or request an item?");
        parse = new ParseNLP(sc.nextLine());
        ArrayList<String> option = parse.getStringList();
        for (String s:option) {
            if(s.equalsIgnoreCase(browseMovies)){
                System.out.println("You have selected: browse movies, is that right?");
                parse = new ParseNLP(sc.nextLine());
                parse.getSentiment();
                if (sentiment != "Negative") {
                    objective = browseMovies;
                    break;
                }
            }
            else if(s.equalsIgnoreCase(browseBooks)){
                System.out.println("You have selected: browse books, is that right?");
                parse = new ParseNLP(sc.nextLine());
                parse.getSentiment();
                if (sentiment != "Negative") {
                    objective = browseBooks;
                    break;
                }
            }
            else if(s.equalsIgnoreCase(trivia)){
                System.out.println("You have selected: trivia, is that right?");
                parse = new ParseNLP(sc.nextLine());
                sentiment = parse.getSentiment();
                if (sentiment != "Negative") {
                    objective = trivia;
                    break;
                }
            }
            else if(s.equalsIgnoreCase(request)){
                System.out.println("You have selected: request a specific item, is that right?");
                parse = new ParseNLP(sc.nextLine());
                parse.getSentiment();
                if (sentiment != "Negative") {
                    objective = request;
                    break;
                }
            }
        }
        if(objective.equalsIgnoreCase(trivia)) {
            //TODO implement trivia , Rich
        }
        else if(objective.equalsIgnoreCase(browseBooks)) {
            //TODO implement loopGeneraTitle
        }
        else if(objective.equalsIgnoreCase(browseMovies)) {
            //TODO implement loopGeneraTitleMovie()
        }
        else if(objective.equalsIgnoreCase(request)) {
            //TODO implement search forSpecificTitle()
        }



    }
}
