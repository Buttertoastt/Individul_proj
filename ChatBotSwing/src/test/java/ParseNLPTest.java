import junit.framework.TestCase;

import java.util.ArrayList;

public class ParseNLPTest extends TestCase {

    public void testGetStringList() {
        ParseNLP parseNLP = new ParseNLP("I want Dune");
        ArrayList<String> words = parseNLP.getWords();
        System.out.println(words);
    }
}