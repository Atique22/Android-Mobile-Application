package com.itubsce19008.assignment1_bsce19008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    TextView heightScale,weightScale,BMI,status;
    String getScale;
    double bmiCalculation;
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
        status = findViewById(R.id.textViewStatus);
        BMI = findViewById(R.id.textViewBMI);

        Bundle bundle = getIntent().getExtras();
        getScale = "Metric"; //default scale set
        if (bundle != null) {
            // rest of your code here
            getScale = bundle.getString("Scale", "Metric");
            if(getScale.equals("Metric")){
                Toast.makeText(this, "Scale is Metrics", Toast.LENGTH_SHORT).show();
                /* centimeters and kilograms */
                heightScale.setText("Centimeters");
                weightScale.setText("Kilograms");
//                [weight (kg) / height (cm) / height (cm)] x 10,000

            }else {
                Toast.makeText(this, "Scale is Imperials", Toast.LENGTH_SHORT).show();
                //inches and pounds
                heightScale.setText("inches");
                weightScale.setText("pounds");
                
            }
        }
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height.getText().toString().trim().length() == 0 || weight.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Please Enter all fields", Toast.LENGTH_SHORT).show();
                }else {
                    double h = Double.parseDouble(height.getText().toString());
                    double w = Double.parseDouble(weight.getText().toString());
                    Log.d("ok +++++++++++++++++", "onClick: get scale" + h + " and w=" + w);
                    if(getScale.equals("Imperial")){
                        if(h>12){
                            Log.d("ok +++++++++++++++++", "onClick:+++++++++++++++++++++++++++" );
                            Toast.makeText(MainActivity.this, "Inches can't be greater than 12 ", Toast.LENGTH_SHORT).show();
                        }else {
                            h = h *12 ;
                            // Calculate the BMI
//                         bmi = (weight / (height * height))*703;
                            bmiCalculation = (w/(h*h))*703;
                            BMI.setText("BMI: "+Math.round(bmiCalculation)+" ");
                        }
                    }else{
                        h = h/100;
                        bmiCalculation = (w/(h*h));
                        BMI.setText("BMI: "+Math.round(bmiCalculation)+" ");
                    }

                    if(!Double.isNaN(bmiCalculation)) {
                        if (bmiCalculation < 18.5) {
                            //Underweight
                            status.setText("Underweight" + "");
                        } else if (bmiCalculation >= 18.5 && bmiCalculation <= 24.9) {
//                     Normal weight = 18.5–24.9
                            status.setText("Normal weight" + "");

                        } else if (bmiCalculation >= 25 && bmiCalculation <= 29.9) {
//                     Overweight = 25–29.9
                            status.setText("Overweight" + "");
                        } else {
//                     Obesity = BMI of 30 or greater
                            status.setText("Obesity" + "");
                        }
                    }
                }
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),setting.class);
                startActivity(i);
            }
        });
    }
}