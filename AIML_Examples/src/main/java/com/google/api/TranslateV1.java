package com.google.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;


@Deprecated
public final class TranslateV1 extends GoogleAPI implements Translate {

    /**
     * Constants.
     */
    private static final String
            LANG_PARAM = "&langpair=",
            TEXT_PARAM = "&q=",
            PIPE_PARAM = "%7C",
            URL = "http://ajax.googleapis.com/ajax/services/language/translate",
            PARAMETERS = "v=2.0&langpair=#FROM#%7C#TO#&q=";

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(final String text, final Language from, final Language to) throws GoogleAPIException {
        try {
            validateReferrer();

            final URL url = new URL(URL);
            final String parameters = PARAMETERS.replaceAll("#FROM#", from.toString()).replaceAll("#TO#", to.toString())
                    +URLEncoder.encode(text, ENCODING) +(key != null ? "&key=" +key : "");

            final JSONObject json = retrieveJSON(url, parameters);

            return getJSONResponse(json);
        } catch (final Exception e) {
            throw new GoogleAPIException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] execute(final String[] text, final Language from, final Language to) throws GoogleAPIException {
        try {
            validateReferrer();

            final Language[] fromArgs = new Language[text.length];
            final Language[] toArgs = new Language[text.length];

            for (int i = 0; i<text.length; i++) {
                fromArgs[i] = from;
                toArgs[i] = to;
            }

            return execute(text, fromArgs, toArgs);
        } catch (final Exception e) {
            throw new GoogleAPIException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] execute(final String text, final Language from, final Language[] to) throws GoogleAPIException {
        try {
            validateReferrer();

            final String[] textArgs = new String[to.length];
            final Language[] fromArgs = new Language[to.length];

            for (int i = 0; i<to.length; i++) {
                textArgs[i] = text;
                fromArgs[i] = from;
            }

            return execute(textArgs, fromArgs, to);
        } catch (final Exception e) {
            throw new GoogleAPIException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] execute(final String[] text, final Language from[], final Language[] to) throws GoogleAPIException {
        try {
            validateReferrer();

            if (text.length != from.length || from.length != to.length) {
                throw new Exception(
                        "[google-api-translate-java] The same number of texts, from and to languages must be supplied.");
            }

            if (text.length == 1) {
                return new String[] { execute(text[0], from[0], to[0]) };
            }

            final String[] responses = new String[text.length];

            final StringBuilder parametersBuilder = new StringBuilder();

            parametersBuilder.append(PARAMETERS.replaceAll("#FROM#", from[0].toString()).replaceAll("#TO#", to[0].toString())  +(key != null ? "&key=" +key : ""));
            parametersBuilder.append(URLEncoder.encode(text[0], ENCODING));

            for (int i = 1; i<text.length; i++) {
                parametersBuilder.append(LANG_PARAM);
                parametersBuilder.append(from[i].toString());
                parametersBuilder.append(PIPE_PARAM);
                parametersBuilder.append(to[i].toString());
                parametersBuilder.append(TEXT_PARAM);
                parametersBuilder.append(URLEncoder.encode(text[i].toString(), ENCODING));
            }

            final URL url = new URL(URL);

            final JSONArray json = retrieveJSON(url, parametersBuilder.toString()).getJSONArray("responseData");

            for (int i = 0; i<json.length(); i++) {
                final JSONObject obj = json.getJSONObject(i);

                responses[i] = getJSONResponse(obj);
            }

            return responses;
        } catch (final Exception e) {
            throw new GoogleAPIException(e);
        }
    }

    /**
     * Returns the JSON response data as a String. Throws an exception if the status is not a 200 OK.
     *
     * @param json The JSON object to retrieve the response data from.
     * @return The responseData from the JSONObject.
     * @throws Exception If the responseStatus is not 200 OK.
     */
    private static String getJSONResponse(final JSONObject json) throws Exception {
        if (json.getString("responseStatus").equals("200")) {
            final String translatedText = json.getJSONObject("responseData").getString("translatedText");
            return HTMLEntities.unhtmlentities(translatedText);
        } else {
            throw new GoogleAPIException("Google returned the following error: [" +json.getString("responseStatus") +"] "
                    +json.getString("responseDetails"));
        }
    }
}