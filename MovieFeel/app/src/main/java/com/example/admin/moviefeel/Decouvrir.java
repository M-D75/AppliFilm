package com.example.admin.moviefeel;

import android.os.Bundle;
import android.os.HandlerThread;
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
import java.util.concurrent.CountDownLatch;

public class Decouvrir extends AppCompatActivity  {

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
        String urlImageFilm;

        final CountDownLatch latch = new CountDownLatch(1);
        final String[] value = new String[1];
        Thread uiThread = new HandlerThread("UIHandler"){
            @Override
            public void run(){

                String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));

                List<HashMap<String, String>> liste = null;
                try{
                    liste = RequeteTMDB.hashMapRequete(requete);
                }
                catch ( IOException e ){
                    System.out.print("err");
                }
                String urlImageFilm;
                if(liste != null) {
                    urlImageFilm = RequeteTMDB.recupererImage(liste.get(0));
                    value[0] = urlImageFilm;
                }
                else{
                    urlImageFilm = null;
                }

                System.out.println("urlll " + urlImageFilm);
                latch.countDown();
            }
        };
        uiThread.start();

        try {
            latch.await(); // Wait for countDown() in the UI thread. Or could uiThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Errrr ");
        }

        System.out.println("value " + value[0]);
        urlImageFilm = value[0];

        //mTextMessage = (TextView) findViewById(R.id.message);

        boutonImage = (Button) findViewById(R.id.buttonImage);
        imageFilm = (ImageView) findViewById(R.id.imageFilm);

        System.out.println("urlll " + urlImageFilm);

        //Picasso.with(this).load("http://www.linternaute.com/cinema/image_cache/objdbfilm/image/540/120453.jpg").into(imageFilm);

        if( urlImageFilm != null )
            Picasso.with(this).load(urlImageFilm).into(imageFilm);


    }

}
