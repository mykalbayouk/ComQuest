package edu.uga.cs.comquest.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.util.homePage;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button login = findViewById(R.id.login_button);

        login.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), homePage.class);
            startActivity(intent);
        });

    }



}