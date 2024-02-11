package edu.uga.cs.comquest.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edu.uga.cs.comquest.R;

public class HQualif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hqualif);

        Button submit = findViewById(R.id.hero_qual_submit);

        submit.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), HeroList.class);
            startActivity(intent);
        });
    }


}