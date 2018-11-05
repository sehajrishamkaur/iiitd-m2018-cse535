package com.example.admin.assignment4_mt18116;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener{
    private TextView x,y,z;
    private Sensor mySensor;
    private SensorManager SM;
    Button acc_btn;
    static int i=0;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_accelerometer);
       x=(TextView)findViewById(R.id.x);
       y=(TextView)findViewById(R.id.y);
       z=(TextView)findViewById(R.id.z);
        SM=(SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor=SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
        acc_btn=(Button)findViewById(R.id.acc_btn);
       acc_btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               DBHelper dbHelper=new DBHelper(getApplicationContext());
               Calendar c=Calendar.getInstance();
               SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss");
               String datetime=dateFormat.format(c.getTime());
               dbHelper.updatecolAcc(i++ ,x.getText().toString(),y.getText().toString(),z.getText().toString(),datetime);
               Toast.makeText(getApplicationContext(),"SAVED",Toast.LENGTH_SHORT).show();

           }

       });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X-axis: " +event.values[0]);
        y.setText("Y-axis: " +event.values[1]);
        z.setText("Z-axis: " +event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
