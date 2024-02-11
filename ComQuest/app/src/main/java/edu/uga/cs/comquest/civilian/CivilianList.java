package edu.uga.cs.comquest.civilian;

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
import edu.uga.cs.comquest.hero.heroCheckout;

public class CivilianList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilian_list);

        //String heroes_string = Utilities.readFromFile("heroes.txt", getApplicationContext());
        //String[] heroes_list = heroes_string.split("#NEWHERO#");


        Intent intent = getIntent();
        if (intent.getBooleanExtra("Status", false)){
            //String[] hero_one = heroes_list[0].split("#GAP#");
            //createCard(hero_one[0], hero_one[1], "3", true);
            createCard("Janice", "Fixing cleaning", "5", true);
        } else {
//            for (int i = 0; i < civ_task_list.length; i++) {
//                String[] civ_one = civ_task_list[i].split("#GAP#");
//                createCard(civ_one[0], civ_one[1], "3", false);
//            }

            createCard("Janice", "Fixing cleaning", "5", false);


        }
    }

    private void createCard(String name, String attributes, String location, Boolean status) {
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
        if (status) {
            heroCards.setCardBackgroundColor(Color.rgb(181, 240, 93));
        }

        heroCards.setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(), heroCheckout.class);
            intent.putExtra("Name", name);
            intent.putExtra("Attri", attributes);
            intent.putExtra("Class", 'c');
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