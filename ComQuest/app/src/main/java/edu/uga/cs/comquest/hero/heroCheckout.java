package edu.uga.cs.comquest.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.civilian.CivilianList;
import edu.uga.cs.comquest.finalScreen;
import edu.uga.cs.comquest.signin.Login;
import edu.uga.cs.comquest.util.Utilities;

public class heroCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_checkout);

        TextView title_hc = findViewById(R.id.info_title);
        TextView attributes_hc = findViewById(R.id.check_attri);
        TextView quals = findViewById(R.id.hero_check_quals);

        Intent intent = getIntent();
        String title_inte = intent.getStringExtra("Name");
        String attri_int = intent.getStringExtra("Attri");




        Button heroCheckout = findViewById(R.id.coButton);
        Button heroReject =  findViewById(R.id.ntButton);

        String username_i = Utilities.readFromFile("users.txt", getApplicationContext()).split("#SPACE")[0].split("#GAP#")[0];

        switch(intent.getCharExtra("Class", 'x')){
            case 'h':
                title_hc.setText(username_i);
                attributes_hc.setText(title_inte + "\n"+ attri_int);
                heroCheckout.setText("Offer Help!");
                heroReject.setText("Keep Scouting!");
                quals.setText("Help Needed!");
                heroCheckout.setOnClickListener((view) -> {
                    Intent confirm_intent = new Intent(this, finalScreen.class);
                    confirm_intent.putExtra("Name", username_i);
                    confirm_intent.putExtra("EMAIL", Utilities.readFromFile("users.txt", getApplicationContext()).split("#SPACE")[0].split("#GAP#")[1]);
                    startActivity(confirm_intent);
                });
                heroReject.setOnClickListener((view) -> {
                    Intent reject_intent = new Intent(this, HeroList.class);
                    startActivity(reject_intent);
                });
                break;
            default:
                title_hc.setText(username_i);
                attributes_hc.setText(attri_int);
                heroCheckout.setText("Request Help");
                heroReject.setText("Keep Scouting!");
                quals.setText("Abilities");
                heroCheckout.setOnClickListener((view) -> {
                    Intent confirm_intent = new Intent(this, CivilianList.class);
                    confirm_intent.putExtra("Status", true);
                    startActivity(confirm_intent);
                });
                heroReject.setOnClickListener((view) -> {
                    Intent reject_intent = new Intent(this, CivilianList.class);
                    startActivity(reject_intent);
                });
        }


    }

}