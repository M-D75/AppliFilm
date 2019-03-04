package com.example.admin.moviefeel;

import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.lang.*;
import java.util.concurrent.CountDownLatch;

public class Decouvrir extends AppCompatActivity  {
    // CTRL + SHIFT + A

    // GridWidth/NumGridColumn


    /*

    ImageView mPostImage;

    public ViewHolder(View itemView, ImageView postImage_
        super(itemView);
        mPostImage = postImage;
        int gridWidth = mContext.getRessources().getDisplayMetrics.widthPixels;
        int imageWidth = gridWidth = gridWidth/NumGridColumn;
        mPostImage.setMaxWidth(imageWidth);



     */

    private TextView mTextMessage;
    private Button boutonImage;
    private ImageView imageFilm;
    private String urlImageFilm;
    private Spinner listeGenre;

    private List<String> genre = new ArrayList<String>();

    private URL url;

    int largeurEcran;

    // Taille image standard : 500 x 750

    public static int largeurImage; // Division par 3 de la largeur de l'écran + ajustement pour marge.
    public static int hauteurImage; // Multiplication pour respecter le facteur de la hauteur


    // Vraaaai

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<UserViewHolder> mAdapter;
    private GridLayoutManager layoutManager;

    public static List<HashMap<String, String>> liste;



    private String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
//    private List<HashMap<String, String>> liste = RequeteTMDB.hashMapRequete(requete);

    public Decouvrir() throws IOException {


    }

    protected int getLargeurImage(){
        return largeurImage;
    }

    protected int getHauteurImage(){
        return hauteurImage;
    }

    List <String> mUsers = Arrays.asList("Guillaume", "Quentin", "Romain");

    private void configureRecyclerView() {
        layoutManager = new GridLayoutManager(Decouvrir.this, 3);
        mAdapter = new MyAdapter(liste);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    //Ajout d'une nouvel page a la liste
    public static List<HashMap<String, String>> refresh(final List<HashMap<String, String>> liste, final Integer num_page){
        final CountDownLatch latch = new CountDownLatch(1);
        final String[] value = new String[1];
        Thread uiThread = new HandlerThread("UIHandler2"){
            @Override
            public void run(){

                String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"), num_page);
                System.out.println(requete);
                try{
                    List<HashMap<String, String>> l = RequeteTMDB.hashMapRequete(requete);
                    liste.addAll(l);
                }
                catch ( IOException e ){
                    System.out.print("err");
                }

                latch.countDown();
            }
        };
        uiThread.start();

        try {
            latch.await(); // Wait for countDown() in the UI thread. Or could uiThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Errrr ");
        }
        return liste;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decouvrir);
        String urlImageFilm;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        // On récupère la largeur de l'écran

        largeurEcran = metrics.widthPixels;

        largeurImage = (largeurEcran/3);
        hauteurImage = ((largeurImage*750)/500);

        final CountDownLatch latch = new CountDownLatch(1);
        final String[] value = new String[1];
        Thread uiThread = new HandlerThread("UIHandler"){
            @Override
            public void run(){

                String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));

                liste = null;
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


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listeGenre = (Spinner) findViewById(R.id.spinner);
        this.configureRecyclerView();

        genre.add(0, "Action");
        genre.add("Aventure");
        genre.add("Thriller");

        // Initialisation du spinner

        ArrayAdapter<String> dateAdapter;
        dateAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, genre);

        listeGenre.setAdapter(dateAdapter);
        listeGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Choose")){

                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        /*
        System.out.println("value " + value[0]);
        urlImageFilm = value[0];

        //mTextMessage = (TextView) findViewById(R.id.message);

        boutonImage = (Button) findViewById(R.id.buttonImage);
        imageFilm = (ImageView) findViewById(R.id.imageFilm);

        System.out.println("urlll " + urlImageFilm);

        //Picasso.with(this).load("http://www.linternaute.com/cinema/image_cache/objdbfilm/image/540/120453.jpg").into(imageFilm);

        if( urlImageFilm != null )
            Picasso.with(this).load(urlImageFilm).into(imageFilm);

        */

    }

}
