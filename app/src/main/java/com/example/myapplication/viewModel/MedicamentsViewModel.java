package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.example.myapplication.Repository.MedicamentRepository;
import com.example.myapplication.Repository.WebServiceRepository;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class MedicamentsViewModel extends AndroidViewModel {
//SQLITE
    private MedicamentRepository repository;
    private LiveData<List<MEDICAMENTS>> allMedicaments;
    private LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    private LiveData<List<MEDICAMENTS>> allMedicamentsPeremptions;
    private LiveData<List<MEDICAMENTS>> SearchMedicaments;
    public String search;
//WEBSERVICE
    private WebServiceRepository rep;
    private LiveData<List<MEDICAMENTS>> allMedicamentsWS;
    private LiveData<List<MEDICAMENTS>> allMedicamentslaboratoiresWS;
    private LiveData<List<MEDICAMENTS>> SearchMedicamentsWS;






    public MedicamentsViewModel(@NonNull Application application) {
        super(application);
        //SQLITE
        repository = new MedicamentRepository(application);
        allMedicaments = repository.getAllMedicaments();
        allMedicamentslaboratoires = repository.getAllaboratoires();
        allMedicamentsPeremptions = repository.getAllMedicamentsPeremptions();
        SearchMedicaments = repository.getSearchMedicamemts(search);

        //WEBSERVICE
        rep  = new WebServiceRepository(application);
        allMedicamentsWS = rep.getMyList();
        allMedicamentslaboratoiresWS = rep.getMyListLaboratoire();
        SearchMedicamentsWS = rep.getMyListSearch(application ,search);
    }

//SQLITE
    public void insert(MEDICAMENTS medicaments) {

        repository.insert(medicaments);
        rep.AddMedicament(medicaments);

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
        return SearchMedicaments;
    }

//WEBSEVICE
    public LiveData<List<MEDICAMENTS>> getAllMedicamentsWS() {
        return allMedicamentsWS;
    }
    public LiveData<List<MEDICAMENTS>> getAllaboratoiresWS() {
        return allMedicamentslaboratoiresWS;
    }
    public LiveData<List<MEDICAMENTS>> getSearchMedicamentsWS() {
        return SearchMedicamentsWS;
    }
}

