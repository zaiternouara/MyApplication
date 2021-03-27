package com.example.myapplication.Connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleRegistry;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class BroadcastReceiverNetwork extends BroadcastReceiver {
    LifecycleRegistry lifecycleRegistry;


    public BroadcastReceiverNetwork() {
        super();

    }
     @Override
    public void onReceive(Context context, Intent intent) {
        NetworkConnection connection = new NetworkConnection(context);
        if (intent != null) {
            boolean status = connection.isConnected();
            if (status == true) {
                Toast.makeText(context, "Internet is available ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Internet is not available", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
