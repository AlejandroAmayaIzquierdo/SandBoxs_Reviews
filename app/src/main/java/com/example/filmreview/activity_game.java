package com.example.filmreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView img = (ImageView) findViewById(R.id.game_imageViewFull);
        TextView desc = (TextView) findViewById(R.id.game_description);

        Intent intent = getIntent();

        Bundle b = intent.getExtras();

        if(b != null){
            img.setImageResource(b.getInt("IMG"));
            desc.setText(b.getString("DESC"));
        }

    }
}