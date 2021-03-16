package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Repository.MedicamentRepository;
//import com.example.myapplication.Repository.WebServiceRepository;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class MedicamentsViewModel extends AndroidViewModel {
    public String search;
    //SQLITE
    private final MedicamentRepository repository;
    private final LiveData<List<MEDICAMENTS>> allMedicaments;
    private final LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    private final LiveData<List<MEDICAMENTS>> allMedicamentsPeremptions;
    private LiveData<List<MEDICAMENTS>> SearchMedicaments;
    //WEBSERVICE
   /* private final WebServiceRepository rep;
    private final LiveData<List<MEDICAMENTS>> allMedicamentsWS;
    private final LiveData<List<MEDICAMENTS>> allMedicamentslaboratoiresWS;*/
    private LiveData<List<MEDICAMENTS>> SearchMedicamentsWS;


    public MedicamentsViewModel(@NonNull Application application) {
        super(application);
        //SQLITE
        repository = new MedicamentRepository(application);
        allMedicaments = repository.getAllMedicaments();
        allMedicamentslaboratoires = repository.getAllaboratoires();
        allMedicamentsPeremptions = repository.getAllMedicamentsPeremptions();
        //SearchMedicaments = repository.getSearchMedicamemts(search);

        //WEBSERVICE
      /*  rep = new WebServiceRepository(application);
        allMedicamentsWS = rep.getMyList();
        allMedicamentslaboratoiresWS = rep.getMyListLaboratoire();*/
        //SearchMedicamentsWS = rep.getMyListSearch(application ,search);
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

        repository.insert(medicaments);

    }


    //SQLITE
    public void deleteAllMedicaments() {
        repository.deleteAllMedicaments();
    }

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

    //WEBSEVICE
   /* public LiveData<List<MEDICAMENTS>> getAllMedicamentsWS() {
        return allMedicamentsWS;
    }

    public LiveData<List<MEDICAMENTS>> getAllaboratoiresWS() {
        return allMedicamentslaboratoiresWS;
    }

    public LiveData<List<MEDICAMENTS>> getSearchMedicamentsWS(String search) {
        return rep.getMyListSearch(getApplication(), search);
    }*/
}

