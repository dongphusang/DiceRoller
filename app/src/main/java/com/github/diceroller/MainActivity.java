package com.github.diceroller;

import static android.view.Gravity.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // declaring components
    TextView firstResult;
    TextView secondResult;
    EditText customNumbSides;
    Button rollOnceButton;
    Button rollTwiceButton;
    Button fourSidedDie;
    Button sixSidedDie;
    Button eightSidedDie;
    Button tenSidedDie;
    Button twelveSidedDie;
    Button twentySidedDie;
    Button confirmNumbSides;
    Switch savePreferences;
    DieData dieManager;

    // SharedPreferences keys
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String ENTERED_NUMBS_SIDES = "numbsSides";
    private static final String SWITCH_STATE = "isSave";
    private StringBuffer numbsSides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init components
        firstResult = findViewById(R.id.first_result);
        secondResult = findViewById(R.id.second_result);
        customNumbSides = findViewById(R.id.edit_numb_sides);
        rollOnceButton = findViewById(R.id.roll_once);
        rollTwiceButton = findViewById(R.id.roll_twice);
        fourSidedDie = findViewById(R.id.four_sided_die);
        sixSidedDie = findViewById(R.id.six_sided_die);
        eightSidedDie = findViewById(R.id.eight_sided_die);
        tenSidedDie = findViewById(R.id.ten_sided_die);
        twelveSidedDie = findViewById(R.id.twelve_sided_die);
        twentySidedDie = findViewById(R.id.twenty_sided_die);
        confirmNumbSides = findViewById(R.id.confirm_numb_sides);
        savePreferences = findViewById(R.id.save_preferences);
        dieManager = new DieData();
        numbsSides = new StringBuffer();

        // assign listeners
        rollOnceButton.setOnClickListener(this);
        rollTwiceButton.setOnClickListener(this);
        fourSidedDie.setOnClickListener(this);
        sixSidedDie.setOnClickListener(this);
        eightSidedDie.setOnClickListener(this);
        tenSidedDie.setOnClickListener(this);
        twelveSidedDie.setOnClickListener(this);
        twentySidedDie.setOnClickListener(this);
        confirmNumbSides.setOnClickListener(this);
        savePreferences.setOnClickListener(this);

        loadData();
    }

    @Override
    public void onClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch(view.getId()) {
            
            case R.id.roll_once:
                if (dieManager.getNumberOfSides() == 0)
                    Toast.makeText(this,"Please pick a die",Toast.LENGTH_SHORT).show();
                else {
                    firstResult.setText(""+dieManager.rollDieOnce());
                    secondResult.setText("0");
                }
                break;

            case R.id.roll_twice:
                if (dieManager.getNumberOfSides() == 0)
                    Toast.makeText(this,"Please pick a die",Toast.LENGTH_SHORT).show();
                else {
                    int[]results = dieManager.rollDieTwice();
                    firstResult.setText(""+results[0]);
                    secondResult.setText(""+results[1]);
                }
                break;

            case R.id.four_sided_die:
                dieManager.setNumberOfSides(4);
                // reset results
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Four sided die selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.six_sided_die:
                dieManager.setNumberOfSides(6);
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Six sided die selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.eight_sided_die:
                dieManager.setNumberOfSides(8);
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Eight sided side selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ten_sided_die:
                dieManager.setNumberOfSides(10);
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Ten sided side selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.twelve_sided_die:
                dieManager.setNumberOfSides(12);
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Twelve sided die selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.twenty_sided_die:
                dieManager.setNumberOfSides(20);
                firstResult.setText("0");
                secondResult.setText("0");
                Toast.makeText(this, "Twenty sided die selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.confirm_numb_sides:
                if (customNumbSides.getText().length() == 0)
                    Toast.makeText(this, "Enter number of sides", Toast.LENGTH_SHORT).show();
                else {
                    dieManager.setNumberOfSides(Integer.parseInt(customNumbSides.getText().toString()));
                    numbsSides.append(customNumbSides.getText()+", ");
                    editor.putString(ENTERED_NUMBS_SIDES, numbsSides.toString()); // saving list of numbs sides
                    editor.apply();
                    firstResult.setText("0");
                    secondResult.setText("0");
                    Toast.makeText(this, "A die of "+dieManager.getNumberOfSides()+" sides", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.save_preferences:
                editor.putBoolean(SWITCH_STATE, savePreferences.isChecked());
                editor.apply();
                break;
        }
    }


    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        if (sharedPreferences.getBoolean(SWITCH_STATE, false)) {
            savePreferences.setChecked(true);
            numbsSides = new StringBuffer(sharedPreferences.getString(ENTERED_NUMBS_SIDES,""));
            Toast.makeText(this, sharedPreferences.getString(ENTERED_NUMBS_SIDES, "none"), Toast.LENGTH_SHORT).show();
        }
        else {
            savePreferences.setChecked(false);
            Toast.makeText(this, "None", Toast.LENGTH_SHORT).show();
        }
    }


}