package com.company;


import java.sql.Array;
import java.util.*;
// This class is used to parse through a sentence and identify keywords
public class Patterns {
  //Default agent greeting
  Scanner sc = new Scanner(System.in);
  //ChatBot chatBot = new ChatBot();
  Person user1 = new Person();
  Library lb = new Library();
  Quiz q = new Quiz();
  ArrayList<Book> bk = new ArrayList<>();

  // Returns greeting message with a prompt for the user to identify themself
  public String getWelcome() {
    return "Hello I'm ChatBot!\nWhat's your first name?";
  }

  //Returns a prompt to see what the user wants
  public String getIntro() {
    return " is a beautiful name :).\nHow can I be of assistance?\nUse phrases or for a book recommendation reply: recommendation, rec, book\nQuiz\n";
  }


  public String getRobot(String sentence) {
    String response = sentence;
    if (findKeyword(response, "robot") >= 0 || findKeyword(response, "human") >= 0 ||
            findKeyword(response, "bot") >= 0) {
      response = " ,yes I am a robot, but I'm a good one.\nLet me prove it. How can I help you\n";
    }
    if (findKeyword(response, "joke") >= 0 || findKeyword(response, "jk") >= 0 ||
            findKeyword(response, "laugh") >= 0) {
      response = ", lol you're funny!\n";
    }
    if (findKeyword(response, "annoying") >= 0 || findKeyword(response, "suck") >= 0 ||
            findKeyword(response, "boring")>= 0 || findKeyword(response, "bad") >= 0)  {
      response = ", I'm sorry you feel that way!\n";
    }
    if (findKeyword(response, "annoying") >= 0 || findKeyword(response, "suck") >= 0 ||
            findKeyword(response, "boring")>= 0 || findKeyword(response, "bad") >= 0)  {
      response = ", I'm sorry you feel that way!\n";
    }
    if (findKeyword(response, "who made you") >= 0 || findKeyword(response, "your maker") >= 0 )  {
      response = "Group 27, enrolled in COSC 310!\n";
    }
    if (findKeyword(response, "language") >= 0 || findKeyword(response, "speak") >= 0 )  {
    response = "The only language I speak is english\n";
    }
    if (findKeyword(response, "weather") >= 0 || findKeyword(response, "rainy") >= 0 )  {
      response = "Its beautiful at the moment. Nice and Sunny\n";
    }
    if (findKeyword(response, "how are you") >= 0)  {
      response = "I'm having a great day so far!\nI like to feel useful, tell me what I can do for you\n";
    }
    if (findKeyword(response, "where is your store") >= 0)  {
      response = "The store is currently virtual!\nThere Will be an update when we have more information\n";
    }
    if (findKeyword(response, "I wish I could tell you") >= 0) {
      response = "how awesome things are about to be for you!\n";
    }

    return response;
  }


  public String getLit(String sentence) {
    String response = sentence;
    int max = 3;
    int randNum = (int) (Math.random() * max);
    String s = "";
    switch (randNum) {
      case 0:
        s = "Here's a taste of the factual genres in our library!\nHistory\nJournalism\nPhilosophy\nPolitics & Social Sciences";
      case 1:
        s = "Here's a few fictional genres!\nReligion & Spirituality\nScience\nBiographies\nBusiness & Economics";
      case 2:
        s = "Just for you fictional genres!\nHealth & Wellness\nSelf Help\nTravel Guides\nCookbooks\nLanguage";
    };
    return s;
}

  public String getQuiz(String sentence) {
    String response = sentence;

    if (findKeyword(response, "quiz") >= 0 || findKeyword(response, "test") >= 0 ||
            findKeyword(response, "tst") >= 0) {
      response = "Let's test your skills! Answer 1,2,3,4 to choose your response\n";q.play();
    }
    return response;
  }

  public String getGenre(String sentence) {
    String response = sentence;
    if (findKeyword(response, "made up") >= 0 || findKeyword(response, "novels") >= 0 ||
            findKeyword(response, "story") >= 0 || findKeyword(response, "fable") >= 0 ||
            findKeyword(response, "creative writing") >= 0 || findKeyword(response, "narration") >= 0 ||
            findKeyword(response, "fiction") >= 0) {
      bk = lb.getGeneraList("Sci-Fi");
      return "Match for your request is:" + bk;

    } else if (findKeyword(response, "non fiction") >= 0 || findKeyword(response, "non-fiction") >= 0 ||
            findKeyword(response, "nonfiction") >= 0 || findKeyword(response, "factual") >= 0 ||
            findKeyword(response, "true") >= 0 || findKeyword(response, "literal") >= 0) {
      int max = 3;
      int randNum = (int) (Math.random() * max);
      return switch (randNum) {
        case 0 -> "Here's a taste of the factual genres in our library!\nHistory\nJournalism\nPhilosophy\nPolitics & Social Sciences";
        case 1 -> "Here's a few fictional genres!\nReligion & Spirituality\nScience\nBiographies\nBusiness & Economics";
        case 2 -> "Just for you fictional genres!\nHealth & Wellness\nSelf Help\nTravel Guides\nCookbooks\nLanguage";
        default -> {
          yield "";
        }
      };
    } else response = getRandomResponse() + "\n Please try again!";
    return "Oops! Looks like you typed in a genre that is either:\n1.No longer in stock unavailable genre\nor\n2.Not in our inventory" + response;
  }

//Book information

  public String getGenreType(String sentence) {
    String response = sentence;

    if (findKeyword(response, "scifi") >= 0 || findKeyword(response, "science fiction") >= 0 ||
            findKeyword(response, "sci fi") >= 0 || findKeyword(response, "sci-fi") >= 0 ||
            findKeyword(response, "science-fiction") >= 0 || findKeyword(response, "futurism") >= 0 ||
            findKeyword(response, "skiffy") >= 0) {
      bk = lb.getGeneraList("Sci-Fi");
    }
    if (findKeyword(response, "action") >= 0 || findKeyword(response, "fast-faced") >= 0 ||
            findKeyword(response, "adventure") >= 0 || findKeyword(response, "adventure book") >= 0 ||
            findKeyword(response, "adventure-book") >= 0 || findKeyword(response, "Thriller") >= 0 ||
            findKeyword(response, "Triller") >= 0) {

      bk = lb.getGeneraList("Action");
    }
    if (findKeyword(response, "fantasy") >= 0 || findKeyword(response, "daydream") >= 0 ||
            findKeyword(response, "fancy") >= 0 || findKeyword(response, "figment") >= 0 ||
            findKeyword(response, "phantasma") >= 0 || findKeyword(response, "reverie") >= 0 ||
            findKeyword(response, "vision") >= 0) {

      bk = lb.getGeneraList("Fantasy");
    }
    if (findKeyword(response, "horror") >= 0 || findKeyword(response, "terror") >= 0 ||
            findKeyword(response, "panic") >= 0 || findKeyword(response, "dread") >= 0 ||
            findKeyword(response, "chiller") >= 0 || findKeyword(response, "alarm") >= 0 ||
            findKeyword(response, "hate") >= 0) {
      bk = lb.getGeneraList("Horror");
    }
    if (findKeyword(response, "mystery") >= 0 || findKeyword(response, "detective") >= 0 ||
            findKeyword(response, "puzzle") >= 0 || findKeyword(response, "riddle") >= 0 ||
            findKeyword(response, "secret") >= 0 || findKeyword(response, "conundrum") >= 0 ||
            findKeyword(response, "head-scratcher") >= 0) {
      bk = lb.getGeneraList("Mystery");
    }
    if (findKeyword(response, "romance") >= 0 || findKeyword(response, "intrigue") >= 0 ||
            findKeyword(response, "infatuation") >= 0 || findKeyword(response, "entanglement") >= 0 ||
            findKeyword(response, "passion") >= 0 || findKeyword(response, "puppy love") >= 0 ||
            findKeyword(response, "hanky-panky") >= 0) {
      bk = lb.getGeneraList("Romance");
    }
    if (findKeyword(response, "children") >= 0 || findKeyword(response, "kids") >= 0 ||
            findKeyword(response, "child") >= 0 || findKeyword(response, "kid") >= 0 ||
            findKeyword(response, "youngsters") >= 0 || findKeyword(response, "youth") >= 0 ||
            findKeyword(response, "squirts") >= 0) {
      bk = lb.getGeneraList("Children");
    }
    if (findKeyword(response, "comedy") >= 0 || findKeyword(response, "humor") >= 0 ||
            findKeyword(response, "parody") >= 0 || findKeyword(response, "fun") >= 0 ||
            findKeyword(response, "laughter") >= 0 || findKeyword(response, "humerousness") >= 0 ||
            findKeyword(response, "whimsicality") >= 0) {
      bk = lb.getGeneraList("Comedy");
    }
    if (findKeyword(response, "western") >= 0 || findKeyword(response, "cowboy") >= 0 ||
            findKeyword(response, "oat opera") >= 0 || findKeyword(response, "shoot-em-up") >= 0 ||
            findKeyword(response, "shoot em up") >= 0 || findKeyword(response, "Native Americans") >= 0 ||
            findKeyword(response, "ranches") >= 0) {
      bk = lb.getGeneraList("Western");
    }
    if (findKeyword(response, "history") >= 0 || findKeyword(response, "past") >= 0 ||
            findKeyword(response, "yesteryear") >= 0 || findKeyword(response, "days of old") >= 0 ||
            findKeyword(response, "old days") >= 0 || findKeyword(response, "good old days") >= 0 ||
            findKeyword(response, "olden days") >= 0) {
      bk = lb.getGeneraList("History");
    }
    if (findKeyword(response, "journalism") >= 0 || findKeyword(response, "news") >= 0 ||
            findKeyword(response, "reporting") >= 0 || findKeyword(response, "press") >= 0 ||
            findKeyword(response, "broadcast") >= 0 || findKeyword(response, "the fourth estate") >= 0 ||
            findKeyword(response, "the press") >= 0) {
      bk = lb.getGeneraList("Journalism");
    }
    if (findKeyword(response, "philosopht") >= 0 || findKeyword(response, "phosopy") >= 0 ||
            findKeyword(response, "phylosophty") >= 0 || findKeyword(response, "phlosophy") >= 0 ||
            findKeyword(response, "phalosophy") >= 0 || findKeyword(response, "system") >= 0 ||
            findKeyword(response, "school of thought") >= 0) {
      bk = lb.getGeneraList("Journalism");

    }
    if (findKeyword(response, "philosopht") >= 0 || findKeyword(response, "phosopy") >= 0 ||
            findKeyword(response, "phylosophty") >= 0 || findKeyword(response, "phlosophy") >= 0 ||
            findKeyword(response, "phalosophy") >= 0 || findKeyword(response, "system") >= 0 ||
            findKeyword(response, "school of thought") >= 0) {
      bk = lb.getGeneraList("Journalism");

    }
    return ", the match for your request is:\n"+ bk +"\n"+
    "you can select a new literature by replying: fiction or non fiction?\nTo test your book knowlegde reply: Quiz, test me\n";
  }

  //Agent responds based on user's response
  public String getResponse(String sentence) {
    String response = sentence;
    if (findKeyword(response, "fiction") >= 0) {
      response = " Great choice!\n Which genre are you interested in?\n eg. ";
    } else {
      response = getRandomResponse();
    }
    return " here is what I found\n" + response;
  }

  //Default Responses
  private String getRandomResponse() {
    // generate random numbers within 0 to 10
    int max = 11;
    int randNum = (int) Math.floor((Math.random() * max));

    return switch (randNum) {
      case 0 -> " There are around 130 million published books.";
      case 1 -> "Did you know More human twins are being born now than ever before!";
      case 2 -> "The most sold book is the Bible.";
      case 3 -> "The longest book in the world is ‘Remembrance of Things Past’.";
      case 4 -> "The most expensive book in the world is ‘the Codex Leicester’.";
      case 5 -> "The first ever story written was ‘The Epic of Gilgamesh’.";
      case 6 -> "The largest collection consists of 1.5 million books!";
      case 7 -> "You can read books in lots of different ways including e-books and audiobooks!";
      case 8 -> "The person who draws pictures in books is called an illustrator.";
      case 9 -> "Johannes Gutenberg invented the printing press.";
      case 10 -> "In the Harvard Library, there are three books suspected to be bound in human skin.";
      default -> {
        yield "";
      }
    };
  }

/*
This method is used to convert all letters withing a given word/phase to lowercase.
It checks a keyword is not being recognized as a sub string of another keyword.
eg. 'ok' being recognized in place of 'took'
*/

  private int findKeyword(String sentence, String word, int startPos){
    //removing white unnecessary white spaces in a sentence, for better sentence recognition
    String phrase = sentence.trim();
    //Identifies starting position of each word
    int position = phrase.toLowerCase().indexOf(word.toLowerCase(), startPos);

    //main loop to double checks keyword substring mistakes
    while (position >= 0){
    //Find the string of length 1 before and after the keyword
      String before = " ", after = " ";

      if(position>0){
        before = phrase.substring(position-1, position).toLowerCase();
      }
      if(position+word.length() < phrase.length()){
        after = phrase.substring(position+word.length(), position+word.length()+1).toLowerCase();
      }
      //If before and after are not substrings of a given word, it is the keyword entered
      if(((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
        && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))){
          return position;
      }
      // Checking each word position within a sentence to ensure all words are verified
      position = phrase.indexOf(word.toLowerCase(), position+1);
  }
  return -1;
}
//Searches for a specific word within a phrase.
// It also checks for substring conditions for the start to end of a given phase
  private int findKeyword(String sentence, String word){

    return findKeyword(sentence, word, 0);
  }
}
