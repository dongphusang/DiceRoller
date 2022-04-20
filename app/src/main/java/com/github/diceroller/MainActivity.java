package com.github.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // declaring components
    TextView firstResult;
    TextView secondResult;
    Button rollOnceButton;
    Button rollTwiceButton;
    Button fourSidedDie;
    Button sixSidedDie;
    Button eightSidedDie;
    Button tenSidedDie;
    Button twelveSidedDie;
    Button twentySidedDie;
    DieData dieManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init components
        firstResult = findViewById(R.id.first_result);
        secondResult = findViewById(R.id.second_result);
        rollOnceButton = findViewById(R.id.roll_once);
        rollTwiceButton = findViewById(R.id.roll_twice);
        fourSidedDie = findViewById(R.id.four_sided_die);
        sixSidedDie = findViewById(R.id.six_sided_die);
        eightSidedDie = findViewById(R.id.eight_sided_die);
        tenSidedDie = findViewById(R.id.ten_sided_die);
        twelveSidedDie = findViewById(R.id.twelve_sided_die);
        twentySidedDie = findViewById(R.id.twenty_sided_die);
        dieManager = new DieData();

        // assign listeners
        rollOnceButton.setOnClickListener(this);
        rollTwiceButton.setOnClickListener(this);
        fourSidedDie.setOnClickListener(this);
        sixSidedDie.setOnClickListener(this);
        eightSidedDie.setOnClickListener(this);
        tenSidedDie.setOnClickListener(this);
        twelveSidedDie.setOnClickListener(this);
        twentySidedDie.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.roll_once:
                if (dieManager.getNumberOfSides() == 0)
                    Toast.makeText(this,"Choose one damn die",Toast.LENGTH_SHORT).show();
                else {
                    firstResult.setText(""+dieManager.rollDieOnce());
                    secondResult.setText("0");
                }
                break;
            case R.id.roll_twice:
                if (dieManager.getNumberOfSides() == 0)
                    Toast.makeText(this,"Choose one damn die",Toast.LENGTH_SHORT).show();
                else {
                    int[]results = dieManager.rollDieTwice();
                    firstResult.setText(""+results[0]);
                    secondResult.setText(""+results[1]);
                }
                break;
            case R.id.four_sided_die:
                dieManager.setNumberOfSides(4);
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
        }
    }
}