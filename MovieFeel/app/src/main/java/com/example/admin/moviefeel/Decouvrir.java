package com.example.admin.moviefeel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import java.lang.*;

public class Decouvrir extends AppCompatActivity {

    // CTRL + SHIFT + A

    private TextView mTextMessage;
    private Button boutonImage;
    private ImageView imageFilm;
    private String urlImageFilm;

    private URL url;

    private String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
//    private List<HashMap<String, String>> liste = RequeteTMDB.hashMapRequete(requete);

    public Decouvrir() throws IOException {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decouvrir);

        mTextMessage = (TextView) findViewById(R.id.message);

        boutonImage = (Button) findViewById(R.id.buttonImage);
        imageFilm = (ImageView) findViewById(R.id.imageFilm);
        //urlImageFilm = RequeteTMDB.recupererImage(liste.get(0));

        Picasso.with(this).load("http://www.linternaute.com/cinema/image_cache/objdbfilm/image/540/120453.jpg").into(imageFilm);


    }

}
