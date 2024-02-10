package edu.uga.cs.comquest.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.util.Utilities;
import edu.uga.cs.comquest.util.homePage;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Button sign_up = findViewById(R.id.sign_up_button);
        EditText username_et = findViewById(R.id.sign_up_username);
        EditText dob_et = findViewById(R.id.sign_up_date);
        EditText email = findViewById(R.id.sign_up_email);
        EditText password = findViewById(R.id.sign_up_password);

        sign_up.setOnClickListener((view) -> {
            if (!checkDoB(dob_et.getText().toString())) {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Must Be 18 Years or older",
                        Toast.LENGTH_SHORT );
                toast.show();
                return;
            }
            String user = username_et.getText().toString() + "#GAP#" + email.getText().toString() + "#GAP#" + password.getText().toString() + "#GAP#";
            Utilities.writeToFile("users.txt", user + "#SPACE#", view.getContext());
            Intent intent_signup = new Intent(view.getContext(), Login.class);
            startActivity(intent_signup);
        });
    }

    public boolean checkDoB(String dob) {
        String[] dateOfBirth = dob.split("/");
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        String[] now_date = currentDate.split("/");
        Integer current_year = Integer.parseInt(now_date[2]);
        Integer legal_year = current_year - 18;

        if (Integer.parseInt(dateOfBirth[2]) > legal_year) {
            return false;
        } else {
            return true;
        }

    }

}