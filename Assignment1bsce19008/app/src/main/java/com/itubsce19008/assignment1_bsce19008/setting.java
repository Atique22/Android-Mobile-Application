package com.itubsce19008.assignment1_bsce19008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends AppCompatActivity {

    Button btnMetric, btnImperial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnImperial = findViewById(R.id.btnImperialScale);
        btnMetric = findViewById(R.id.btnMetricScale);

        btnMetric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* centimeters and kilograms */
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Scale", "Metric");
                startActivity(i);
            }
        });
        btnImperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(getApplicationContext(), MainActivity.class);
//                //inches and pounds
                i.putExtra("Scale", "Imperial");
                startActivity(i);
            }
        });
    }

}