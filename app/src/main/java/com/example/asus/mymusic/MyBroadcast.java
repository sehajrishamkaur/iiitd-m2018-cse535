package com.example.asus.mymusic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import static android.content.Intent.URI_INTENT_SCHEME;

public class MyBroadcast extends BroadcastReceiver {

    public void onReceive(Context context , Intent intent) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "-" + intent.getAction() + "\n" );
        //stringBuilder.append( "URI: " +intent.toUri( Intent.URI_INTENT_SCHEME ).toString() + "\n" );
        String log = stringBuilder.toString();
        Toast.makeText( context, log, Toast.LENGTH_SHORT ).show();
    }

       /* String action = intent.getAction();

        if(action.equals(Intent.ACTION_POWER_CONNECTED)) {
            context.startService( intent );
            Toast.makeText( context,"Power Connected",Toast.LENGTH_SHORT );

        }
        if(action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            context.startService( intent );
            Toast.makeText( context,"Boot Completed",Toast.LENGTH_SHORT );

        }
         if(action.equals( Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            context.startService( intent );
            Toast.makeText( context,"Airplane Mode On",Toast.LENGTH_SHORT );

        }
    }*/
}