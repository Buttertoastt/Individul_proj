package com.google.api;

/**
 * @author Richard Midwinter
 */
public interface Translate {

    /**
     * Default instance of the com.google.api.Translate API.
     */
    Translate DEFAULT = new TranslateV2();

    /**
     * Translates text from a given com.google.api.Language to another given com.google.api.Language using Google com.google.api.Translate.
     *
     * @param text The String to translate.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @return The translated String.
     * @throws GoogleAPIException on error.
     */
    String execute(String text, Language from, Language to) throws GoogleAPIException;

    /**
     * Translates an array of text Strings from a given com.google.api.Language to another given com.google.api.Language using Google com.google.api.Translate.
     *
     * @param text The array of Strings to translate.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @return The translated array of String results.
     * @throws GoogleAPIException on error.
     */
    String[] execute(String[] text, Language from, Language to) throws GoogleAPIException;

    /**
     * Translates a String from a given com.google.api.Language to an Array of Languages using Google com.google.api.Translate.
     *
     * @param text The String to translate.
     * @param from The language code to translate from.
     * @param to The array of Languages to translate to.
     * @return The translated array of String results.
     * @throws GoogleAPIException on error.
     */
    String[] execute(String text, Language from, Language[] to) throws GoogleAPIException;

    /**
     * Translates text from a given com.google.api.Language to another given com.google.api.Language using Google com.google.api.Translate.
     *
     * @param text The array of Strings to translate.
     * @param from The array of com.google.api.Language codes to translate from.
     * @param to The array of com.google.api.Language codes to translate to.
     * @return The translated array of String results.
     * @throws GoogleAPIException on error.
     */
    String[] execute(String[] text, Language from[], Language[] to) throws GoogleAPIException;
}