package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sm = null;
    EditText txtX = null;
    EditText txtY = null;
    EditText txtZ = null;
    List list;
    float[] value;
    SensorEventListener sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);

        txtX = this.findViewById(R.id.txtX);
        txtY = this.findViewById(R.id.txtY);
        txtZ = this.findViewById(R.id.txtZ);

        sel = new SensorEventListener(){
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
            public void onSensorChanged(SensorEvent event) {
                value = event.values;
//                txtX.setText(Double.toString(Math.round(value[0])));
//                txtY.setText(Double.toString(Math.round(value[1])));
//                txtZ.setText(Double.toString(Math.round(value[2])));
                txtX.setText(": " + value[0]);
                txtY.setText(": " + value[1]);
                txtZ.setText(": " + value[2]);
            }
        };

        sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
    }
}