package edu.uga.cs.comquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.uga.cs.comquest.util.afterService;
import edu.uga.cs.comquest.util.homePage;

public class finalScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        Intent intent = getIntent();
        TextView title = findViewById(R.id.screen_client);
        TextView email = findViewById(R.id.screen_email);
        Button home = findViewById(R.id.screen_home);
        Button comp = findViewById(R.id.screen_comp);

        title.setText(intent.getStringExtra("Name"));
        email.setText(intent.getStringExtra("EMAIL"));

        home.setOnClickListener((view) -> {
            Intent to_home = new Intent(getApplicationContext(), homePage.class);
            startActivity(to_home);
        });
        comp.setOnClickListener((view) -> {
            Intent to_home = new Intent(getApplicationContext(), afterService.class);
            to_home.putExtra("Name", intent.getStringExtra("Name"));
            startActivity(to_home);
        });

    }

}