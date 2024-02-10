package edu.uga.cs.comquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_i = findViewById(R.id.button_id);
        TextView text = findViewById(R.id.text_i);

        button_i.setOnClickListener((view) -> {
            text.setText("poop");

        });
    }
}

