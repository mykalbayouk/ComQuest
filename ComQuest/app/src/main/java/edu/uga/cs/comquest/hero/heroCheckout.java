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
import edu.uga.cs.comquest.signin.Login;

public class heroCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_checkout);

        TextView title_hc = findViewById(R.id.info_title);
        TextView attributes_hc = findViewById(R.id.check_attri);

        Intent intent = getIntent();
        String title_inte = intent.getStringExtra("Name");
        String attri_int = intent.getStringExtra("Attri");


        title_hc.setText(title_inte);
        attributes_hc.setText(attri_int);

        Button heroCheckout = findViewById(R.id.coButton);
        Button heroReject =  findViewById(R.id.ntButton);

        switch(intent.getCharExtra("Class", 'x')){
            case 'h':
                heroCheckout.setText("Offer Help!");
                heroReject.setText("Keep Scouting!");
                heroCheckout.setOnClickListener((view) -> {
                    Intent confirm_intent = new Intent(this, HeroList.class);
                    confirm_intent.putExtra("Pending", true);
                    startActivity(confirm_intent);
                });
                heroReject.setOnClickListener((view) -> {
                    Intent reject_intent = new Intent(this, HeroList.class);
                    startActivity(reject_intent);
                });
                break;
            default:
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