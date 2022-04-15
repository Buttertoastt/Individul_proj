package com.google.api;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;

/**
 * Makes the Google Detect API available to Java applications.
 *
 * @author Richard Midwinter
 * @author Soren AD <soren@tanesha.net>
 */
public class Detect extends GoogleAPI {

    /**
     * Constants.
     */
    private static String URL = "https://www.googleapis.com/language/translate/v2/detect?key=" + GoogleAPI.key + "&q=";

    /**
     * Detects the language of a supplied String.
     *
     * @param text The String to detect the language of.
     * @return A com.google.api.DetectResult object containing the language, confidence and reliability.
     * @throws Exception on error.
     */
    public static DetectResult execute(final String text) throws Exception {
        validateReferrer();

        final URL url = new URL(URL +URLEncoder.encode(text, ENCODING));

        final JSONObject json = retrieveJSON(url);

        JSONObject results = (JSONObject) ((JSONArray) json.getJSONObject("data").getJSONArray("detections").get(0)).get(0);
        return new DetectResult(
                Language.fromString(results.getString("language")),
                results.getBoolean("isReliable"),
                results.getDouble("confidence"));
    }
}