package com.learnMaven.app;

import com.learnMaven.model.Movie;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
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
        String query = "http://www.omdbapi.com/?t=" + args + "&plot=long&i=tt3896198&apikey=bbc002e5";
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
        List<String> ratings = new ArrayList<String>();
    }

}