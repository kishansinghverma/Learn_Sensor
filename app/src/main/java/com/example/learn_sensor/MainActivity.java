package com.example.learn_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView name, vendor, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.name);
        vendor =findViewById(R.id.vendor);
        data=findViewById(R.id.data);

        SensorManager sensorManager=(SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        String sName=getString(R.string.sensor_name).concat(" "+sensor.getName());
        String sVendor=getString(R.string.sensor_vendor).concat(" "+sensor.getVendor());

        name.setText(sName);
        vendor.setText(sVendor);




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        try{
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];

            data.setText("Time: "+event.timestamp+"    X: "+x+"    Y: "+y+"    Z: "+z);
        }
        catch (Exception e){
            data.setText(e.getMessage());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
