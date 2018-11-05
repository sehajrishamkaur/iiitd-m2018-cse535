package com.example.admin.assignment4_mt18116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button but1,but2,but3,but4,but7,but9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=(Button) findViewById(R.id.but1);
       but1.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent=new Intent(MainActivity.this,AccelerometerActivity.class);
               startActivity(intent);
           }

       });
        but2=(Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,GyroscopeActivity.class);
                startActivity(intent);
            }

        });
        but3=(Button) findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,OrientationActivity.class);
                startActivity(intent);
            }

        });
        but4=(Button) findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,ProximityActivity.class);
                startActivity(i);
            }

        });


        but7=(Button) findViewById(R.id.but7);
        but7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,GPS.class);
                startActivity(i);
            }

        });

        but9=(Button) findViewById(R.id.but9);
        but9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,Shake2.class);
                startActivity(i);
            }

        });



    }
}
