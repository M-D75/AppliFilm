package com.example.admin.moviefeel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainTest {
    public static void main(String [ ] args) throws IOException {

        //Test de requete

        //id
        String requete = RequeteTMDB.id(550);
        RequeteTMDB.affichageRequete(requete);

        //search
        requete = RequeteTMDB.search("infinity+War");
        RequeteTMDB.affichageRequete(requete);

        //discover
        requete = RequeteTMDB.discover("primary_release_date.gte=2014-09-15");
        RequeteTMDB.affichageRequete(requete);

        //discover genre
        requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
        RequeteTMDB.affichageRequete(requete);

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
