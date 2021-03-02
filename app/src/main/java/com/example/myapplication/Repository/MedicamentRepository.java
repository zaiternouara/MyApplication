package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myapplication.OperationsSQLite.MEDICAMENTSDataBase;
import com.example.myapplication.OperationsSQLite.MedicamentDAO;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class MedicamentRepository {

    private MedicamentDAO medicamentDao;

    private LiveData<List<MEDICAMENTS>> allMedicaments;
    public MedicamentRepository(Application application) {
        MEDICAMENTSDataBase database = MEDICAMENTSDataBase.getInstance(application);
        medicamentDao = database. medicamentDao();
        allMedicaments =  medicamentDao.getAllMEDICAMENTS();
    }
    public void insert(MEDICAMENTS medicament) {
        new InsertMedicamentAsyncTask( medicamentDao).execute(medicament);
    }
    public void update(MEDICAMENTS medicament) {
        new UpdateMedicamentAsyncTask( medicamentDao).execute(medicament);
    }
    public void delete(MEDICAMENTS medicament) {
        new DeleteMedicamentAsyncTask( medicamentDao).execute(medicament);
    }
    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask( medicamentDao).execute();
    }
    public LiveData<List<MEDICAMENTS>> getAllNotes() {
        return allMedicaments;
    }
    private static class InsertMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private MedicamentDAO  medicamentDao;
        private InsertMedicamentAsyncTask(MedicamentDAO  medicamentDao) {
            this.medicamentDao =  medicamentDao;
        }

        @Override
        protected Void doInBackground(MEDICAMENTS... medicaments) {
            medicamentDao.insert(medicaments[0]);
            return null;
        }
    }
    private static class UpdateMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private MedicamentDAO  medicamentDao;
        private UpdateMedicamentAsyncTask(MedicamentDAO  medicamentDao) {
            this.medicamentDao =  medicamentDao;
        }


        @Override
        protected Void doInBackground(MEDICAMENTS... medicaments) {
            medicamentDao.update(medicaments[0]);
            return null;
        }
    }
    private static class DeleteMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private MedicamentDAO medicamentDao;
        private DeleteMedicamentAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }

        @Override
        protected Void doInBackground(@org.jetbrains.annotations.NotNull MEDICAMENTS... medicaments) {
            medicamentDao.delete(medicaments[0]);
            return null;
        }
    }
    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicamentDAO medicamentDao;
        private DeleteAllNotesAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            medicamentDao.deleteAllMEDICAMENTS();
            return null;
        }
    }
}
