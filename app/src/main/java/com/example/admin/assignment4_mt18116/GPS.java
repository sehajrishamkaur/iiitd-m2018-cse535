package com.example.admin.assignment4_mt18116;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GPS extends AppCompatActivity {
Button loc_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        loc_btn=(Button)findViewById(R.id.loc_btn);
        ActivityCompat.requestPermissions(GPS.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        loc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g=new GPStracker(getApplicationContext());
                Location l=g.getLocation();
                if(l != null){
                    double lat=l.getLatitude();
                    double lon=l.getLongitude();
                    Toast.makeText(getApplicationContext(),"LATITUDE: " +lat+"\n LONGITUDE:" +lon,Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
