package com.example.myapplication.OperationsSQLite;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.models.MEDICAMENTS;

@Database( entities = {MEDICAMENTS.class}, version = 2)
public abstract class MEDICAMENTSDataBase extends RoomDatabase {
    private static MEDICAMENTSDataBase instance;

    public abstract MedicamentDAO medicamentDao();

    public static synchronized MEDICAMENTSDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MEDICAMENTSDataBase.class, "MEDICAMENTS_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        return instance;
    }

  private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicamentDAO medicamentDao;

        private PopulateDbAsyncTask(MEDICAMENTSDataBase db) {
            medicamentDao = db.medicamentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            medicamentDao.insert(new MEDICAMENTS("paracetamol","panadol","bayer","pg","comprime","3 mois","oui","23","2019/09/06","2022/09/06","c'est un medoc","67euros"));
            return null;
        }
    }
    private static RoomDatabase.Callback
    sRoomDataBaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


}