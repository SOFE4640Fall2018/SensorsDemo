package com.example.sofe4640.sensorsdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager,sensorManagerG;
    Sensor sensor,gyro;
    TextView xtextView,ytextView,ztextView,xgtextView,ygtextView,zgtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xtextView = (TextView) findViewById(R.id.xValue);
        ytextView = (TextView) findViewById(R.id.yValue);
        ztextView = (TextView) findViewById(R.id.zValue);

        xgtextView = (TextView) findViewById(R.id.xgValue);
        ygtextView = (TextView) findViewById(R.id.ygValue);
        zgtextView = (TextView) findViewById(R.id.zgValue);



        sensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        sensorManagerG =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyro= sensorManagerG.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this,gyro,sensorManagerG.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor test = event.sensor;
        if(test.getType()==Sensor.TYPE_ACCELEROMETER) {
            xtextView.setText("xValue: " + event.values[0]);
            ytextView.setText("yValue: " + event.values[1]);
            ztextView.setText("zValue: " + event.values[2]);
        }

        if(test.getType()==Sensor.TYPE_GYROSCOPE) {
            xgtextView.setText("xValue: " + event.values[0]);
            ygtextView.setText("yValue: " + event.values[1]);
            zgtextView.setText("zValue: " + event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
