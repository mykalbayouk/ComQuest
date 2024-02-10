package edu.uga.cs.comquest.hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.uga.cs.comquest.R;

public class HeroList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);

        createCard("Engine Fix", "10 year old engine", "5");


    }

    private void createCard(String jobName, String neededAbilities, String location) {
        CardView jobCards = new CardView(getApplicationContext());
        LinearLayout linearLayout = findViewById(R.id.hero_lin_lay);

        CardView.LayoutParams layoutparams= new CardView.LayoutParams(
                CardView.LayoutParams.MATCH_PARENT,
                CardView.LayoutParams.WRAP_CONTENT
        );

        layoutparams.setMargins(25, 25, 25, 0);
        jobCards.setLayoutParams(layoutparams);
        jobCards.setRadius(15);
        jobCards.setPadding(25, 25, 25, 25);
        jobCards.setMaxCardElevation(30);
        jobCards.setMaxCardElevation(6);
        jobCards.setClickable(true);

        jobCards.setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(), HeroInfo.class);
            intent.putExtra("Name", jobName);
            intent.putExtra("Attri", neededAbilities);
            startActivity(intent);
        });

        LinearLayout v_box = new LinearLayout(this);
        v_box.setPadding(25,25, 25, 25);
        v_box.setOrientation(LinearLayout.VERTICAL);

        TextView job_title = new TextView(this);
        job_title.setGravity(Gravity.LEFT);
        job_title.setText(jobName);
        job_title.setTextSize(25);

        TextView needAbils = new TextView(this);
        needAbils.setGravity(Gravity.LEFT);
        needAbils.setText(neededAbilities);
        needAbils.setTextSize(20);
        needAbils.setTextColor(ColorStateList.valueOf(Color.GRAY));

        TextView location_tv = new TextView(this);
        location_tv.setGravity(Gravity.RIGHT);
        location_tv.setText(location + " Km");
        location_tv.setTextSize(17);


        v_box.addView(job_title);
        v_box.addView(needAbils);
        v_box.addView(location_tv);
        jobCards.addView(v_box);

        linearLayout.addView(jobCards);
    }



}