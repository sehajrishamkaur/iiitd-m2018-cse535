package com.example.admin.assignment4_mt18116;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckOrientation extends AppCompatActivity {
Button chk1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_orientation);


chk1=(Button)findViewById(R.id.chk1);
 chk1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(CheckOrientation.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                Toast.makeText(getApplicationContext(),"PORTRAIT MODE",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"LANDSCAPE MODE",Toast.LENGTH_SHORT).show();

            }
        }

    });

            }




}
