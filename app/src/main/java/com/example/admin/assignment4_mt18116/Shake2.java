package com.example.admin.assignment4_mt18116;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Shake2 extends AppCompatActivity implements SensorEventListener {
    float xAccel,yAccel,zAccel;
    float xPreviousAccel,yPreviousAccel,zPreviousAccel;
    boolean firstUpdate=true;
    float shakeThreshold=12.5f;
    boolean shakeInitiated=false;
    Sensor accelerometer;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake2);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        updateAccelParameters(event.values[0],event.values[1],event.values[2]);
        if((!shakeInitiated)&& isAccelerationChanged()){
            shakeInitiated=true;

        }
        else if((shakeInitiated)&& isAccelerationChanged()){
            executeShakeAction();
        }
        else if((shakeInitiated)&& !isAccelerationChanged()){
            shakeInitiated=false;
        }
    }

    private void executeShakeAction() {
        Intent ii=new Intent(this,ShakeActivity123.class);
        ii.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ii);
    }

    private boolean isAccelerationChanged() {
        float deltaX=Math.abs(xPreviousAccel-xAccel);
        float deltaY=Math.abs(yPreviousAccel-yAccel);
        float deltaZ=Math.abs(zPreviousAccel-zAccel);
        return (deltaX>shakeThreshold && deltaY>shakeThreshold) ||(deltaX>shakeThreshold &&deltaZ>shakeThreshold) ||(deltaY>shakeThreshold&&deltaZ>shakeThreshold);
    }
    private void updateAccelParameters(float xNewAccel, float yNewAccel, float zNewAccel) {
        if(firstUpdate){
            xPreviousAccel=xNewAccel;
            yPreviousAccel=yNewAccel;
            zPreviousAccel=zNewAccel;
            firstUpdate=false;
        }
        else{
            xPreviousAccel=xAccel;
            yPreviousAccel=yAccel;
            zPreviousAccel=zAccel;
        }
        xAccel=xNewAccel;
        yAccel=yNewAccel;
        zAccel=zNewAccel;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}


