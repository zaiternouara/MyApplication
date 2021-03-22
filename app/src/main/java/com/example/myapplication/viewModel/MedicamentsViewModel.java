package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Repository.LocalRep;
import com.example.myapplication.Repository.WebServiceRep;
import com.example.myapplication.models.MEDICAMENTS;

import org.json.JSONException;

import java.util.List;

//import com.example.myapplication.Repository.WebServiceRep;

public class MedicamentsViewModel extends AndroidViewModel {
    public String search;
    public LiveData<List<MEDICAMENTS>> allMedicaments;
    public LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    public LiveData<List<MEDICAMENTS>> allMedicamentsPeremptions;
    public MutableLiveData<List<MEDICAMENTS>> allMedicamentsWS;
    public MutableLiveData<List<MEDICAMENTS>> allMedicamentslaboratoiresWS;
    //SQLITE
    public LocalRep repository;
    public LiveData<List<MEDICAMENTS>> SearchMedicaments;
    //WEBSERVICE
    public WebServiceRep rep;
    public MutableLiveData<List<MEDICAMENTS>> SearchMedicamentsWS;
    int count;

    public MedicamentsViewModel(@NonNull Application application) {
        super(application);
        //SQLITE
        repository = new LocalRep(application);
        allMedicaments = repository.getAllMedicaments();
        allMedicamentslaboratoires = repository.getAllaboratoires();
        allMedicamentsPeremptions = repository.getAllMedicamentsPeremptions();
        //count = repository.getCount();
        //SearchMedicaments = repository.getSearchMedicamemts(search);

        //WEBSERVICE
        rep = new WebServiceRep(application);
        allMedicamentsWS = rep.getAllMedicaments();
        allMedicamentslaboratoiresWS = rep.getAllaboratoires();

        SearchMedicamentsWS = rep.getSearchMedicamemts(search);
    }


    //SQLITE
    public void insert(MEDICAMENTS medicaments) {

        repository.insert(medicaments);
        //  rep.AddMedicament(medicaments);

    }

    public void update(MEDICAMENTS medicaments) {

        repository.update(medicaments);
    }

    public void delete(MEDICAMENTS medicaments) {

        repository.delete(medicaments);
    }

    //WEBSERVICE
    public void insertWS(MEDICAMENTS medicaments) {

        rep.insert(medicaments);

    }

    public void deleteWS(MEDICAMENTS medicaments){

        rep.delete(medicaments);
    }


    //SQLITE
    public LiveData<List<MEDICAMENTS>> getAllMedicaments() {
        return allMedicaments;
    }

    public LiveData<List<MEDICAMENTS>> getAllaboratoires() {
        return allMedicamentslaboratoires;
    }

    public LiveData<List<MEDICAMENTS>> getAllPeremptions() {
        return allMedicamentsPeremptions;
    }

    public LiveData<List<MEDICAMENTS>> getSearchMedicaments(String search) {
        //return repository.getSearchMedicamemts(search);
        return repository.getSearchMedicamemts(search);
    }

    public int count() {
        return count;
    }


    //webService
    public MutableLiveData<List<MEDICAMENTS>> getAllMedicamentsWS() {
        return allMedicamentsWS;
    }

    public MutableLiveData<List<MEDICAMENTS>> getAllaboratoiresWS() {
        return allMedicamentslaboratoiresWS;
    }

    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamentsWS(String search) {
        return rep.getSearchMedicamemts(getApplication(), search);
    }

}

