import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GUI<JTimer> implements ActionListener {
    //
    static PCA pca;
    static ParseNLP parse;
    static String browseMovies = "movies";
    static String browseBooks = "books";
    static String trivia = "trivia";
    static String request = "request";
    static String objective = "";
    static String sentiment = "Neural";
    static String userMsg;
    static String cbMsg;

    static boolean IN = true;
    static boolean outterRun = true;
    static boolean innerRun = true;
    static Trivia myTrivia;
    //
    Timer timer;
    int cb_user = 0;
    int numClicks = 0;
    JLabel label;
    JFrame frame;
    JButton btnSend;
    JPanel panel;
    static JTextArea textArea;
    JScrollPane scrollPane;
    static JTextArea textInput;

    JButton btnClear;

    int TOP = 300;
    int BOT = 300;
    int LEFT = 300;
    int RIGHT = 300;
    public GUI() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JJ\\Desktop\\DT\\Programing\\esp32\\Hang Board September 2021\\kivy serial read\\chip.ico"));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(TOP,LEFT,BOT,RIGHT));
        panel.setBackground(new Color(0, 204, 255));
        panel.setPreferredSize(new Dimension(450, 650));

        //panel.setLayout(new GridLayout(10,6));


        label = new JLabel(String.valueOf(numClicks));
        textArea = new JTextArea(100,6);
        textArea.setPreferredSize(new Dimension(400, 300));
        //textArea.setColumns(9);
        //textArea.setRows(7);
        //textArea.setAlignmentY(10);
        //textArea.setAlignmentX(7);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        //scrollPane.setBounds(LEFT,TOP, );
        textInput = new JTextArea(1,8);
        //textInput.setColumns(5);
        //textInput.setRows(1);

        //scrollPane.setPreferredSize(new Dimension(350, 400));

        btnSend = new JButton("Send");
        btnSend.addActionListener(this);

        panel.add(scrollPane);
        panel.add(textInput);
        panel.add(btnSend);
        //GridLayout gridLayout = new GridLayout(10,10);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Chat Bot");
        frame.pack();
        frame.setVisible(true);

    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        new GUI();
        Library library = new Library();
        ChatBot chatBot = new ChatBot();
        Person user1 = new Person();
        getCBM(chatBot.getStatement(0));

        while(outterRun) {

            while(innerRun) {
                getCBM("Would you like to: browse books, browse movies, play trivia, or request an item?");
                getUserIN();
                parse = new ParseNLP(userMsg);
                ArrayList<String> option = parse.getStringList();
                if (option.contains(browseMovies)) {
                    getCBM("You have selected: browse movies, is that right?");
                    getUserIN();
                    boolean yes = chatBot.testReaction(userMsg); //can pass string here instead
                    if (yes) {
                        objective = browseMovies;
                        break;
                    } else {
                        continue;
                    }
                } else if (option.contains(browseBooks)) {

                    getCBM("You have selected: browse books, is that right?");
                    getUserIN();
                    boolean yes = chatBot.testReaction(userMsg); //can pass string here instead
                    if (yes) {
                        objective = browseBooks;
                        break;
                    } else {
                        continue;
                    }

                } else if (option.contains(trivia)) {
                    getCBM("You have selected: trivia, is that right?");
                    getUserIN();
                    boolean yes = chatBot.testReaction(userMsg); //can pass string here instead
                    if (yes) {
                        objective = trivia;
                        break;
                    } else {
                        continue;
                    }
                } else if (option.contains(request)) {
                    getCBM("You have selected: request a specific item, is that right?");
                    getUserIN();
                    boolean yes = chatBot.testReaction(userMsg); //can pass string here instead
                    if (yes) {
                        objective = request;
                        break;
                    } else {
                        continue;
                    }
                }
            }
            System.out.println("Done initial branch: " + objective);
            outterRun = true;
            innerRun = true;
            while(innerRun) {
                if (objective.equalsIgnoreCase(trivia)) {
                    getCBM("Now starting Trivia :)");
                    myTrivia = new Trivia();
                    myTrivia.play();

                } else if (objective.equalsIgnoreCase(browseBooks)) {
                    cbMsg = "What is your favorite genera?";
                    getCBM(cbMsg);
                    getUserIN();
                    user1.setFavoriteGenera(userMsg);
                    pca = new PCA(user1.getUserVector());
                    user1.setUserVector();
                    user1.setPcaVector(pca.getStandardUser());
                    user1.setTopThree(pca.getTopThree());
                    chatBot.loopGeneraTitle(user1, pca, pca.getTopThree(), false);
                } else if (objective.equalsIgnoreCase(browseMovies)) {
                    cbMsg = "What is your favorite genera?";
                    getCBM(cbMsg);
                    getUserIN();
                    user1.setFavoriteBook(userMsg);
                    pca = new PCA(user1.getUserVector());
                    user1.setUserVector();
                    user1.setPcaVector(pca.getStandardUser());
                    user1.setTopThree(pca.getTopThree());
                    chatBot.loopGeneraTitle(user1, pca, pca.getTopThree(), false);
                } else if (objective.equalsIgnoreCase(request)) {
                    cbMsg = "Would you like to request for a book or a movie?";
                    getCBM(cbMsg);
                    getUserIN();
                    ParseNLP parseNLP = new ParseNLP(userMsg);
                    ArrayList<String> words = parseNLP.getWords();
                    for(String word : words) {
                        if(library.byTitle(word).getTitle() == word) {
                            cbMsg = "Added " + word + " to cart";
                            continue;
                        }
                        else {
                            cbMsg = "Sorry, we don't have that one";
                            continue;
                        }
                    }
                }
                cbMsg = "Thank you for using this service, would you like to continue browsing?";
                getCBM(cbMsg);
                getUserIN();
                boolean yes = chatBot.testReaction(userMsg); //can pass string here instead
                if (yes) {
                    innerRun = true;
                    outterRun = true;
                    break;
                } else {
                    innerRun = false;
                    outterRun = false;
                    break;

                }
            }

        }
    }

    public static void getCBM(String m) throws InterruptedException {
        Thread.sleep(10);
        cbMsg = "Chat Bot: "+m+"\n";
        textArea.append(cbMsg);
    }
    public static void getUserIN() throws InterruptedException {
        while(IN) {
            Thread.sleep(10);
        }
        userMsg = textInput.getText().toLowerCase(Locale.ROOT);
        textArea.append("User: "+userMsg + "\n");
        textInput.setText("");
        IN = true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        IN = false;
    }
}
