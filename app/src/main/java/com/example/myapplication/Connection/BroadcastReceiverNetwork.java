package com.example.myapplication.Connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverNetwork extends BroadcastReceiver {
    public BroadcastReceiverNetwork(){
        super();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        NetworkConnection  connection = new NetworkConnection(context);
        if(intent != null) {
            boolean status = connection.isConnected();
            if (status == true) {
                 Toast.makeText(context, "Internet is available ", Toast.LENGTH_SHORT).show();
            } else {
                 Toast.makeText(context, "Internet is not available", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
