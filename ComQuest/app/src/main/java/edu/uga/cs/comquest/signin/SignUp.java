package edu.uga.cs.comquest.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.util.Utilities;
import edu.uga.cs.comquest.util.homePage;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Button sign_up = findViewById(R.id.sign_up_button);


        sign_up.setOnClickListener((view) -> {
            Intent intent_signup = new Intent(view.getContext(), homePage.class);
            startActivity(intent_signup);
        });
    }

}