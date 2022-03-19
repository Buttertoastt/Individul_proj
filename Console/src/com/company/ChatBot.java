import java.util.*;

public class ChatBot {
	private String browseMovies = "browse movies";
	private String browseBooks = "browse books";
	private String trivia = "trivia";
	private String request = "request";
	Library library = new Library();
	Gallery gallery = new Gallery();
	Scanner sc = new Scanner(System.in);
	private String p1 = "yes";
	private String p2 = "yeah";
	private String p3 = "yep";
	private String p4 = "yeet";
	private String p5 = "sure";
	private String p6 = "y";
	private ArrayList<String> positiveFeedBack = new ArrayList<>();
	private Person person;
	private ArrayList<String> statements = new ArrayList<>();
	private ArrayList<question> questions = new ArrayList<>();
	//private ArrayList<String> questions = new ArrayList<>(Arrays.asList(q0,q1,q2,q3,q4,q5,q6));
	public ChatBot(){
		statements.add("Hello, my name is Haro your personal entertainment assistant"); //0
		statements.add("I would recommend the following book(s): "); //1
		statements.add("May I suggest %s(type yes/y to add to checkout, otherwise type no/n): "); //2
		statements.add("Today you've checked out the following book(s): "); //3
		statements.add("Today you've checked out the following movie(s): "); //4
		questions.add(new question("loop", 1, "Would you require additional service? (Type yes/y for more features)")); //6
		positiveFeedBack.add(p1);
		positiveFeedBack.add(p2);
		positiveFeedBack.add(p3);
		positiveFeedBack.add(p4);
		positiveFeedBack.add(p5);
		positiveFeedBack.add(p6);

	}
	public static int getInt() {
		return 2;
	}
	public boolean testReaction(String reply) {
		boolean happy = false;
		ParseNLP parse = new ParseNLP(reply);
		String sentiment = parse.getSentiment();
		if (sentiment != "Negative") {
			happy = true;
		}
		return happy;
	}

	//.next usage noted
	//PCA loop until user picks a book.
	public void loopGeneraTitle(Person person,PCA pca, ArrayList<String> suggest, boolean last) {

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
						//person.checkOut.add(library.byTitle(t)); doesn't update tempList
						person.updateTempBookList(library.byTitle(t));
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
			loopNum++;
		}
		if(!happy) {
			getConsolation(loopNum);
			System.out.println("");
			ArrayList<String> finalOption = pca.remainingOptions(person.getTopThree());
			loopGeneraTitle(person,pca,finalOption,true);

		}
	}
	public void loopGeneraTitleMovie(Person person, PCA pca, ArrayList<String> suggest, boolean last) {

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
				ArrayList<String> titles = gallery.getTitleList(gallery.getGeneraList(s));
				for (String t:titles) {
					System.out.println("Can i suggest: ");
					System.out.println(t + " ??");
					String reply2 = sc.next();
					addToCart = testReaction(reply2);
					if(addToCart) {
						//person.checkOut.add(library.byTitle(t)); doesn't update tempList
						person.updateTempMovieList(gallery.byTitle(t));
						System.out.println("added the movie" + t + " to checkout list");
						addToCart = false;
						System.out.println("continue browsing?");
						String reply3 = sc.next();
						continueBrowsing = testReaction(reply3);
						if(!continueBrowsing) {
							return; //break instead of return?
						}
					}
				}
			}
			loopNum++;
		}
		if(!happy) {
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
