import java.util.ArrayList;
import java.util.Scanner;

public class ChatBot {
/*	private String s1 = "Hello, my name is chat bot";
	private String s2 = "May I suggest %s";
	private String s3 = "Can I suggest something in our %s section?";

	private String s4= "I'm sorry, maybe you could try %s ...?";
	private String s5 = "Okay, let me find some %s books for you";
	private String s6 = "I'm not sure I understand ...?";

	private String q0 = "What is your name?";
	private String q1 = "How old are you %s?";
	private String q2 = "What is your occupation %s?";
	private String q3 = "What is your favorite genera?";
	private String q4 = "What is your favorite book?";
	private String q5 = "What is your favorite genera?";
	private String q6 = "What is your favorite book?";*/
	Library library = new Library();
	private String p1 = "yes";
	private String p2 = "yeah";
	private String p3 = "yep";
	private String p4 = "yeet";
	private String p5 = "sure";
	private ArrayList<String> positiveFeedBack = new ArrayList<>();
	private Person person;
	private ArrayList<String> statements = new ArrayList<>();
	private ArrayList<question> questions = new ArrayList<>();
	//private ArrayList<String> questions = new ArrayList<>(Arrays.asList(q0,q1,q2,q3,q4,q5,q6));
	public ChatBot(){
		statements.add("Hello, my name is chat bot your personal library assistant");
		statements.add("eg. Random recommendation, or by favourite book, or favourite genre. Or search for a book by title, page, author. Or set of books by author, genre, page.");
		statements.add("By: ");
		statements.add("I would recommend the following book(s): ");
		statements.add("I found %d books by that title: ");
		statements.add("I found %d books by that author: ");
		statements.add("I found %d books in that genre: ");
		statements.add("I found %d books of that length: ");
		statements.add("Error, no by that title...");
		statements.add("Error, no books by that author...");
		statements.add("Error, no books in that genre...");
		statements.add("Error, no books of that length...");
		statements.add("Error, no books to return..."); //Variations: No book by that title, no books by that author, no books of that genre, no books of that length
		//statements.add("Are you a first time user?");
		//statements.add("Welcome back %s how may I help you today?"); no need to output example of services statement b/c user is not new.
		statements.add("May I suggest %s");
		questions.add(new question("generic", 0, "What is your name?"));
		questions.add(new question("generic", 0, "How old are you %s?"));
		questions.add(new question("generic", 0, "What is your occupation %s?"));
		questions.add(new question("generic", 0, "What is your favourite book %s?"));
		questions.add(new question("generic", 0, "What is your favourite genre %s?"));
		//questions.add(new question("generic", 0, "What service can I provide? "));  //considering to add two more elements, two to indicate the statement(s) index(s)
		questions.add(new question("loop", 0, "What should I base my recommendation on? "));
		questions.add(new question("loop", 1, "Would you require additional service?"));
		positiveFeedBack.add(p1);
		positiveFeedBack.add(p2);
		positiveFeedBack.add(p3);
		positiveFeedBack.add(p4);
		positiveFeedBack.add(p5);

	}
	public boolean testReaction(String reply) {
		boolean happy = false;
		for (String s:positiveFeedBack) {
			if(s.contains(reply.toLowerCase())||reply.contains(s.toLowerCase())) {
				happy = true;
				return happy;
			}
		}
		return happy;
	}

	public void loopGeneraTitle(Person person,PCA pca, ArrayList<String> suggest,boolean last) {

		Scanner sc = new Scanner(System.in);
		boolean happy = false;
		boolean addToCart = false;
		boolean continueBrowsing = false;
		int loopNum = 0;
		for (String s: suggest) {
			if(loopNum>suggest.size()) {
				return;
			}
			getConsolation(loopNum);
			System.out.println("Would you like to browse something in our ");
			System.out.println(s + " section?");
			String reply = sc.next();
			happy = testReaction(reply);
			if(happy) {
				System.out.println("That's great!?");
				ArrayList<String> titles = library.getTitleList(library.getGeneraList(s));
				for (String t:titles) {
					System.out.println("Can i suggest: ");
					System.out.println(t + " ??");
					String reply2 = sc.next();
					addToCart = testReaction(reply2);
					if(addToCart) {
						person.chechOut.add(library.byTitle(t));
						System.out.println("added the book" + t + " to checkout list");
						addToCart = false;
						System.out.println("continue browsing?");
						String reply3 = sc.next();
						continueBrowsing = testReaction(reply3);
						if(!continueBrowsing) {
							return;
						}
					}
				}
			}
			else {
				//System.out.println("inner console");
				//getConsolation(loopNum);
			}
			loopNum++;
		}
		if(!happy) {
			//System.out.println("outter console");
			getConsolation(loopNum);
			System.out.println("");
			ArrayList<String> finalOption = pca.remainingOptions(person.getTopThree());
			loopGeneraTitle(person,pca,finalOption,true);

		}
	}


	public void getConsolation(int loopNum) {
		switch (loopNum) {
			case(1): {
				System.out.println("Searching...");
				break;
			}
			case(2): {
				System.out.println("Ok, Searching...");
				break;
			}
			case(3): {
				System.out.println("Ok, lets try, Searching...");
				break;
			}
			default: {
				System.out.println("Searching...");
			}
		}


	}
	public String getQuestion(int i,String s) {
		String q = "";

		if (questions.size() >i ) {
			q = questions.get(i).toString();
			if (q.contains("%s")) {
				q = String.format(q,s);
			}
			return q;

		}
		else
			return "I can't think of another question";
	}
	public String getQuestion(int i) {
		String q = "";

		if (questions.size() >i ) {
			q = String.valueOf(questions.get(i));
			if (q.contains("%s")) {
				q = String.format(q,"");
			}
			return q;

		}
		else
			return "I can't think of another question";
	}
	public String getStatement(int i,String s) {
		String q = "";

		if (statements.size() >i ) {
			q = statements.get(i).toString();
			if (q.contains("%s")) {
				q = String.format(q,s);
			}
			return q;

		}
		else
			return "I can't think of anything else";
	}
	public String getStatement(int i) {
		String q = "";

		if (statements.size() >i ) {
			q = statements.get(i);
			if (q.contains("%s")) {
				q = String.format(q,"");
			}
			return q;

		}
		else
			return "I can't think of anything else";
	}

	public void setQuestions(ArrayList<question> questions) {
		this.questions = questions;
	}


	private ArrayList<Person> people = new ArrayList<>();

	public String askByName(String question, String name) {
		String out = String.format(question,name);
		return out;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

}
