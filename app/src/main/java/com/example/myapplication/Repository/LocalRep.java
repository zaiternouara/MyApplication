package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.OperationsSQLite.MEDICAMENTSDataBase;
import com.example.myapplication.OperationsSQLite.MedicamentDAO;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class LocalRep implements GlobaleRepository {
    private final MedicamentDAO medicamentDao;
    private final LiveData<List<MEDICAMENTS>> allMedicaments;
    private final LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    private final LiveData<List<MEDICAMENTS>> allMedicamentsExpire;
    private final LiveData<List<MEDICAMENTS>> SearchMedicaments;
    private final LiveData<List<MEDICAMENTS>> SearchNomC;

    private final LiveData<Integer> count;
    private String search;
    private String searchNomC;
    List<MEDICAMENTS> all;

    public LocalRep(Application application) {
        MEDICAMENTSDataBase database = MEDICAMENTSDataBase.getInstance(application);
        medicamentDao = database.medicamentDao();

        allMedicaments = medicamentDao.getAllMEDICAMENTS();
        allMedicamentslaboratoires = medicamentDao.getAllaboratoires();
        allMedicamentsExpire = medicamentDao.getAllExpire();
        SearchMedicaments = medicamentDao.SearchMedicamemts(search);
        SearchNomC = medicamentDao.SearchNomC(searchNomC);

        count = medicamentDao.getDataCount();


    }

    @Override
    public LiveData<List<MEDICAMENTS>> getSearchNomC(String searchNomC) {
        return null;
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchNomC(Application application, String searchNomC) {
        return null;
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
    public LiveData<List<MEDICAMENTS>> getAllExpire() {
        return allMedicamentsExpire;
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getSearchMedicamemts(String search) {
        return medicamentDao.SearchMedicamemts(search);
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(Application application, String search) {
        return null;
    }



    public LiveData<Integer> getCount() {
        return count;
    }

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
