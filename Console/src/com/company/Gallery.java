package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Gallery {
    private ArrayList<Movie> movieList = new ArrayList<>();
    public Gallery() {
        movieList.add(new Movie("Eternals", "Action", 2021, 2.62));
        movieList.add(new Movie("dune", "Action", 2021, 2.58));
        movieList.add(new Movie("Perfect Blue", "Drama", 1998, 2));
        movieList.add(new Movie("Howl's Moving Castle - The Animation", "Fantasy", 2004, 2));
        movieList.add(new Movie("The Fellowship of The Rings", "Fantasy", 2001, 3));
        movieList.add(new Movie("Slender Man", "Horror", 2018, 1.6));


    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
    //Add movie to gallery return boolean value to caller.
    public boolean addMovie(String title, String genre, int year, double duration) {
        for (int i = 0; i < movieList.size(); i++) {
            if(title.equalsIgnoreCase(movieList.get(i).getTitle())){
                return false;
            }
        }
        bookList.add(new Book(title,genre,pages,author));
        return true;
    }
    //Return arrayList of books by specific genre in library.
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
            if(b.getAuthor().equalsIgnoreCase(author))
            {
                authorList.add(b);
            }
        }
        return  authorList;
    }
    //Return arrayList of strings of all authors in library.
    //Specially made for callers that requires a list instead of arraylist
    public String [] getAllGeneras() {
        String [] allgenres;
        ArrayList<Book> genres = new ArrayList<>();
        for (Book book :bookList) {
            if(!checkDup(book, genres)){
                genres.add(book);
            }
        }
        allgenres = new String[genres.size()];
        for (int i = 0; i < allgenres.length; i++) {
            allgenres[i] = genres.get(i).getGenre();
        }
        return allgenres;
    }
    //Return arrayList of strings of all authors in library.
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
        //System.out.println(generaList.size());
        if (generaList.size()>0) {
            rand = generaList.get(randNum);
        }
        //System.out.println(rand.getBookDetails());
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
    public String getMovieDetails(int i){
        return "Title: " + movieList.get(i).getTitle() + "\t\tGenre: " + movieList.get(i).getGenre() + "\t\tYear: " + movieList.get(i).getYear()t()+ "\t\tDuration: " + movieList.get(i).getDuration();
    }
    //Returns a string that is a list of all the book titles, in the array of books passed to method, to caller.
    public String listString(ArrayList<Book> books)  {
        String bookString = "";
        for (Book b:books) {
            bookString += b.getTitle() + " \n";
        }
        return bookString;
    }
    //Returns random book that is similar to user's favourite book
    //Incomplete and unused, held for future use.
    public Book favB(Person p){
        Book b = new Book();
        int a = 1;
        for (int i = 0; i < getBookList().size(); i++) {
            if(p.getFavoriteBook().equalsIgnoreCase(getBookList().get(i).getTitle())){ //In the future: include books with multiple vol or series
                b = getBookList().get(i);
            }
        }
        return b;
    }
    //Returns random book within the same genre as user's favourite genre
    public Book favG(Person p){
        Book b = new Book();
        ArrayList<Book> temp = new ArrayList<Book>();
        int a = 1;
        int ran = 0;
        for (int i = 0; i < getBookList().size(); i++) {
            if(p.getFavoriteGenera().equalsIgnoreCase(getBookList().get(i).getGenre())){ //In the future: include books with multiple vol or series
                temp.add(getBookList().get(i));
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
        if(temp.size()>0){
            ran = (int) Math.random()*temp.size();
            //System.out.println(ran);
            b = temp.get(ran);
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
        if(temp.size()>0){
            ran = (int) (Math.random()*temp.size());
            b = temp.get(ran);
        }

        return b;
    }
    //Checks for dupes in get all authors and get all genres methods
    //Returns true if a duplicate is found and false otherwise
    public boolean checkDup(Movie in, ArrayList<Movie> out){

        for (int i = 0; i < out.size(); i++) {
            if(in.getAuthor().equalsIgnoreCase(out.get(i).getAuthor()) || in.getGenre().equalsIgnoreCase(out.get(i).getGenre())){
                return true;
            }
        }
        return false;
    }

}
