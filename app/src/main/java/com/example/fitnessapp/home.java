package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class home extends AppCompatActivity {

    private Button startButton, stopButton;
    private EditText durationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        durationEditText = findViewById(R.id.durationEditText);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWorkout();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWorkout();
            }
        });
    }

    private void startWorkout() {
        String duration = durationEditText.getText().toString();
        // Başlatma işlemleri burada gerçekleştirilebilir
    }

    private void stopWorkout() {
        // Durdurma işlemleri burada gerçekleştirilebilir
    }
}
