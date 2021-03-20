package com.example.myapplication.Connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;

public class NetworkConnection {
    private Context context;

    public NetworkConnection(Context context) {
        this.context = context;
    }
    public boolean isConnected() {
        boolean status = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null && cm.getActiveNetwork() != null && cm.getNetworkCapabilities(cm.getActiveNetwork()) != null) {
                // connected to the internet
                PullData.send();
                status = true;
            }
        } else {
            if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting()) {
                // connected to the internet
                PullData.send();
                status = true;
            }
        }


        return status;
    }

}
