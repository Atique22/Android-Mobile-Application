package com.itubsce19008.lab5_datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    char [] dataArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataArray = new char[20971520]; //20mb
        for( int i=0; i<dataArray.length; i++)
        {
            dataArray[i] = 'a';
        }
        String data = new String(dataArray);

        Button internal, external, cache;
        TextView pathfile;
        pathfile = findViewById(R.id.pathView);
        internal  = findViewById(R.id.buttonInternalStorage);
        external = findViewById(R.id.buttonExternalStorage);
        cache = findViewById(R.id.buttonCacheStorage);

        //internal storage
        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            Toast.makeText(MainActivity.this, "Internal Storage Call Successfully", Toast.LENGTH_SHORT).show();
                            File dir = getFilesDir();
                            File internalFile = new File(dir, "internalFile.txt");
                            FileWriter myfilewrite = new FileWriter(internalFile);
                            for(int i=0; i<10; i++)//for required 200MB
                                myfilewrite.write(data);
                            pathfile.setText("path dir: "+dir);
                            Log.d("*****************", "run: ******************** Internal Storage Call Successfully");
                            myfilewrite.close();
                        }
                        catch(Exception e)
                        {
                            Log.d("*****************", "run: ******************** Internal Storage Failed");
                            pathfile.setText("path dir: null");
//                            Toast.makeText(MainActivity.this, "Internal Storage Call Failed", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }


                    }
                });
                t.start();

            }
        });
//cache storage
        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    File dir = getCacheDir();
                    File fileCache = new File(dir,"myCacheFile.txt");
                    FileWriter fileCacheWrite = new FileWriter(fileCache);
                    for(int i=0; i<5; i++) //for required storage 100MB
                        fileCacheWrite.write(data);
                    pathfile.setText("path dir: "+dir);
                    fileCacheWrite.close();
                    Log.d("*****************", "run: ******************** Cache Call Successfully");

                    Toast.makeText(MainActivity.this, "Cache Call Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    pathfile.setText("path dir: null");
                    Log.d("*****************", "run: ******************** Cache Failed");
                    Toast.makeText(MainActivity.this, "Cache Call Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
//External Storage
        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    File myExternalData = new File(dir, "myExternalFile.txt");
                    FileWriter fileExternalWrite = new FileWriter(myExternalData);
                    String mydata = "Data written successfully";
                    fileExternalWrite.write(mydata);
                    pathfile.setText("path dir: "+dir);
                    fileExternalWrite.close();
                    Log.d("*****************", "run: ******************** External call Successfully");
                    Toast.makeText(MainActivity.this, "External Call Successfully", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    pathfile.setText("path dir: null");
                    Log.d("*****************", "run: ******************** External Failed");
                    Toast.makeText(MainActivity.this, "External Call Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

    }

}