package com.example.myapplication.Repository;

 import android.app.Application;
 import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//pour evite a chq fois de fair connection avec le web sevice
public class MyfileRequeteSingleton extends Application {
    private static MyfileRequeteSingleton ourInstance;
//    Context context;
    private RequestQueue myRequestQueue;
    Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        myRequestQueue = getMyRequestQueue();
    }

    private MyfileRequeteSingleton(Application application) {
        this.application = application;

    }

    public static synchronized  MyfileRequeteSingleton getInstance(Application application) {
        if (ourInstance == null) {
            ourInstance = new MyfileRequeteSingleton(application);
        }

        return ourInstance;
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
