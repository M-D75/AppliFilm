package com.example.admin.moviefeel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MainTest{
    public static void main(String [ ] args) {
        String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
        List<HashMap<String, String>> liste = null;
        try{
            liste = RequeteTMDB.hashMapRequete(requete);
            System.out.println("ll "+liste.get(0));
            String s = RequeteTMDB.recupererImage(liste.get(0));
            System.out.print("Po " + s);
        }
        catch ( IOException e){
            System.out.print("err");
        }
        System.out.println("\n");
        System.out.println("AFFICHAGE TITRE : ");
        System.out.println(liste.get(0).get("title"));
    }
}
