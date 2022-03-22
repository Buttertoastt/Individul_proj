import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI<JTimer> implements ActionListener {
    //
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
        btnSend = new JButton("Send");
        btnSend.addActionListener(this);

        label = new JLabel(String.valueOf(numClicks));

        textArea = new JTextArea(100,2);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(150,TOP-50, 250,100);
        textInput = new JTextArea(1,2);
        textInput.setTabSize(2);

        scrollPane.setPreferredSize(new Dimension(450, 110));


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(TOP,LEFT,BOT,RIGHT));
        panel.setLayout(new GridLayout(4,2));
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textInput);
        panel.add(btnSend);
        panel.add(label);


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
        cbMsg = "Chat Bot:  " +chatBot.getStatement(0)+"\n";

        textArea.append(cbMsg);
        cbMsg = "Chat Bot: Would you like to: browse books, browse movies, play trivia, or request an item?\n";
        textArea.append(cbMsg);
        getUserIN();
/*        while(IN) {
            Thread.sleep(100);
        }
        userMsg = textInput.getText();
        textArea.append(cbMsg);*/

        parse = new ParseNLP(userMsg);

        ArrayList<String> option = parse.getStringList();
        for (String s:option) {
            if(s.equalsIgnoreCase(browseMovies)){
                cbMsg = "Chat Bot: You have selected: browse movies, is that right?\n";
                textArea.append(cbMsg);
                while(IN) {
                    Thread.sleep(100);
                }

                boolean yes = chatBot.testReaction(sc.nextLine()); //can pass string here instead
                if (yes) {
                    objective = browseMovies;
                }
            }
            else if(s.equalsIgnoreCase(browseBooks)){
                cbMsg = "Chat Bot: You have selected: browse books, is that right?\n";
                textArea.append(cbMsg);
                boolean yes = chatBot.testReaction(sc.nextLine()); //can pass string here instead
                if (yes) {
                    objective = browseBooks;
                }
            }
            else if(s.equalsIgnoreCase(trivia)){
                cbMsg = "Chat Bot: You have selected: trivia, is that right?\n";
                textArea.append(cbMsg);
                boolean yes = chatBot.testReaction(sc.nextLine()); //can pass string here instead
                if (yes) {
                    objective = trivia;
                }
            }
            else if(s.equalsIgnoreCase(request)){
                cbMsg = "Chat Bot: You have selected: request a specific item, is that right?\n";
                textArea.append(cbMsg);
                boolean yes = chatBot.testReaction(sc.nextLine()); //can pass string here instead
                if (yes) {
                    objective = request;
                }
            }
        }
    }

    private static void getUserIN() throws InterruptedException {
        while(IN) {
            Thread.sleep(100);
        }

        userMsg = textInput.getText();
        textArea.append(cbMsg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IN = false;
        /*numClicks++;
        label.setText(String.valueOf(numClicks));*/
        userMsg = textInput.getText();
        textArea.append("User: " + userMsg +  "\n");



    }


}
