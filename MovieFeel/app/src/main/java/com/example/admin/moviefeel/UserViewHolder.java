package com.example.admin.moviefeel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public UserViewHolder(View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.titreFilm);
        this.imageView = itemView.findViewById(R.id.imageFilm);
    }

}
