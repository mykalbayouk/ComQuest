package edu.uga.cs.comquest.util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.uga.cs.comquest.R;
import edu.uga.cs.comquest.hero.HQualif;
import edu.uga.cs.comquest.signin.SignUp;

public class homePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        Button hero_but = findViewById(R.id.home_hero);
        hero_but.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), HQualif.class);
            startActivity(intent);
        });

        Button ref_button = findViewById(R.id.refButton);
        Spinner first_spinner = findViewById(R.id.spinner2);
        Spinner blank_spinner = findViewById(R.id.spinner3);
        Spinner car_spinner = findViewById(R.id.spinner4);
        Spinner house_spinner = findViewById(R.id.spinner5);
        Spinner yard_spinner = findViewById(R.id.spinner6);
        Spinner comp_spinner = findViewById(R.id.spinner7);

        ref_button.setOnClickListener((view)-> {
                String selectedItem = (String) first_spinner.getSelectedItem();
                switch(selectedItem) {
                    case "Car":
                        blank_spinner.setVisibility(View.GONE);
                        car_spinner.setVisibility(View.VISIBLE);
                        house_spinner.setVisibility(View.GONE);
                        yard_spinner.setVisibility(View.GONE);
                        comp_spinner.setVisibility(View.GONE);
                        break;
                    case "House":
                        blank_spinner.setVisibility(View.GONE);
                        car_spinner.setVisibility(View.GONE);
                        house_spinner.setVisibility(View.VISIBLE);
                        yard_spinner.setVisibility(View.GONE);
                        comp_spinner.setVisibility(View.GONE);
                        break;
                    case "Yard":
                        blank_spinner.setVisibility(View.GONE);
                        car_spinner.setVisibility(View.GONE);
                        house_spinner.setVisibility(View.GONE);
                        yard_spinner.setVisibility(View.VISIBLE);
                        comp_spinner.setVisibility(View.GONE);
                        break;
                    case "Computer":
                        blank_spinner.setVisibility(View.GONE);
                        car_spinner.setVisibility(View.GONE);
                        house_spinner.setVisibility(View.GONE);
                        yard_spinner.setVisibility(View.GONE);
                        comp_spinner.setVisibility(View.VISIBLE);
                        break;
                }

        });
    }



}