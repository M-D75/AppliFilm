package com.example.admin.moviefeel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequeteTMDB {
    //La cle de l'API pour les requete
    private static String apiKey = "c36506bd3193be04b65c8828935dc788";

    //Requete avec le /search
    public static String search(String requete){
        String requeteUrl = "https://api.themoviedb.org/3/search/movie?api_key=";
        requeteUrl += apiKey;
        requeteUrl += "&query=";
        requeteUrl += requete;
        return requeteUrl;
    }

    //Requete avec le /dicover
    public static String discover(String requete){
        String requeteUrl = "https://api.themoviedb.org/3/discover/movie?api_key=";
        requeteUrl += apiKey;
        requeteUrl += "&";
        requeteUrl += requete;
        return requeteUrl;
    }

    //Requete avec le /dicover selon le genre
    public static String discoverGenres(String requete, String genres){
        String requeteUrl = "https://api.themoviedb.org/3/discover/movie?api_key=";
        requeteUrl += apiKey;
        requeteUrl += "&";
        requeteUrl += requete;
        requeteUrl += "&with_genres=" + genres;
        return requeteUrl;
    }

    //Requete avec /id passer en chaine de caractere
    public static String id(String idRequete){
        String requeteUrl = "https://api.themoviedb.org/3/movie/";
        requeteUrl += idRequete;
        requeteUrl += "?api_key=" + apiKey;
        return requeteUrl;
    }

    //Requete avec /id passer en Integer
    public static String id(Integer idRequete){
        String requeteUrl = "https://api.themoviedb.org/3/movie/";
        requeteUrl += idRequete;
        requeteUrl += "?api_key=" + apiKey;
        return requeteUrl;
    }

    public static String affichageRequete(String requete) throws IOException {
        StringBuilder affichage = new StringBuilder();
        System.out.println("Requete : "+requete);
        URL url = new URL(requete);

        //https://assistant-chat-au-syd.watsonplatform.net/web/public/f64b1844-04e5-4412-891c-e1cf3bf59616
        //URL url = new URL("https://api.themoviedb.org/3/movie/550?api_key=c36506bd3193be04b65c8828935dc788");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        //Affichage du resultat de la requete
        String output;
        System.out.println("Sortie du Server .... \n");
        while ((output = br.readLine()) != null) {
            //System.out.println(output);
            //System.out.println("end");
            String tabS[] = output.split(",\"");
            for (String s: tabS) {
                if(choixAffichage(s)){
                    String tabSs[] = s.split(":");
                    if( tabSs[0].compareTo("id\"") == 0 ){
                        System.out.println("");
                        affichage.append("\n");
                    }
                    affichage.append(s);
                    System.out.println(s);
                }

            }
            affichage.append("--------------------------------------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }

        return affichage.toString();
    }

    private static boolean choixAffichage(String chaine){
        String tabS[] = chaine.split(":");

        switch (tabS[0]){
            case "title\"":{
                return true;
            }
            case "original_title\"":{
                return true;
            }
            case "id\"":{
                return true;
            }
            case "original_language\"":{
                return true;
            }
            case "release_date\"":{
                return true;
            }
            case "overview\"":{
                return true;
            }
            case "name\"":{
                return true;
            }
            case "genre_ids\"":{
                return true;
            }
        }

        return false;
    }


}
