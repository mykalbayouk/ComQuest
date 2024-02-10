package edu.uga.cs.comquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edu.uga.cs.comquest.signin.Login;
import edu.uga.cs.comquest.signin.SignUp;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sign_up = findViewById(R.id.main_sign_up);
        Button login = findViewById(R.id.main_login);


        sign_up.setOnClickListener((view) -> {
            Intent intent_signup = new Intent(view.getContext(), SignUp.class);
            startActivity(intent_signup);
        });
        login.setOnClickListener((view) -> {
            Intent intent_login = new Intent(view.getContext(), Login.class);
            startActivity(intent_login);
        });


    }

}

