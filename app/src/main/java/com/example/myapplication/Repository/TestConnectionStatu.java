package com.example.myapplication.Repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class TestConnectionStatu {
    public static boolean getConnectionStatus(Context context) {
        boolean a = false ;
        ConnectivityManager mConnectivityManager;
        NetworkInfo mNetworkInfoMobile, mNetworkInfoWifi;

        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        mNetworkInfoMobile = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        mNetworkInfoWifi = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        try {
         if ( mNetworkInfoMobile.isConnected() || mNetworkInfoWifi.isConnected() ) {

            a=true;

        }
        else if ( mNetworkInfoMobile.getState() == NetworkInfo.State.DISCONNECTED
                || mNetworkInfoWifi.getState() == NetworkInfo.State.DISCONNECTED) {

            // notify user you are not online
        }
    } catch (Exception exception) {
        // exception.printStackTrace();
    }
        return false;
    }
}
