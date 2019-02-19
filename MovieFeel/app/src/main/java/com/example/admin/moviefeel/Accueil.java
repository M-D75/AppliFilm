package com.example.admin.moviefeel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {

    private TextView mTextMessage;
    private Button mButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_actu:
                    mTextMessage.setText(R.string.title_actu);
                    return true;
                case R.id.navigation_voir:
                    mTextMessage.setText(R.string.title_voir);
                    return true;
                case R.id.navigation_paraitre:
                    mTextMessage.setText(R.string.title_paraitre);
                    return true;
                case R.id.navigation_compte:
                    mTextMessage.setText(R.string.title_compte);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mButton = (Button) findViewById(R.id.buttonImg);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent decouvrirActivityIntent = new Intent(Accueil.this, Decouvrir.class);
                startActivity(decouvrirActivityIntent);
            }
        });
        System.out.println("yo yo");

    }

}
