package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Gallery {
    private ArrayList<Movie> movieList = new ArrayList<>();
    public Gallery() {
        movieList.add(new Movie("Eternals", "Action", 2021, 2.62));
        movieList.add(new Movie("Dune", "Sci-Fi", 2021, 2.58));
        movieList.add(new Movie("Perfect Blue", "Drama", 1998, 2));
        movieList.add(new Movie("Howl's Moving Castle - The Animation", "Fantasy", 2004, 2));
        movieList.add(new Movie("The Fellowship of The Rings", "Fantasy", 2001, 3));
        movieList.add(new Movie("Slender Man", "Horror", 2018, 1.6));
        movieList.add(new Movie("Titanic", "Romance", 1997, 3));
        movieList.add(new Movie("E.T", "Sci-Fi", 1982   , 2));
        movieList.add(new Movie("Hathaway's Flash part 1", "Sci-Fi", 2021, 1.5));
        movieList.add(new Movie("Scary movie", "Comedy", 2000, 1.5));
        movieList.add(new Movie("LA 92", "Education", 2017, 2));
    }
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    //Add movie to gallery return boolean value to caller.
    public boolean addMovie(String title, String genre, int year, double duration) {
        for (int i = 0; i < movieList.size(); i++) {
            if(title.equalsIgnoreCase(movieList.get(i).getTitle())){
                return false;
            }
        }
        movieList.add(new Movie(title,genre,year,duration));
        return true;
    }
    //Return arrayList of movies by specific genre in gallery.
    public ArrayList<Movie> getGeneraList(String genera) {
        ArrayList<Movie> generaList = getMovieList();
        for (Movie m:movieList) {
            if(m.getGenre().equalsIgnoreCase(genera)) { //Don't use == to compare strings in Java, please. Unless you're comparing if they're pointing to the same object.
                generaList.add(m);
            }
        }
        return  generaList;
    }
    //Return arrayList of movies by specific year in gallery.
    public ArrayList<Movie> getYearList(int y) {
        ArrayList<Movie> yearList = getMovieList();
        for (Movie m: movieList) {
            if(m.getYear() == y) {
                yearList.add(m);
            }
        }
        return  yearList;
    }
    //Return arrayList of books by specific author in library.
    public ArrayList<Movie> getDurationList(double d) {
        ArrayList<Movie> durationList = getMovieList();
        for (Movie m:movieList) {
            if(m.getDuration() == d) {
                durationList.add(m);
            }
        }
        return  durationList;
    }
    //Return arrayList of strings of all authors in library.
    //Specially made for callers that requires a list instead of arraylist
    public String [] getAllGeneras() {
        String [] allgenres;
        ArrayList<Movie> genres = new ArrayList<>();
        for (Movie m :movieList) {
            if(!checkDup(m, genres)){
                genres.add(m);
            }
        }
        allgenres = new String[genres.size()];
        for (int i = 0; i < allgenres.length; i++) {
            allgenres[i] = genres.get(i).getGenre();
        }
        return allgenres;
    }
    //Return arrayList of strings of book titles in library.
    public ArrayList<String> getTitleList(ArrayList<Movie> movies) {
        ArrayList<String> titles = new ArrayList<>();
        for (Movie m :movies) {
            titles.add(m.getTitle());
        }
        return titles;
    }
    public ArrayList<Integer> getYearList(ArrayList<Movie> movies) {
        ArrayList<Integer> years = new ArrayList<>();
        for (Movie m :movies) {
            years.add(m.getYear());
        }
        return years;
    }
    //Return random book by genera to caller.
    public Movie getGeneraRand(String genera) {
        ArrayList<Movie> generaList = getGeneraList(genera);
        int randNum = (int)(Math.random() * generaList.size());
        Movie rand = new Movie();
        //System.out.println(generaList.size());
        if (generaList.size()>0) {
            rand = generaList.get(randNum);
        }
        //System.out.println(rand.getBookDetails());
        return rand;
    }
    //Return random movie written by author to caller.
    public Movie getYearRand(int year) {
        ArrayList<Movie> yearList = getYearList(year);
        int randNum = (int) (Math.random() * yearList.size());
        Movie rand = new Movie();
        if (yearList.size() > 0) {
            rand = yearList.get(randNum);
        }
        return rand;
    }
    //Returns a random book in library to caller.
    public Movie getTitleRandom() {
        int randNum = (int)(Math.random() * movieList.size());
        Movie rand = movieList.get(randNum);
        return rand;
    }



    //Tostring of a book at given index.
    public String getMovieDetails(int i){
        return "Title: " + movieList.get(i).getTitle() + "\t\tGenre: " + movieList.get(i).getGenre() + "\t\tYear: " + movieList.get(i).getYear()+ "\t\tDuration: " + movieList.get(i).getDuration();
    }
    //Returns a string that is a list of all the book titles, in the array of books passed to method, to caller.
    public String listString(ArrayList<Movie> movies)  {
        String movieString = "";
        for (Movie m:movies) {
            movieString += m.getTitle() + " \n";
        }
        return movieString;
    }
    //Returns random book that is similar to user's favourite book
    //Incomplete and unused, held for future use.
    /*
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
    */
    public Movie byTitle(String s){ //In the future return list, from which user can pick from.
        Movie m = new Movie();
        ArrayList<Movie> temp = new ArrayList<Movie>();
        int a = 1;
        int ran = 0;
        for (int i = 0; i < getMovieList().size(); i++) {
            if(s.equalsIgnoreCase(getMovieList().get(i).getTitle())){
                temp.add(getMovieList().get(i));
            }
        }
        if(temp.size()>0){
            ran = (int) (Math.random()*temp.size());
            m = temp.get(ran);
        }

        return m;
    }
    //Checks for dupes in get genre and year methods
    //Returns true if a duplicate is found and false otherwise
    public boolean checkDup(Movie in, ArrayList<Movie> out){
        for (int i = 0; i < out.size(); i++) {
            if(in.getGenre().equalsIgnoreCase(out.get(i).getGenre()) || in.getYear() == out.get(i).getYear()){
                return true;
            }
        }
        return false;
    }

}
