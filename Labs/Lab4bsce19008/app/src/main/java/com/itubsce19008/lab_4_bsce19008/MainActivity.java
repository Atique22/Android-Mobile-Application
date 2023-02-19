package com.itubsce19008.lab_4_bsce19008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText typeMessage;
    ImageButton resetButton, sendButton;
    FileOutputStream myFileOutput;
    FileInputStream myFileInput;
//    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeMessage = findViewById(R.id.editMessage);
        resetButton = findViewById(R.id.resetBtn);
        sendButton = findViewById(R.id.sendBtn);


//        pref = getSharedPreferences("myDataSave", MODE_PRIVATE);
//        String myData = pref.getString("dataGet", "Data is empty");
//        typeMessage.setText(myData);
        Log.d("+++++++++++++++++++++++++++", "onCreate: oncreate call++++++++++++++++++++++++++++++++");
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "here message send: "+typeMessage.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeMessage.setText(" ");
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("+++++++++++++++++++++++++++", "onCreate: onresume call++++++++++++++++++++++++++++++++");
        // When the app resumes, load the saved text from Shared Preferences and show it in the message box.
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("dataGet", typeMessage.getText().toString() );
//        editor.commit();
//        Toast.makeText(this, "onResume call!", Toast.LENGTH_SHORT).show();

        //        : Implement Message Handling using Internal Storage: read
        try {
            myFileInput = openFileInput("lab4FileBsce19008.txt");
            BufferedReader readData = new BufferedReader(new InputStreamReader(myFileInput));
            String myTextFile = readData.readLine();
            typeMessage.setText(myTextFile);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //        : Implement Message Handling using Internal Storage: write

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause call!", Toast.LENGTH_SHORT).show();
        Log.d("+++++++++++++++++++++++++++", " onPause call++++++++++++++++++++++++++++++++"+typeMessage.getText().toString());
        try {
            myFileOutput = openFileOutput("lab4FileBsce19008.txt",MODE_PRIVATE);
            myFileOutput.write(typeMessage.getText().toString().getBytes());
            myFileOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //        : Destroy working:
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy call!", Toast.LENGTH_SHORT).show();
        Log.d("+++++++++++++++++++++++++++", " ON DESTROY call++++++++++++++++++++++++++++++++");
    }

}