package com.example.admin.moviefeel;

public class GenreIdTMDB {

    private String name;
    static private Integer id;

    static  public Integer getId(String genre) {
        switch (genre){
            case "Action": {
                id = 28;
                break;
            }
            case "Adventure": {
                id = 12;
                break;
            }
            case "Animation": {
                id = 16;
                break;
            }
            case "Comedy": {
                id = 35;
                break;
            }
            case "Crime": {
                id = 80;
                break;
            }
            case "Documentary": {
                id = 99;
                break;
            }
            case "Drama": {
                id = 18;
                break;
            }
            case "Family": {
                id = 10751;
                break;
            }
            case "Fantasy": {
                id = 14;
                break;
            }
            case "History": {
                id = 36;
                break;
            }
            case "Horror": {
                id = 27;
                break;
            }
            case "Music": {
                id = 10402;
                break;
            }
            case "Mystery": {
                id = 9648;
                break;
            }
            case "Romance": {
                id = 10749;
                break;
            }
            case "Science Fiction": {
                id = 878;
                break;
            }
            case "TV Movie": {
                id = 10770;
                break;
            }
            case "Thriller": {
                id = 53;
                break;
            }
            case "War": {
                id = 10752;
                break;
            }
            case "Western": {
                id = 37;
                break;
            }
        }

        return id;
    }

    public String getName() {
        return name;
    }

}
