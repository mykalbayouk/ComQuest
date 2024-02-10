package edu.uga.cs.comquest.civilian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.hero.HeroInfo;
import edu.uga.cs.comquest.hero.heroCheckout;
import edu.uga.cs.comquest.util.Utilities;

public class CivilianList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilian_list);

        //String heroes_string = Utilities.readFromFile("heroes.txt", getApplicationContext());
        //String[] heroes_list = heroes_string.split("#NEWHERO#");

        createCard("Janice", "Fixing cleaning", "5");


    }

    private void createCard(String name, String attributes, String location) {
        CardView heroCards = new CardView(getApplicationContext());
        LinearLayout linearLayout = findViewById(R.id.civ_linear_layout);

        CardView.LayoutParams layoutparams= new CardView.LayoutParams(
                CardView.LayoutParams.MATCH_PARENT,
                CardView.LayoutParams.WRAP_CONTENT
        );

        layoutparams.setMargins(25, 25, 25, 0);
        heroCards.setLayoutParams(layoutparams);
        heroCards.setRadius(15);
        heroCards.setPadding(25, 25, 25, 25);
        heroCards.setMaxCardElevation(30);
        heroCards.setMaxCardElevation(6);
        heroCards.setClickable(true);

        heroCards.setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(), heroCheckout.class);
            intent.putExtra("Name", name);
            intent.putExtra("Attri", attributes);
            startActivity(intent);
        });

        LinearLayout v_box = new LinearLayout(this);
        v_box.setPadding(25,25, 25, 25);
        v_box.setOrientation(LinearLayout.VERTICAL);

        TextView hero_title = new TextView(this);
        hero_title.setGravity(Gravity.LEFT);
        hero_title.setText(name);
        hero_title.setTextSize(25);

        TextView attribute = new TextView(this);
        attribute.setGravity(Gravity.LEFT);
        attribute.setText(attributes);
        attribute.setTextSize(20);
        attribute.setTextColor(ColorStateList.valueOf(Color.GRAY));

        TextView location_tv = new TextView(this);
        location_tv.setGravity(Gravity.RIGHT);
        location_tv.setText(location + " Km");
        location_tv.setTextSize(17);


        v_box.addView(hero_title);
        v_box.addView(attribute);
        v_box.addView(location_tv);
        heroCards.addView(v_box);

        linearLayout.addView(heroCards);
    }


}