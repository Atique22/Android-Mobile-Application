package com.itubsce19008.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AdView mAdView;

    Button reset,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Boolean turn = false;
    void resetFunction(){
        turn = false;
        b1.setText("-");
        b2.setText("-");
        b3.setText("-");
        b4.setText("-");
        b5.setText("-");
        b6.setText("-");
        b7.setText("-");
        b8.setText("-");
        b9.setText("-");
    }
    void checkCondition()
    {
        if ( (b1.getText().equals("O")&&b2.getText().equals("O")&&b3.getText().equals("O")) ||  (b4.getText().equals("O")&&b5.getText().equals("O")&&b6.getText().equals("O")) ||  (b7.getText().equals("O")&&b8.getText().equals("O")&&b9.getText().equals("O")) || (b1.getText().equals("O")&&b5.getText().equals("O")&&b9.getText().equals("O")) || (b3.getText().equals("O")&&b5.getText().equals("O")&&b7.getText().equals("O"))  || (b1.getText().equals("O")&&b4.getText().equals("O")&&b7.getText().equals("O")) || (b2.getText().equals("O")&&b5.getText().equals("O")&&b8.getText().equals("O")) || (b3.getText().equals("O")&&b6.getText().equals("O")&&b9.getText().equals("O")))
        {
            Toast toast=Toast.makeText(getApplicationContext(),"O Win!",Toast.LENGTH_LONG);
            toast.setMargin(5,5);
            toast.show();
            resetFunction();
        }
        if ( (b1.getText().equals("X")&&b2.getText().equals("X")&&b3.getText().equals("X")) ||  (b4.getText().equals("X")&&b5.getText().equals("X")&&b6.getText().equals("X")) ||  (b7.getText().equals("X")&&b8.getText().equals("X")&&b9.getText().equals("X")) || (b1.getText().equals("X")&&b5.getText().equals("X")&&b9.getText().equals("X")) || (b3.getText().equals("X")&&b5.getText().equals("X")&&b7.getText().equals("X")) || (b1.getText().equals("X")&&b4.getText().equals("X")&&b7.getText().equals("X")) || (b2.getText().equals("X")&&b5.getText().equals("X")&&b8.getText().equals("X")) || (b3.getText().equals("X")&&b6.getText().equals("X")&&b9.getText().equals("X")))
        {
            Toast toast=Toast.makeText(getApplicationContext(),"X Win!",Toast.LENGTH_LONG);
            toast.setMargin(50,50);
            toast.show();
            resetFunction();
        }
        else if  ( !b1.getText().equals("-")&& !b2.getText().equals("-")&& !b3.getText().equals("-") && !b4.getText().equals("-")&& !b5.getText().equals("-")&& !b6.getText().equals("-") && !b7.getText().equals("-")&& !b8.getText().equals("-")&& !b9.getText().equals("-") )
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Draw!",Toast.LENGTH_LONG);
            toast.setMargin(50,50);
            toast.show();
            resetFunction();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here i created my app ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        reset = findViewById(R.id.reset);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);
        b3 = findViewById(R.id.button4);
        b4 = findViewById(R.id.button5);
        b5 = findViewById(R.id.button6);
        b6 = findViewById(R.id.button7);
        b7 = findViewById(R.id.button8);
        b8 = findViewById(R.id.button9);
        b9 = findViewById(R.id.button10);

        View.OnClickListener resetObject = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = false;
                b1.setText("-");
                b2.setText("-");
                b3.setText("-");
                b4.setText("-");
                b5.setText("-");
                b6.setText("-");
                b7.setText("-");
                b8.setText("-");
                b9.setText("-");
            }
        };
        reset.setOnClickListener(resetObject);

         View.OnClickListener btnObject = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((Button)v).getText().equals("-")){
                    if (!turn){
                         ((Button)v).setText("X");

                    }else{
                        ((Button)v).setText("O");
                    }
                    turn = !turn;
                    checkCondition();
                }
            }
        };

        b1.setOnClickListener(btnObject);
        b2.setOnClickListener(btnObject);
        b3.setOnClickListener(btnObject);
        b4.setOnClickListener(btnObject);
        b5.setOnClickListener(btnObject);
        b6.setOnClickListener(btnObject);
        b7.setOnClickListener(btnObject);
        b8.setOnClickListener(btnObject);
        b9.setOnClickListener(btnObject);


    }
}