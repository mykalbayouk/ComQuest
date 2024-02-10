package edu.uga.cs.comquest.util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.hero.HQualif;
import edu.uga.cs.comquest.signin.SignUp;

public class homePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button hero_but = findViewById(R.id.home_hero);
        hero_but.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), HQualif.class);
            startActivity(intent);
        });



    }
}