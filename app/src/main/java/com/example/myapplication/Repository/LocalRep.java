package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.OperationsSQLite.MEDICAMENTSDataBase;
import com.example.myapplication.OperationsSQLite.MedicamentDAO;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class LocalRep implements GlobaleRepository {
    private MedicamentDAO medicamentDao;
    private LiveData<List<MEDICAMENTS>> allMedicaments;
    private LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    private LiveData<List<MEDICAMENTS>> AllMedicamentsPeremptions;
    private LiveData<List<MEDICAMENTS>> SearchMedicaments;
    private int count ;
    private String search;

    public LocalRep(Application application) {
        MEDICAMENTSDataBase database = MEDICAMENTSDataBase.getInstance(application);
        medicamentDao = database.medicamentDao();

        allMedicaments = medicamentDao.getAllMEDICAMENTS();
        allMedicamentslaboratoires = medicamentDao.getAllaboratoires();
        AllMedicamentsPeremptions = medicamentDao.getAllPeremptioN();
        SearchMedicaments = medicamentDao.SearchMedicamemts(search);
        //count = medicamentDao.getDataCount();

    }

    @Override
    public void insert(MEDICAMENTS medicament) {
        new LocalRep.InsertMedicamentAsyncTask(medicamentDao).execute(medicament);
    }

    @Override
    public void update(MEDICAMENTS medicament) {
        new LocalRep.UpdateMedicamentAsyncTask(medicamentDao).execute(medicament);
    }

    @Override
    public void delete(MEDICAMENTS medicament) {
        new LocalRep.DeleteMedicamentAsyncTask(medicamentDao).execute(medicament);
    }

    @Override
    public void deleteAllMedicaments() {


        new LocalRep.DeleteAllMedicamentsAsyncTask(medicamentDao).execute();
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getAllMedicaments() {
        return allMedicaments;
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getAllaboratoires() {
        return allMedicamentslaboratoires;
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getSearchMedicamemts(String search) {
        return medicamentDao.SearchMedicamemts(search);
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(Application application, String search) {
        return null;
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getAllMedicamentsPeremptions() {
        return AllMedicamentsPeremptions;
    }

    /*public int  getCount() {
        return medicamentDao.getDataCount();
    }*/

    private static class InsertMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private final MedicamentDAO medicamentDao;

        private InsertMedicamentAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }

        @Override
        protected Void doInBackground(MEDICAMENTS... medicaments) {
            medicamentDao.insert(medicaments[0]);
            return null;
        }
    }

    private static class UpdateMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private final MedicamentDAO medicamentDao;

        private UpdateMedicamentAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }


        @Override
        protected Void doInBackground(MEDICAMENTS... medicaments) {
            medicamentDao.update(medicaments[0]);
            return null;
        }
    }

    private static class DeleteMedicamentAsyncTask extends AsyncTask<MEDICAMENTS, Void, Void> {
        private final MedicamentDAO medicamentDao;

        private DeleteMedicamentAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }

        @Override
        protected Void doInBackground(@org.jetbrains.annotations.NotNull MEDICAMENTS... medicaments) {
            medicamentDao.delete(medicaments[0]);
            return null;
        }
    }

    private static class DeleteAllMedicamentsAsyncTask extends AsyncTask<Void, Void, Void> {
        private final MedicamentDAO medicamentDao;

        private DeleteAllMedicamentsAsyncTask(MedicamentDAO medicamentDao) {
            this.medicamentDao = medicamentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            medicamentDao.deleteAllMEDICAMENTS();
            return null;
        }
    }
}
