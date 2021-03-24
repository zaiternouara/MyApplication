package com.example.myapplication.Connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverNetwork extends BroadcastReceiver {
    BroadcastReceiverNetwork(){
        super();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        NetworkConnection  connection = new NetworkConnection(context);
        if(intent != null) {
            boolean status = connection.isConnected();
            if (status == true) {
                Log.d("Network", "Internet is available ");
            } else {
                Log.d("Network", "Internet is not available ");
            }
        }
    }
}
