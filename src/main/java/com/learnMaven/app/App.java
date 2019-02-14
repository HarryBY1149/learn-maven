package com.learnMaven.app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.learnMaven.hidden.Hidden;
import com.learnMaven.model.Movie;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class App {
    public static void main(String[] args) throws Exception {
        String params = String.join("%20", args);
        App req = new App();
        System.out.println("Testing GET request");
        req.sendGET(params);
    }

    private void sendGET(String args) throws IOException {
        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";
        // take arguments and make query
        // todo: figure out how to make a map like in the Java doc
        Hidden.setHiddenVars();
        String apiKey = Hidden.getApiKey();
        String apiId = Hidden.getApiId();
        String query = "http://www.omdbapi.com/?t=" + args + "&plot=long&i=" + apiId + "&apikey=" + apiKey;
        // create URL object
        URL url = new URL(query);
        // initalize connection on url
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // setting our method, in this case GET
        con.setRequestMethod("GET");
        con.setRequestProperty("USER_AGENT", USER_AGENT);
        int responseCode = con.getResponseCode();
        // getting our response code, same as res.status in JS
        System.out.println("response code: " + responseCode);

        // now we use Gson to parse our response using streaming method
        InputStreamReader inr = new InputStreamReader(con.getInputStream());
        JsonReader reader = new JsonReader(inr);

        // create our objects to store our response data
        Movie movie = new Movie();
        String key = null;
        // Start parsing the JSON
        key = parseJson(reader, movie, key);
        // close the stream once the END_OBJECT token ahs been consumed
        reader.close();
        // print our result
        System.out.println("Movie Object \n\n" + movie);
    }

    private static String parseJson(JsonReader reader, Movie movie, String key) throws IOException {
        // looping through the response
        while (reader.hasNext()) {
            // GSON magic, checks the value of the next token
            JsonToken token = reader.peek();
            //consume mass tokens!
            switch (token) {
            case BEGIN_OBJECT:
                reader.beginObject();
                break;
            case END_OBJECT:
                reader.endObject();
                break;
            case NAME:
                key = reader.nextName();
                break;
            case STRING:
                setStringMethod(movie, key, reader.nextString(), reader);
                break;
            case END_DOCUMENT:
                System.out.println("End of document");
                break;
            default:
                reader.skipValue();
                break;
            }
        }
        return key;
    }

    private static void setStringMethod(Movie movie, String key, String value, JsonReader reader) throws IOException {       
      //parsing the key : value pairs and saving them to the movie model.
        if ("Title".equals(key))
            movie.setTitle(value);
        else if ("Year".equals(key))
            movie.setYear(value);
        else if ("Rated".equals(key))
            movie.setRating(value);
        else if ("Released".equals(key))
            movie.setReleased(value);
        else if ("Genre".equals(key))
            movie.setGenre(value);
        else if ("Director".equals(key))
            movie.setDirector(value);
        else if ("Writer".equals(key))
            movie.setWriter(value);
        else if ("Actors".equals(key))
            movie.setActors(value);
        else if ("Plot".equals(key))
            movie.setPlot(value);
        else {
            System.out.println("Unused Value: " + value + " with Key: " + key + ".");
        }
    }
}