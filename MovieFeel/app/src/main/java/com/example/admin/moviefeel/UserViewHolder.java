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

        this.imageView.getLayoutParams().width = Decouvrir.largeurImage;
        this.imageView.getLayoutParams().height = Decouvrir.hauteurImage;

        System.out.println("Width : " + Decouvrir.largeurImage);
        System.out.println("height : " + Decouvrir.hauteurImage);

        //imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

}
