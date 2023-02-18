package com.itubsce19008.assignment1_bsce19008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnSetting;
    Button btnCalculate;
    EditText height,weight;
    TextView heightScale,weightScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSetting = findViewById(R.id.settingBtn);
        btnCalculate = findViewById(R.id.btnCalculate);
        height = findViewById(R.id.editHeight);
        weight = findViewById(R.id.editWeight);
        heightScale = findViewById(R.id.textHeightScale);
        weightScale = findViewById(R.id.textWeightScale);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getScale = bundle.getString("Scale", "Metric");
            // rest of your code here
            if(getScale.equals("Metric")){
                Toast.makeText(this, "Scale is metrics", Toast.LENGTH_SHORT).show();
                /* centimeters and kilograms */
                heightScale.setText("centimeters");
                weightScale.setText("kilograms");
            }else {
                Toast.makeText(this, "Scale is emperials", Toast.LENGTH_SHORT).show();
                //inches and pounds
                heightScale.setText("inches");
                weightScale.setText("pounds");
                
            }
        }

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),setting.class);
                startActivity(i);
            }
        });
    }
}