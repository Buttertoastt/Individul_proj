package com.google.api;



public class Main {

    public static void main(String[] args) throws Exception {
        // Set the HTTP referrer to your website address.
        GoogleAPI.setHttpReferrer("https://script.google.com/macros/s/AKfycbytdxxS4cKrv9XyO3NbE2SgPMw7q8Qp3W_0RR-VBDLqvutXta76uJUEZvCeov222P55Kg/exec");

        // Set the Google Translate API key
        // See: http://code.google.com/apis/language/translate/v2/getting_started.html
        GoogleAPI.setKey("AIzaSyBj9KrPjoc8JHd2Qv9VykOUiVOqJ-k4PKs");

        String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

        System.out.println(translatedText);
    }
}
