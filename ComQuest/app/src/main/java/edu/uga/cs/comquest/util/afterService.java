package edu.uga.cs.comquest.util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edu.uga.cs.comquest.R;

public class afterService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_service);


        Button home = findViewById(R.id.after_confirm);
        home.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), homePage.class);
            startActivity(intent);
        });
    }

    
}