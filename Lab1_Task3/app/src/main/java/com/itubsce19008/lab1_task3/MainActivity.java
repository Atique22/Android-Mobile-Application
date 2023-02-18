package com.itubsce19008.lab1_task3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     EditText number1;
     EditText number2;
     TextView result;
     Button calculate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.inputN1);
        number2 = (EditText) findViewById(R.id.inputN2);
        result = (TextView) findViewById(R.id.ansSum);
        calculate = (Button) findViewById(R.id.sumBtn);

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int sum = num1+num2;
                result.setText(Integer.toString(sum));



            }
        });
    }
}