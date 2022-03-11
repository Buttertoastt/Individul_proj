package com.company;

import java.util.ArrayList;

public class Person {
    private String name;
    private String age;
    private String occupation;
    private String favoriteBook;
    private String favoriteGenera;
    private int [] pcaVector;
    Library lib = new Library();
    //String [] generas = new String[] {"sci-fi","Romance","Action","Comedy", "Education","Classic","Horror"};
    String [] generas = lib.getAllGeneras();
    ArrayList<String> topThree = new ArrayList<>();
    private int [] userVector = new int[generas.length];
    private ArrayList<Book> tempList = new ArrayList<Book>();
    private ArrayList<Book> permList = new ArrayList<Book>();
    ArrayList<Book> checkOut = new ArrayList<>();

    public ArrayList<Book> getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(ArrayList<Book> checkOut) {
        this.checkOut = checkOut;
    }


    public ArrayList<String> getTopThree() {
        return topThree;
    }

    public void setTopThree(ArrayList<String> topThree) {
        this.topThree = topThree;
    }

    public int[] getUserVector() {
        return userVector;
    }

    public void setUserVector() {
        for (int i = 0; i<generas.length; i++) {
            if (favoriteGenera.equalsIgnoreCase(generas[i])) {
                userVector[i] = 10;
            }
            else {
                userVector[i] = 0;
            }
        }
    }

    public int[] getPcaVector() {
        return pcaVector;
    }

    public void setPcaVector(int[] pcaVector) {
        this.pcaVector = pcaVector;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public Person(String name, String age, String occupation, String favoriteBook, String favoriteGenera) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.favoriteBook = favoriteBook;
        this.favoriteGenera = favoriteGenera;
    }
    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public String getFavoriteGenera() {
        return favoriteGenera;
    }

    public void setFavoriteGenera(String favoriteGenera) {
        this.favoriteGenera = favoriteGenera;
    }
    public ArrayList<Book> getTempList(){
        return tempList;
    }
    public ArrayList<Book> getPermList(){
        return permList;
    }

    public void updateTempList(Book b){
        tempList.add(b);
    }
    public void removeTempList(Book b){
        for (int i = 0; i < tempList.size(); i++) {
            if(tempList.get(i).getTitle().equalsIgnoreCase(b.getTitle())){
                tempList.remove(i);
            }
        }
    }
    public void updatePermList(Book b){
        permList.add(b);
    }
    public void removePermList(Book b){
        for (int i = 0; i < permList.size(); i++) {
            if(permList.get(i).getTitle().equalsIgnoreCase(b.getTitle())){
                permList.remove(i);
            }
        }
    }


}