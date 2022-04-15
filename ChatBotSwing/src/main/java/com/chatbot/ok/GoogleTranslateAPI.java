package com.chatbot.ok;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import org.json.simple.*;

public class GoogleTranslateAPI {

    public String Translate(String sentence) throws IOException {


        //String api_key="";

        // Load the API key
        String api_key = "AIzaSyBj9KrPjoc8JHd2Qv9VykOUiVOqJ-k4PKs";

        // Prepare HTTP connection
        String url = "https://translation.googleapis.com/language/translate/v2?key=" + api_key;
        URL object = new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");


        // Create JSON object for Translate request
        JSONObject request = new JSONObject();
        JSONArray q = new JSONArray();

        // Text to translate and source/target language params go here
        q.add(sentence);
        //q.add("Hello, my name is David.");
        request.put("q", q);
        request.put("source", "es");
        request.put("target", "en");

        // Establish the connection
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(request.toString());
        wr.flush();
        //System.out.println("Sending request...");

        // Get the response
        int HttpResult = con.getResponseCode();
        String translatedText = " ";
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            String line, result = null;
            while ((line = br.readLine()) != null) {
                // Uncomment below to see entire response
                // System.out.println(line);

                // Save just the translated text line
                if (line.contains("translatedText")) {
                    result = line;
                }
            }
            br.close();

            // Parse the line with the translated text and display only the result
            // Note: Including a colon (:) in the text to translate will mess up the parsing
            String[] arr = result.split(":");
            translatedText = arr[1].substring(2, arr[1].length() - 1);
            //System.out.println(translatedText);
            return translatedText;
        }
        return con.getResponseMessage();
    }
}

