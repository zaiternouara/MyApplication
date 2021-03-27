package com.example.myapplication.OperationsSQLite;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.models.MEDICAMENTS;

@Database(entities = {MEDICAMENTS.class}, version = 10, exportSchema = false)
public abstract class MEDICAMENTSDataBase extends RoomDatabase {
    private static MEDICAMENTSDataBase instance;
    private static RoomDatabase.Callback roomCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    super.onCreate(db);
                    new PopulateDbAsyncTask(instance).execute();
                }
            };

    public static synchronized MEDICAMENTSDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (MEDICAMENTSDataBase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        MEDICAMENTSDataBase.class, "MEDICAMENTS_database.db").fallbackToDestructiveMigration()
                        .addCallback(roomCallback).build();
            }
        }
        return instance;
    }

  /*private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };*/


    public abstract MedicamentDAO medicamentDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private final MedicamentDAO medicamentDao;

        private PopulateDbAsyncTask(MEDICAMENTSDataBase db) {
            medicamentDao = db.medicamentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}


