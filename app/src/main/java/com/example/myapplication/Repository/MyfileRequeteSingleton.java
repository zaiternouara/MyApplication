package com.example.myapplication.Repository;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//pour evite a chq fois de fair connection avec le web sevice
public class MyfileRequeteSingleton extends Application {
    private static MyfileRequeteSingleton ourInstance;
    Application application;
    private RequestQueue myRequestQueue;

    private MyfileRequeteSingleton(Application application) {
        this.application = application;

    }

    public static synchronized MyfileRequeteSingleton getInstance(Application application) {
        if (ourInstance == null) {
            ourInstance = new MyfileRequeteSingleton(application);
        }

        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        myRequestQueue = getMyRequestQueue();
    }

    private RequestQueue getMyRequestQueue() {
        if (myRequestQueue == null) {
            myRequestQueue = Volley.newRequestQueue(application.getApplicationContext());

        }
        return myRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getMyRequestQueue().add(req);
    }


}
