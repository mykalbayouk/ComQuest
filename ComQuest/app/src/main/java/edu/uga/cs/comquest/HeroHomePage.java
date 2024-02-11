package edu.uga.cs.comquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import java.util.ArrayList;

public class HeroHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_home_page);

        //variables to keep track of specialty
        String[] specialty = {""};

        //complete button
        Button complete = findViewById(R.id.complete_profile);
        complete.setVisibility(View.GONE);

        //instructions, default view is invisible
        TextView instructions = findViewById(R.id.instructions);
        instructions.setVisibility(View.GONE);

        //Checkboxes for the four specialties, default view is GONE
        CheckBox carCheck = findViewById(R.id.check_car);
        carCheck.setVisibility(View.GONE);
        CheckBox houseCheck = findViewById(R.id.check_house);
        houseCheck.setVisibility(View.GONE);
        CheckBox computerCheck = findViewById(R.id.check_computer);
        computerCheck.setVisibility(View.GONE);
        CheckBox yardCheck = findViewById(R.id.check_yard);
        yardCheck.setVisibility(View.GONE);

        //add skills button
        Button addButton = findViewById(R.id.add_skills_button);
        addButton.setVisibility(View.VISIBLE); //default visibility
        addButton.setOnClickListener((view) -> {
            instructions.setVisibility(View.VISIBLE);
            addButton.setVisibility(View.GONE);
            complete.setVisibility(View.VISIBLE);

            carCheck.setVisibility(View.VISIBLE);
            houseCheck.setVisibility(View.VISIBLE);
            computerCheck.setVisibility(View.VISIBLE);
            yardCheck.setVisibility(View.VISIBLE);
        });

        //checkboxes for car specifics
        ArrayList<String> carSpecifics = new ArrayList<String>();
        CheckBox carOil = findViewById(R.id.car_oil);
        carOil.setVisibility(View.GONE);
        CheckBox carWash = findViewById(R.id.car_wash);
        carWash.setVisibility(View.GONE);
        CheckBox carACHeat = findViewById(R.id.car_ac_heat);
        carACHeat.setVisibility(View.GONE);
        CheckBox carEngine = findViewById(R.id.car_engine);
        carEngine.setVisibility(View.GONE);
        //checkboxes for house specifics (pets, ac/heat, clean, appliances)
        ArrayList<String> houseSpecifics = new ArrayList<String>();
        CheckBox housePets = findViewById(R.id.house_pets);
        housePets.setVisibility(View.GONE);
        CheckBox houseClean = findViewById(R.id.house_clean);
        houseClean.setVisibility(View.GONE);
        CheckBox houseAppliances = findViewById(R.id.house_appliances);
        houseAppliances.setVisibility(View.GONE);
        CheckBox houseACHeat = findViewById(R.id.house_ac_heat);
        houseACHeat.setVisibility(View.GONE);
        //checkboxes for computer specifics
        ArrayList<String> computerSpecifics = new ArrayList<String>();
        CheckBox computerRepair = findViewById(R.id.computer_repair);
        computerRepair.setVisibility(View.GONE);
        CheckBox computerBuild = findViewById(R.id.computer_build);
        computerBuild.setVisibility(View.GONE);
        CheckBox computerInstall = findViewById(R.id.computer_install);
        computerInstall.setVisibility(View.GONE);
        //checkboxes for yard specifics (mow lawn, power wash, garden)
        ArrayList<String> yardSpecifics = new ArrayList<String>();
        CheckBox yardWash = findViewById(R.id.yard_wash);
        yardWash.setVisibility(View.GONE);
        CheckBox yardMow = findViewById(R.id.yard_mow);
        yardMow.setVisibility(View.GONE);
        CheckBox yardGarden = findViewById(R.id.yard_garden);
        yardGarden.setVisibility(View.GONE);

        carCheck.setOnClickListener((view) -> {
           if (carCheck.isChecked()) {
               //disable other buttons, assign value
               houseCheck.setEnabled(false);
               computerCheck.setEnabled(false);
               yardCheck.setEnabled(false);

               carOil.setVisibility(View.VISIBLE);
               carWash.setVisibility(View.VISIBLE);
               carACHeat.setVisibility(View.VISIBLE);
               carEngine.setVisibility(View.VISIBLE);

               specialty[0] = "car";
           } else {
               //enable other buttons, reset value
               houseCheck.setEnabled(true);
               computerCheck.setEnabled(true);
               yardCheck.setEnabled(true);

               carOil.setVisibility(View.GONE);
               carWash.setVisibility(View.GONE);
               carACHeat.setVisibility(View.GONE);
               carEngine.setVisibility(View.GONE);

               specialty[0] = "";
           }
        });

        houseCheck.setOnClickListener((view) -> {
            if (houseCheck.isChecked()) {
                //disable other buttons, assign value
                carCheck.setEnabled(false);
                computerCheck.setEnabled(false);
                yardCheck.setEnabled(false);

                houseAppliances.setVisibility(View.VISIBLE);
                houseClean.setVisibility(View.VISIBLE);
                housePets.setVisibility(View.VISIBLE);
                houseACHeat.setVisibility(View.VISIBLE);
                specialty[0] = "house";
            } else {
                //enable other buttons, reset value
                carCheck.setEnabled(true);
                computerCheck.setEnabled(true);
                yardCheck.setEnabled(true);

                houseAppliances.setVisibility(View.GONE);
                houseClean.setVisibility(View.GONE);
                housePets.setVisibility(View.GONE);
                houseACHeat.setVisibility(View.GONE);
                specialty[0] = "";
            }
        });

        computerCheck.setOnClickListener((view) -> {
           if (computerCheck.isChecked()) {
               //disable other buttons, assign value
               carCheck.setEnabled(false);
               houseCheck.setEnabled(false);
               yardCheck.setEnabled(false);

               computerRepair.setVisibility(View.VISIBLE);
               computerBuild.setVisibility(View.VISIBLE);
               computerInstall.setVisibility(View.VISIBLE);
               specialty[0] = "computer";
           } else {
               //enable other buttons, reset value
               carCheck.setEnabled(true);
               houseCheck.setEnabled(true);
               yardCheck.setEnabled(true);

               computerRepair.setVisibility(View.GONE);
               computerBuild.setVisibility(View.GONE);
               computerInstall.setVisibility(View.GONE);
               specialty[0] = "";
           }
        });

        yardCheck.setOnClickListener((view) -> {
            if (yardCheck.isChecked()) {

                //disable other buttons, assign value
                carCheck.setEnabled(false);
                houseCheck.setEnabled(false);
                computerCheck.setEnabled(false);

                yardGarden.setVisibility(View.VISIBLE);
                yardMow.setVisibility(View.VISIBLE);
                yardWash.setVisibility(View.VISIBLE);
                specialty[0] = "yard";
            } else {

                //enable other buttons, reset value
                carCheck.setEnabled(true);
                houseCheck.setEnabled(true);
                computerCheck.setEnabled(true);

                yardGarden.setVisibility(View.GONE);
                yardMow.setVisibility(View.GONE);
                yardWash.setVisibility(View.GONE);
                specialty[0] = "";
            }
        });
        //forming string to write to file
        ArrayList<String> heroProfile = new ArrayList<String>();
        complete.setOnClickListener((view) -> {
            //car
            if (specialty[0].compareTo("car") == 0) {
                if (carEngine.isChecked()) {
                    carSpecifics.add(carEngine.getText().toString());
                }
                if (carOil.isChecked()) {
                    carSpecifics.add(carOil.getText().toString());
                }
                if (carACHeat.isChecked()) {
                    carSpecifics.add(carACHeat.getText().toString());
                }
                if (carWash.isChecked()) {
                    carSpecifics.add(carWash.getText().toString());
                }
                for (int i = 0; i < carSpecifics.size() + 1; i++) {
                    if (i == 0) {
                        heroProfile.add(specialty[0]);
                        heroProfile.add("#GAP#");
                    } else {
                        if (i != carSpecifics.size()) {
                            heroProfile.add(carSpecifics.get(i - 1));
                            heroProfile.add("#GAP#");
                        } else {
                            heroProfile.add(carSpecifics.get(i - 1));
                        }
                    }
                }
            }
            //house
            if (specialty[0].compareTo("house") == 0) {
                if (houseClean.isChecked()) {
                    houseSpecifics.add(houseClean.getText().toString());
                }
                if (housePets.isChecked()) {
                    houseSpecifics.add(housePets.getText().toString());
                }
                if (houseACHeat.isChecked()) {
                    houseSpecifics.add(houseACHeat.getText().toString());
                }
                if (houseAppliances.isChecked()) {
                    houseSpecifics.add(houseAppliances.getText().toString());
                }
                for (int i = 0; i < houseSpecifics.size() + 1; i++) {
                    if (i == 0) {
                        heroProfile.add(specialty[0]);
                        heroProfile.add("#GAP#");
                    } else {

                        if (i != houseSpecifics.size()) {
                            heroProfile.add(houseSpecifics.get(i - 1));
                            heroProfile.add("#GAP#");
                        } else {
                            heroProfile.add(houseSpecifics.get(i - 1));

                        }

                    }
                }
            }
            //computer
            if (specialty[0].compareTo("computer") == 0) {
                if (computerInstall.isChecked()) {
                    computerSpecifics.add(computerInstall.getText().toString());
                }
                if (computerBuild.isChecked()) {
                    computerSpecifics.add(computerBuild.getText().toString());
                }
                if (computerRepair.isChecked()) {
                    computerSpecifics.add(computerRepair.getText().toString());
                }
                for (int i = 0; i < computerSpecifics.size() + 1; i++) {
                    if (i == 0) {
                        heroProfile.add(specialty[0]);
                        heroProfile.add("#GAP#");
                    } else {
                        if (i != computerSpecifics.size()) {
                            heroProfile.add(computerSpecifics.get(i - 1));
                            heroProfile.add("#GAP#");
                        } else {
                            heroProfile.add(computerSpecifics.get(i - 1));
                        }

                    }
                }
            }
            //yard
            if (specialty[0].compareTo("yard") == 0) {
                if (yardMow.isChecked()) {
                    yardSpecifics.add(yardMow.getText().toString());
                }
                if (yardWash.isChecked()) {
                    yardSpecifics.add(yardWash.getText().toString());
                }
                if (yardGarden.isChecked()) {
                    yardSpecifics.add(yardGarden.getText().toString());
                }
                for (int i = 0; i < yardSpecifics.size() + 1; i++) {
                    if (i == 0) {
                        heroProfile.add(specialty[0]);
                        heroProfile.add("#GAP#");
                    } else {

                        if (i != yardSpecifics.size()) {
                            heroProfile.add(yardSpecifics.get(i - 1));
                            heroProfile.add("#GAP#");
                        } else {
                            heroProfile.add(yardSpecifics.get(i - 1));
                        }
                    }
                }
            }

            String profileString = "";
            for (int i = 0; i < heroProfile.size(); i++) {
                profileString += heroProfile.get(i);
            }
            TextView test = findViewById(R.id.test);
            test.setText(profileString);
        });

    }
}