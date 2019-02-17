package com.example.admin.moviefeel.models;

public class itemMovie {

    // Variables

    private String imageFilmUrl;
    private String nomFilm;
    private String genreFilm;
    private float noteFilm;

    // Constructeur

    public  itemMovie (String imageFilmUrl, String nomFilm, String genreFilm, float noteFilm){
        this.imageFilmUrl = imageFilmUrl;  // À modifier pour mettre le bon directement avec la methode
        this.nomFilm = nomFilm;
        this.genreFilm = genreFilm;
        this.noteFilm = noteFilm;
    }

    // Methode


    public float getNoteFilm() {
        return noteFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public String getImageFilmUrl() {
        return imageFilmUrl;
    }

    public void setImageFilmUrl(String imageFilmUrl) {
        this.imageFilmUrl = imageFilmUrl;
    }
}
