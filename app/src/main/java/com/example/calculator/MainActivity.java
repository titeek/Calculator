package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleCalculatorButton = (Button) findViewById(R.id.simpleCalculatorButton);
        simpleCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simpleCalculatorIntent = new Intent(getApplicationContext(), SimpleCalculator.class);
                startActivity(simpleCalculatorIntent);
            }
        });

        Button advancedCalculatorButton = (Button) findViewById(R.id.advancedCalculatorButton);
        advancedCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent advancedCalculatorIntent = new Intent(getApplicationContext(), AdvancedCalculator.class);
                startActivity(advancedCalculatorIntent);
            }
        });

        Button aboutButton = (Button) findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(getApplicationContext(), AboutCalculator.class);
                startActivity(aboutIntent);
            }
        });

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
