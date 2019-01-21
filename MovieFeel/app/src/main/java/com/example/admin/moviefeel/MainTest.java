package com.example.admin.moviefeel;

import org.json.JSONException;
import org.json.JSONObject;
//import javax.json.stream.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class MainTest {
    public static void main(String [ ] args) throws IOException {

        //Test de requete
        /*try {
            //JSONObject json = (JSONObject) parser.parse(stringToParse);
            //JSONObject jsonObj = new JSONObject();

            //JSONObject jsonObj = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }*/

        //id
        String requete = RequeteTMDB.id(550);
        System.out.println("Id");
        RequeteTMDB.affichageRequete(requete);

        //search
        requete = RequeteTMDB.search("infinity+War");
        System.out.println("Recherche");
        RequeteTMDB.affichageRequete(requete);

        //discover
        requete = RequeteTMDB.discover("primary_release_date.gte=2014-09-15");
        System.out.println("Discover");
        RequeteTMDB.affichageRequete(requete);

        //discover genre
        requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
        System.out.println("Genre");
        RequeteTMDB.affichageRequete(requete);

        //Exemple pour recuperer une infos
        List<HashMap<String, String>> liste = RequeteTMDB.hashMapRequete(requete);
        System.out.println("contenu de la liste: " + liste);
        System.out.println("Affichage du titre du film qui se trouve a la premieur possition dans la liste par exemple: ");
        System.out.println(liste.get(0).get("original_title"));
        System.out.println(liste.get(0).get("overview"));
        System.out.println(liste.get(0).get("poster_path"));

        // Construction image

        String requeteImage = "http://image.tmdb.org/t/p/w185/";
        String posterPath = (String) liste.get(0).get("poster_path");



        System.out.println("AAA : " + posterPath);
        System.out.println("BBB : " + requeteImage);
        requeteImage += posterPath;
        //requeteImage += "sPVs1vowAKEGqsrPZiAGeTgNd3m.jpg";
        System.out.println("Image");
        System.out.println(requeteImage);



        //https://api.themoviedb.org/3/genre/movie/list?api_key=c36506bd3193be04b65c8828935dc788

        //https://assistant-chat-au-syd.watsonplatform.net/web/public/f64b1844-04e5-4412-891c-e1cf3bf59616
        /*URL url = new URL("https://assistant-chat-au-syd.watsonplatform.net/web/public/f64b1844-04e5-4412-891c-e1cf3bf59616");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        //Affichage du resultat de la requete
        String output;
        System.out.println("Sortie du Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            //System.out.println("end");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }*/
    }
}
