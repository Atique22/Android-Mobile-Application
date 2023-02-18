package com.itubsce19008.bsce19008_lab2_weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView cityName,cityViewName,gettextViewWindSpeed, gettextViewTemperature,gettextViewVisibility,gettextViewHumidity, gettextViewPressure,gettextViewMinTemperature,gettextViewMaxTemperature;
    Button cityBtn;
    double temperature,minTemperature,maxTemperature,pressure,humidity,speed;
    int visibility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityName = (EditText) findViewById(R.id.editTextCityName);
        cityViewName = (TextView) findViewById(R.id.textViewCity);
        cityBtn = (Button) findViewById(R.id.btnCity);
        gettextViewTemperature = (TextView) findViewById(R.id.textViewTemperature);
        gettextViewPressure = (TextView) findViewById(R.id.textViewPressure);
        gettextViewMinTemperature = (TextView) findViewById(R.id. textViewMinTemperature);
        gettextViewMaxTemperature = (TextView) findViewById(R.id. textViewMaxTemperature);
        gettextViewHumidity = (TextView) findViewById(R.id. textViewHumidity);
        gettextViewVisibility = (TextView) findViewById(R.id. textViewVisibility);
        gettextViewWindSpeed = (TextView) findViewById(R.id. textViewWindSpeed);

        cityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputCityName = cityName.getText().toString();
                cityViewName.setText(inputCityName);
                String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+inputCityName+"&appid=9bf9823ba78966c7e23ca45773ea73b9";
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        char[] data= new char[5000];
                        try {
                            URL u = new URL(urlString);
                            InputStream i = u.openStream();
                            BufferedReader b = new BufferedReader(new InputStreamReader(i));
                            int count = b.read(data);
                            String response = new String(data,0,count);
                            Log.d("+++++++++++++++++++", "run: +++++++++++++"+response);
                            JSONObject obj = new JSONObject(response);
                            JSONObject main = obj.getJSONObject("main");
                            JSONObject wind = obj.getJSONObject("wind");
                             temperature = main.getDouble("temp");
                            temperature = temperature -275.15;
                             minTemperature = main.getDouble("temp_min");
                            minTemperature = minTemperature -275.15;
                             maxTemperature = main.getDouble("temp_max");
                            maxTemperature = maxTemperature -275.15;
                             pressure = main.getDouble("pressure");
                             humidity = main.getDouble("humidity");
                             visibility = obj.getInt("visibility");
                             speed = wind.getInt("speed");



                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    gettextViewTemperature.setText(""+temperature);
                                    gettextViewPressure.setText(""+pressure);
                                    gettextViewMinTemperature.setText(""+minTemperature);
                                    gettextViewMaxTemperature.setText(""+maxTemperature);
                                    gettextViewHumidity.setText(""+humidity);
                                    gettextViewVisibility.setText(""+visibility);
                                    gettextViewWindSpeed.setText(""+speed);
                                }
                            });
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                Thread myThread = new Thread(runnable);
                myThread.start();





            }
        });

    }
}