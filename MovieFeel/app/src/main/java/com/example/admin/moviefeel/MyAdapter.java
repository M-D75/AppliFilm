package com.example.admin.moviefeel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import static com.example.admin.moviefeel.Decouvrir.liste;

class MyAdapter extends RecyclerView.Adapter <UserViewHolder> {


    Context context;

    String requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
    String urlImageFilm;


    //RequeteTMDB.recupererImage(liste.get(i));



    public MyAdapter(List<HashMap<String, String>> liste) {
        Decouvrir.liste = liste;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_picture_movies, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder myViewHolder, int i) {
        urlImageFilm = RequeteTMDB.recupererImage(liste.get(i));
        if (urlImageFilm != null) {
            Picasso.with(context).load(urlImageFilm).into(myViewHolder.imageView);
        }

        myViewHolder.textView.setText(liste.get(i).get("title"));


        //myViewHolder.imageView

                // updateWithUser(this.users.get(i), this.users.get(i));
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

}
