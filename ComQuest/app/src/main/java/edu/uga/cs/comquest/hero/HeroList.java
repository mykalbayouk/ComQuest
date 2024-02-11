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
import edu.uga.cs.comquest.util.Utilities;

public class HeroList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);

        String civ_task = Utilities.readFromFile("civil.txt", getApplicationContext());
        String[] civ_task_list = civ_task.split("#NEWQUEST#");
        for (int i = 0; i < civ_task_list.length; i++) {
            String[] civ_one = civ_task_list[i].split("#GAP#");
            createCard(civ_one[0], civ_one[1], "3", false);
        }

            createCard("Engine Fix", "10 year old engine", "5", false);




    }

    private void createCard(String jobName, String neededAbilities, String location, Boolean pending) {
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
        if (pending) {
            jobCards.setCardBackgroundColor(Color.rgb(181, 240, 93));
        }



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

        jobCards.setOnClickListener((view) -> {
            linearLayout.removeAllViews();
            Intent intent = new Intent(getApplicationContext(), heroCheckout.class);
            intent.putExtra("Name", jobName);
            intent.putExtra("Attri", neededAbilities);
            intent.putExtra("Class", 'h');
            startActivity(intent);
        });

        linearLayout.addView(jobCards);
    }



}