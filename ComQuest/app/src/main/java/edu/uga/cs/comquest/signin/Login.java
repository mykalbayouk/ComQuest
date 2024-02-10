package edu.uga.cs.comquest.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.util.Utilities;
import edu.uga.cs.comquest.util.homePage;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button login = findViewById(R.id.login_button);
        EditText username_et = findViewById(R.id.login_username);
        EditText password_et = findViewById(R.id.login_password);

        login.setOnClickListener((view) -> {
            if (usernameExist(username_et.getText().toString(), view.getContext())) {
                if (correctPassword(username_et.getText().toString(), password_et.getText().toString(), view.getContext())) {
                    Intent intent = new Intent(view.getContext(), homePage.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText( getApplicationContext(),
                            "Incorrect Password",
                            Toast.LENGTH_SHORT );
                    toast.show();
                    return;
                }
            } else {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Username not found",
                        Toast.LENGTH_SHORT );
                toast.show();
                return;
            }

            Intent intent_signup = new Intent(view.getContext(), homePage.class);
            startActivity(intent_signup);


        });

    }

    private boolean usernameExist(String username, Context context) {
        String fileData = Utilities.readFromFile("users.txt", context);
        String[] temp = fileData.split("#SPACE#");
        ArrayList<String> usernames = new ArrayList<>();
        for (String s : temp) {
            String[] temp2 = s.split("#GAP#");
            usernames.add(temp2[0].replaceAll("\\s", "").toLowerCase());

        }
        for(int j = 0; j < usernames.size(); j++) {
            if (usernames.get(j).equals(username.replaceAll("\\s", "").toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean correctPassword(String username, String password, Context context) {
        String fileData = Utilities.readFromFile("users.txt", context);
        String[] temp = fileData.split("#SPACE#");
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        for (String s : temp) {
            String[] temp2 = s.split("#GAP#");
            usernames.add(temp2[0].replaceAll("\\s", "").toLowerCase());
            passwords.add(temp2[2].replaceAll("\\s", ""));
        }
        for (int j = 0; j < usernames.size(); j++) {
            if(usernames.get(j).equals(username.replaceAll("\\s", "").toLowerCase())){
                if(passwords.get(j).equals(password.replaceAll("\\s", ""))) {
                    return true;
                }
            }
        }
        return false;
    }



}