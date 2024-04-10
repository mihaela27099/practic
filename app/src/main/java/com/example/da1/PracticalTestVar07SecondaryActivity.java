package com.example.da1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTestVar07SecondaryActivity extends AppCompatActivity {

    Button productt, summ;

    TextView displaySum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_var07_secondary);

        displaySum = findViewById(R.id.summ);

        productt = findViewById(R.id.productt);
        summ = findViewById(R.id.summ);

        Intent intent = getIntent();
        int sum = intent.getIntExtra(Constants.SUM, 0);
        int prod = intent.getIntExtra(Constants.PRODUCT, 0);

        displaySum.setText(String.valueOf(sum));

        summ.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra(Constants.SUM, sum );
            setResult(RESULT_OK, result);
            finish();
        });

        productt.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra(Constants.PRODUCT, prod );
            setResult(RESULT_OK, result);
            finish();
        });
    }
}