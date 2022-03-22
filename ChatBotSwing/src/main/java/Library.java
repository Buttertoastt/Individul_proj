import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList = new ArrayList<>();
    public Library() {
        bookList.add(new Book("Dune", "Sci-Fi", 300, "F. Hebert"));
        bookList.add(new Book("Foundation", "Sci-Fi", 300, "I. Asimov"));
        bookList.add(new Book("Lord of the Rings", "Fantasy", 300, "J.R. Tolkien"));
        bookList.add(new Book("Game of Thrones", "Fantasy", 300, "G.R.R. Martin"));
        bookList.add(new Book("Odyssey", "Classic", 300, "Homer"));
        bookList.add(new Book("The Great Gatsby", "Classic", 300, "F. Scott Fitzgerald"));
        bookList.add(new Book("The Love Hypothesis", "Romance", 384, "Ali Hazelwood"));
        bookList.add(new Book("The Fault in Our Stars", "Romance", 313, "John Green"));
        bookList.add(new Book("Sierra Six", "Action", 8, "Mark Greaney"));
        bookList.add(new Book("House of Earth and Blood", "Action", 816, "Sarah J. Maas"));
        bookList.add(new Book("Born a Crime", "Comedy", 304, "Trevor Noah"));
        bookList.add(new Book("Yearbook", "Comedy", 272, "Seth Rogen"));
        bookList.add(new Book("The Minimalist Teacher", "Education", 144, "C. Y. Arnold & Tamera Musiowsky-Borneman"));
        bookList.add(new Book("Ensouling Our Schools: A Universally Designed Framework for Mental Health, Well-Being, and Reconciliation", "Education", 300, "Jennifer Katz & Kevin Lamoureux"));
        bookList.add(new Book("House of Leaves", "Horror", 709, "Mark Z. Danielewski"));
        bookList.add(new Book("Dracula", "Horror", 418, "Bram Stoker"));
        bookList.add(new Book("Overlord, Vol 1 - The Undead King", "Light novel", 256, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 2 - The Dark Warrior", "Light novel", 256, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 3 - The Bloody Valkyrie", "Light novel", 288, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 4 - The Lizardman Heroes", "Light novel", 304, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 5 - The Men Of The Kingdome Part 1", "Light novel", 272, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 6 - The Men Of The Kingdome Part 2", "Light novel", 292, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 7 - The Invaders Of The Great Tomb", "Light novel", 350, "Kugane Maruyama"));
        bookList.add(new Book("Overlord, Vol 8 - The Two Leaders", "Light novel", 288, "Kugane Maruyama"));
        bookList.add(new Book("The return of Johnny Ridden MSV-R, Vol 1", "Manga", 350, "Kugane Maruyama"));
        bookList.add(new Book("Gundam Thunderbolt, Vol 1", "Manga", 350, "Hajime Yadate"));
        bookList.add(new Book("Gundam Thunderbolt, Vol 2", "Manga", 350, "Hajime Yadate"));
        bookList.add(new Book("Gundam Thunderbolt, Vol 3", "Manga", 350, "Hajime Yadate"));
        bookList.add(new Book("monty python", "comedy", "person"));

    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    //Add book to library return boolean value to caller.
    public boolean addBook(String title, String genre, int pages, String author) {
        for (int i = 0; i < bookList.size(); i++) {
            if(title.equalsIgnoreCase(bookList.get(i).getTitle())){
                return false;
            }
        }
        bookList.add(new Book(title,genre,pages,author));
        return true;
    }

    public ArrayList<Book> getGeneraList(String genera) {
        ArrayList<Book> generaList = new ArrayList<>();
        bookList = getBookList();
        for (Book b:bookList) {
            if(b.getGenre().equalsIgnoreCase(genera)) { //Don't use == to compare strings in Java, please. Unless you're comparing if they're pointing to the same object.
                generaList.add(b);
            }
        }
        return  generaList;
    }
    //Return arrayList of books by specific author in library.
    public ArrayList<Book> getAuthorList(String author) {
        ArrayList<Book> authorList = new ArrayList<>();
        for (Book b:bookList) {
            if(b.getAuthor() == author)
            {
                authorList.add(b);
            }
        }
        return  authorList;
    }
    //Return arrayList of strings of book authors in library.
    public ArrayList<String> getAllAuthors() {
        ArrayList<String> authors = new ArrayList<>();
        for (Book book :bookList) {

            authors.add(book.getAuthor());
        }
        return authors;
    }
    //Return arrayList of strings of book titles in library.
    public ArrayList<String> getTitleList(ArrayList<Book> books) {
        ArrayList<String> titles = new ArrayList<>();
        for (Book book :books) {
            titles.add(book.getTitle());
        }
        return titles;
    }
    //Return random book by genera to caller.
    public Book getGeneraRand(String genera) {
        ArrayList<Book> generaList = getGeneraList(genera);
        int randNum = (int)(Math.random() * generaList.size());
        Book rand = new Book();
        System.out.println(generaList.size());
        if (generaList.size()>0) {
            rand = generaList.get(randNum);
        }
        System.out.println(rand.getBookDetails());
        return rand;
    }
    //Return random book written by author to caller.
    public Book getAuthRand(String author) {
        ArrayList<Book> authorList = getAuthorList(author);
        int randNum = (int) (Math.random() * authorList.size());
        Book rand = new Book();
        if (authorList.size() > 0) {
            rand = authorList.get(randNum);
        }
        return rand;
    }
    //Returns a random book in library to caller.
    public Book getTitleRandom() {
        int randNum = (int)(Math.random() * bookList.size());
        Book rand = bookList.get(randNum);
        return rand;
    }



    //Tostring of a book at given index.
    public String getBookDetails(int i){
        return "Title: " + bookList.get(i).getTitle() + "\t\tGenre: " + bookList.get(i).getGenre() + "\t\tAuthor: " + bookList.get(i).getAuthor();
    }
    //Returns a string that is a list of all the book titles, in the array of books passed to method, to caller.
    public String listString(ArrayList<Book> books)  {
        String bookString = "";
        for (Book b:books) {
            bookString += b.getTitle() + " \n";
        }
        return bookString;
    }
    public static Book favB(Library l, Person p){
        Book b = new Book();
        int a = 1;
        for (int i = 0; i < l.getBookList().size(); i++) {
            if(p.getFavoriteBook().equalsIgnoreCase(l.getBookList().get(i).getTitle())){ //In the future: include books with multiple vol or series
                b = l.getBookList().get(i);
            }
        }
        return b;
    }
    public static Book favG(Library l, Person p){
        Book b = new Book();
        ArrayList<Book> temp = new ArrayList<Book>();
        int a = 1;
        int ran = 0;
        for (int i = 0; i < l.getBookList().size(); i++) {
            if(p.getFavoriteGenera().equalsIgnoreCase(l.getBookList().get(i).getGenre())){ //In the future: include books with multiple vol or series
                temp.add(l.getBookList().get(i));
            }
        }
        if(temp.size()>0){ //Necessary?
            //ran = (int) Math.round(Math.random()*temp.size());
            b = temp.get(ran);
        }
        return b;
    }
    //Returns random book using the pages passed into method to caller.
    public Book byPages(String s){ //In the future return list, from which user can pick from. And perhaps within a range of the inputted pages
        Book b = new Book();
        ArrayList<Book> temp = new ArrayList<Book>();
        int a = 1;
        int ran = 0;
        int k = Integer.parseInt(s);
        for (int i = 0; i < getBookList().size(); i++) {
            if(k == getBookList().get(i).getPages()){
                temp.add(getBookList().get(i));
            }
        }
        if(temp.size()>1){ //Necessary?
            ran = (int) Math.floor(Math.random()*temp.size());
            System.out.println(ran);
            b = temp.get(ran);
        }
        else if(temp.size() == 1){
            b = temp.get(0);
        }
        return b;
    }
    //Remove dupe for some methods
    public Book removeDupe(Book in, ArrayList<Book> out){
        Book b = new Book();
        for (int i = 0; i < out.size(); i++) {
            if(in.getTitle().equalsIgnoreCase(out.get(i).getTitle())){
                out.remove(i);
            }
        }
        return b;
    }
    public Book byTitle(String s){ //In the future return list, from which user can pick from.
        Book b = new Book();
        ArrayList<Book> temp = new ArrayList<Book>();
        int a = 1;
        int ran = 0;
        for (int i = 0; i < getBookList().size(); i++) {
            if(s.equalsIgnoreCase(getBookList().get(i).getTitle())){
                temp.add(getBookList().get(i));
            }
        }
        if(temp.size()>0){ //Necessary?
            ran = (int) (Math.random()*temp.size());
            b = temp.get(ran);
        }

        return b;
    }

}
