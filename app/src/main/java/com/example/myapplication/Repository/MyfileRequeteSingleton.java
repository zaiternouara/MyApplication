package com.example.myapplication.Repository;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
//pour evite a chq fois de fair connection avec le web sevice
/*public class MyfileRequeteSingleton {
    Context context;
    private static MyfileRequeteSingleton ourInstance;
    private RequestQueue myRequestQueue;
    public static MyfileRequeteSingleton getInstance(Context context){
        if(ourInstance==null){
            ourInstance= new MyfileRequeteSingleton();
        }
        return ourInstance;}
    private MyfileRequeteSingleton( ){
        this.context=context;
        myRequestQueue=getMyRequestQueue();

    }

    private RequestQueue getMyRequestQueue(){
        if (myRequestQueue==null){
            myRequestQueue= Volley.newRequestQueue(context);

        }
        return myRequestQueue;
    }

    public <T> void addToRequestQueue(Request req){
        getMyRequestQueue().add(req);
    }


}
