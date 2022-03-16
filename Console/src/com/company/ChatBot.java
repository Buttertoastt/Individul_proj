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
		statements.add("Hello, my name is chat bot your personal library assistant"); //0
		statements.add("eg. Random recommendation, or by favourite book, or favourite genre. Or search for a book by title, page, author. Or set of books by author, genre, page.");
		statements.add("By: "); //2
		statements.add("I would recommend the following book(s): "); //3
		statements.add("I found %d books by that title: "); //4
		statements.add("I found %d books by that author: "); //5
		statements.add("I found %d books in that genre: "); //6
		statements.add("I found %d books of that length: "); //7
		statements.add("Error, no by that title..."); //8
		statements.add("Error, no books by that author..."); //9
		statements.add("Error, no books in that genre..."); //10
		statements.add("Error, no books of that length..."); //11
		statements.add("Error, no books to return..."); //12
		//statements.add("Are you a first time user?");
		//statements.add("Welcome back %s how may I help you today?"); no need to output example of services statement b/c user is not new.
		statements.add("May I suggest %s(type yes/y to add to checkout, otherwise type no/n): "); //13
		statements.add("Today you've checked out the following book(s): "); //14
		statements.add("Book(s) successfully added to checkout!"); //15
		statements.add("Today you've checked out the following movie(s): "); //16
		statements.add("Error, no movies in that genre..."); //17
		statements.add("Error, no movies by that title..."); //18
		statements.add("Error, no movies in that year..."); //19

		questions.add(new question("generic", 0, "What is your name?")); //0
		questions.add(new question("generic", 0, "How old are you %s?")); //1
		questions.add(new question("generic", 0, "What is your occupation %s?")); //2
		questions.add(new question("generic", 0, "What is your favourite book %s?")); //3
		questions.add(new question("generic", 0, "What is your favourite genre %s?")); //4
		//questions.add(new question("generic", 0, "What service can I provide? "));  //considering to add two more elements, two to indicate the statement(s) index(s)
		questions.add(new question("loop", 0, "What should I base my recommendation on? ")); //5
		questions.add(new question("loop", 1, "Would you require additional service? (Type yes/y for more features)")); //6
		positiveFeedBack.add(p1);
		positiveFeedBack.add(p2);
		positiveFeedBack.add(p3);
		positiveFeedBack.add(p4);
		positiveFeedBack.add(p5);
		positiveFeedBack.add(p6);

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
	public void mainMenu(Person p){
		PCA pca = new PCA(p.getUserVector());
		Quiz quiz = new Quiz();
		int in = 0;
		String input;
		int gate = 1;
		while(gate == 1) {
			System.out.println("Are you looking for book or movie recommendations today? (1 - book, 2 - movie 3 - other)");
			in = Integer.parseInt(sc.nextLine());
			if (in == 1) {
				libraryMenu(p, pca, quiz);
			} else if (in == 2) {
				galleryMenu(p);
			} else if (in == 3) {
				System.out.println("Handling other topics");////////////////////
			} else {
				System.out.println("Unrecognized option, try again.");
				mainMenu(p);
			}
			System.out.println("Would you like to keep browsing?");
			if (testReaction(sc.nextLine())) {
				continue;
			} else {
				break;
			}
		}
	}

	public void libraryMenu(Person p, PCA pca, Quiz quiz){
		String in = "";
		System.out.println("Library menu");


		int gate = 1;
		while(gate == 1){
			//System.out.println("1");
			System.out.println("1 - random title \n2 - random book in genre\n3 - Search by title\n4 - Random book by author\n5 - Search by pages\n6 - PCA\n7 - quiz \n8 - Get current checkout list");
			in = sc.nextLine();
			if(Integer.parseInt(in)==1){
				System.out.println(getStatement(13));
				Book ran = library.getTitleRandom();
				//Moved to library related method: System.out.println(ran.getBookDetails());
				//System.out.println(chatBot.getStatement(3));
				if(testReaction(sc.nextLine())){ //
					p.updateTempBookList(ran);
				}
				//System.out.println(user1.getTempList());
			}
			//Search by genre
			else if(Integer.parseInt(in)==2){
				System.out.println("Search by genre: ");
				Book ran = library.getGeneraRand(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(10));
				}
				else{
					//System.out.println(chatBot.getStatement(3));
					System.out.println(getStatement(13));
					System.out.println(ran.getBookDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempBookList(ran);
					}
				}
			}
			//Search by title
			else if(Integer.parseInt(in)==3){
				System.out.println("Search by title: ");
				Book ran = library.byTitle(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(8));
				}
				else{
					System.out.println(getStatement(13));
					System.out.println(ran.getBookDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempBookList(ran);
					}
				}
			}
			//Search by author
			else if(Integer.parseInt(in)==4){
				System.out.println("Search by author: ");
				Book ran = library.getAuthRand(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(9));
				}
				else{
					//System.out.println(chatBot.getStatement(3));
					System.out.println(getStatement(13));
					System.out.println(ran.getBookDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempBookList(ran);
					}
				}
			}
			//Search by pages
			else if(Integer.parseInt(in)==5){
				System.out.println("Search by pages: ");
				Book ran = library.byPages(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(11));
				}
				else{
					//System.out.println(chatBot.getStatement(3));
					System.out.println(getStatement(13));
					System.out.println(ran.getBookDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempBookList(ran);
					}
				}
			}
			//Quiz/trivia
			else if(Integer.parseInt(in)==6){
				System.out.println("Quick questions!");
				System.out.println("These potshots won't stop until you accept at least one genre!");
				p.setUserVector();
				p.setPcaVector(pca.getStandardUser());
				//System.out.println("pass1");
				p.setTopThree(pca.getTopThree());
				//System.out.println("pass2");
				loopGeneraTitle(p,pca,pca.getTopThree(), false);
			}
			else if(Integer.parseInt(in)==7){
				quiz.play();
			}
			//Print cart list
			else if(Integer.parseInt(in)==8){
				for (int i = 0; i < p.getTempBookList().size(); i++) {
					System.out.println(p.getTempBookList().get(i).getBookDetails());
				}
			}

			else{
				System.out.println("Service unavailable");

			}
			System.out.println(getQuestion(6, p.getName()));
			in = sc.nextLine();
			//System.out.println("in: "+ in);
			if(testReaction(in)){
				continue;
			}
			else{
				gate = 0;
				break;
			}
		}

	}

	public void galleryMenu(Person p){
		String in = "";
		System.out.println("Gallery menu");
		PCA pca = new PCA(p.getUserVector());
		Quiz quiz = new Quiz();

		int gate = 1;
		while(gate == 1){
			//System.out.println("1");
			System.out.println("1 - random movie \n2 - random movie in genre\n3 - random movie by year\n4 - Search by movie name\n5 - Get current checkout list");
			in = sc.nextLine();
			if(Integer.parseInt(in)==1){
				System.out.println(getStatement(13));
				Movie ran = gallery.getTitleRandom();
				System.out.println(ran.getMovieDetails());
				//Moved to library related method: System.out.println(ran.getBookDetails());
				//System.out.println(chatBot.getStatement(3));
				if(testReaction(sc.nextLine())){ //
					p.updateTempMovieList(ran);
				}
				//System.out.println(user1.getTempList());
			}
			//Search by genre
			else if(Integer.parseInt(in)==2){
				System.out.println("Search by genre: ");
				Movie ran = gallery.getGeneraRand(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(17));
				}
				else{
					//System.out.println(chatBot.getStatement(3));
					System.out.println(getStatement(13));
					System.out.println(ran.getMovieDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempMovieList(ran);
					}
				}
			}
			//Search by title
			else if(Integer.parseInt(in)==3){
				System.out.println("Random movie by year: ");
				Movie ran = gallery.getYearRand(Integer.parseInt(sc.nextLine()));
				if(ran.getTitle() == null){
					System.out.println(getStatement(19));
				}
				else{
					System.out.println(getStatement(13));
					System.out.println(ran.getMovieDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempMovieList(ran);
					}
				}
			}
			//Search by author
			else if(Integer.parseInt(in)==4){
				System.out.println("Search by name: ");
				Movie ran = gallery.byTitle(sc.nextLine());
				if(ran.getTitle() == null){
					System.out.println(getStatement(18));
				}
				else{
					//System.out.println(chatBot.getStatement(3));
					System.out.println(getStatement(13));
					System.out.println(ran.getMovieDetails());
					if(testReaction(sc.nextLine())){ //
						p.updateTempMovieList(ran);
					}
				}
			}
			//Search by pages
			else if(Integer.parseInt(in)==5){
				for (int i = 0; i < p.getTempMovieList().size(); i++) {
					System.out.println(p.getTempMovieList().get(i).getMovieDetails());
				}
			}
			else{
				System.out.println("Service unavailable");

			}
			System.out.println(getQuestion(6, p.getName()));
			in = sc.nextLine();
			//System.out.println("in: "+ in);
			if(testReaction(in)){
				continue;
			}
			else{
				gate = 0;
				break;
			}
		}
	}
	//.next usage noted
	//PCA loop until user picks a book.
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
