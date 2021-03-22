package com.example.myapplication.Connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.StrictMode;

import com.example.myapplication.viewModel.MedicamentsViewModel;

public class NetworkConnection {
    private final Context context;
    private final MedicamentsViewModel medicamentSviewModel;

    public NetworkConnection(Context context, MedicamentsViewModel medicamentSviewModel) {
        this.context = context;
        this.medicamentSviewModel = medicamentSviewModel;
    }

    public boolean isConnected() {
        boolean status = false;
        PullData a = new PullData();

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null && cm.getActiveNetwork() != null && cm.getNetworkCapabilities(cm.getActiveNetwork()) != null) {
                // connected to the internet

                //a.send(medicamentSviewModel);

                StrictMode.ThreadPolicy policy = new
                        StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                status = true;
            }
        } else {
            if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting()) {
                // connected to the internet

                // a.send(medicamentSviewModel);

                status = true;
            }
        }


        return status;
    }

}
