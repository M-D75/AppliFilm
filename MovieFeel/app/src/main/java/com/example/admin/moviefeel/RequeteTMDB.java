package com.example.admin.moviefeel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static String discover(String requete, Integer num_page){
        String requeteUrl = "https://api.themoviedb.org/3/discover/movie?api_key=";
        requeteUrl += apiKey;
        requeteUrl += "&";
        requeteUrl += requete;
        requeteUrl += "&page="+num_page;
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

    //Retour une liste de HashMap contenant les infos du film
    public static List<HashMap<String, String>> hashMapRequete(String requete) throws IOException {
        StringBuilder affichage = new StringBuilder();
        System.out.println("Requete : "+requete);
        URL url = new URL(requete);

        //https://assistant-chat-au-syd.watsonplatform.net/web/public/f64b1844-04e5-4412-891c-e1cf3bf59616
        //URL url = new URL("https://api.themoviedb.org/3/movie/550?api_key=c36506bd3193be04b65c8828935dc788");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((con.getInputStream())));
        List<HashMap<String, String>> hashMapList = new ArrayList<HashMap<String, String>>();

        //Affichage du resultat de la requete
        String output;
        //System.out.println("Sortie du Server .... \n");
        Boolean premiere_requete = false;
        while ((output = bufferedReader.readLine()) != null ) {
            //System.out.println("outp : "+output);

            HashMap<String, String> hashMap =  new HashMap<String, String>();
            //System.out.println("end");
            String tabS[] = output.split(",\"");

            for (String s: tabS) {
                if(choixAffichage(s)){
                    String tabSs[] = s.split("\":");

                    //System.out.println(tabSs[0] + " " + tabSs[1]);
                    if( tabSs[0].compareTo("id") == 0 && premiere_requete){
                        hashMapList.add(hashMap);
                        hashMap = new HashMap<String, String>();
                        //System.out.println("\n");
                        //affichage.append("\n");
                    }
                    else if(tabSs[0].compareTo("id") == 0){
                        premiere_requete = true;
                    }

                    //Suppression des guillemets
                    tabSs[1] = tabSs[1].replaceAll("\"", "");
                    hashMap.put(tabSs[0], tabSs[1]);

                    //affichage.append(s);
                    //System.out.println(s);
                }
            }
            hashMapList.add(hashMap);
            //affichage.append("--------------------------------------------------------------------------------------------------------------");
            //System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
        //System.out.println(hashMapList.get(0));
        return hashMapList;
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

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((con.getInputStream())));

        //Affichage du resultat de la requete
        String output;
        System.out.println("Sortie du Server .... \n");
        while ((output = bufferedReader.readLine()) != null) {
            //System.out.println(output);

            //System.out.println("end");
            String tabS[] = output.split(",\"");
            for (String s: tabS) {
                if(choixAffichage(s)){
                    String tabSs[] = s.split("\":");

                    //System.out.println(tabSs[0] + " " + tabSs[1]);
                    if( tabSs[0].compareTo("id") == 0 ){
                        //System.out.println("");
                        affichage.append("\n");
                    }
                    affichage.append(s);
                    //System.out.println(s);
                }

            }
            affichage.append("--------------------------------------------------------------------------------------------------------------");
            //System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
        //System.out.println(h.get(0));
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
            case "poster_path\"":{
                return true;
            }
        }

        return false;
    }

    /* Permet de récupérer une image à partir de la HashMap passé en paramètre */

    public static String recupererImage (HashMap<String, String> listeHash) {
        String requeteImage = "http://image.tmdb.org/t/p/w185/"; // Adresse de base par récupérer les images
        String posterPath = (String) listeHash.get("poster_path");

        posterPath = posterPath.substring(1); // Il est nécessaire d'enlever le premier caractère pour être conforme
        requeteImage += posterPath; // On assemble l'adresse

        return requeteImage;
    }

}
