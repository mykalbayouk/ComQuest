package edu.uga.cs.comquest.util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.signin.Login;

public class heroCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_checkout);

        Button heroCheckout = findViewById(R.id.coButton);
        Button heroReject =  findViewById(R.id.ntButton);

        heroCheckout.setOnClickListener((view) -> {
            Intent confirm_intent = new Intent(this, CivilianList.class);
            startActivity(confirm_intent);
        });
        heroReject.setOnClickListener((view) -> {
            Intent reject_intent = new Intent(this, CivilianList.class);
            startActivity(reject_intent);
        });
    }

}