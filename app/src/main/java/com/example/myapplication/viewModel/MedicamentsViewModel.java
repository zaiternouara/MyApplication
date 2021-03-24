package com.example.myapplication.viewModel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Repository.LocalRep;
import com.example.myapplication.Repository.WebServiceRep;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//import com.example.myapplication.Repository.WebServiceRep;

public class MedicamentsViewModel extends AndroidViewModel {
    public String search;
    public LiveData<List<MEDICAMENTS>> allMedicaments;
    public LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    public LiveData<List<MEDICAMENTS>> allMedicamentsExpire;
    public MutableLiveData<List<MEDICAMENTS>> allMedicamentsWS;
    public MutableLiveData<List<MEDICAMENTS>> allMedicamentslaboratoiresWS;
    public MutableLiveData<List<MEDICAMENTS>> allMedicamentsExpireWS;
    //SQLITE
    public LocalRep repository;
    public LiveData<List<MEDICAMENTS>> SearchMedicaments;
    public List<MEDICAMENTS> all;
    public LiveData<Integer> count;
    //WEBSERVICE
    public WebServiceRep rep;
    public MutableLiveData<List<MEDICAMENTS>> SearchMedicamentsWS;

    NetworkConnection network = new NetworkConnection(getApplication());

    public MedicamentsViewModel(@NonNull Application application) {
        super(application);
        //SQLITE
        repository = new LocalRep(application);
        allMedicaments = repository.getAllMedicaments();
        allMedicamentslaboratoires = repository.getAllaboratoires();
        allMedicamentsExpire = repository.getAllExpire();

        //SearchMedicaments = repository.getSearchMedicamemts(search);
        count = repository.getCount();
        //WEBSERVICE
        rep = new WebServiceRep(application);
        allMedicamentsWS = rep.getAllMedicaments();
        allMedicamentslaboratoiresWS = rep.getAllaboratoires();
        allMedicamentsExpireWS = rep.getAllExpire();
        SearchMedicamentsWS = rep.getSearchMedicamemts(search);

    }

    public void insertChoose(MEDICAMENTS medicaments) {


        if (network.isConnected()) {

            rep.insert(medicaments);

        } else {
            repository.insert(medicaments);
            Toast.makeText(getApplication(), " Medicament saved ", Toast.LENGTH_SHORT).show();

        }

    }

    public void update(MEDICAMENTS medicaments) {

        repository.update(medicaments);

    }

    public void deleteChoose(MEDICAMENTS medicaments) {

        if (network.isConnected()) {

            rep.delete(medicaments);
        } else {

            repository.delete(medicaments);
            Toast.makeText(getApplication(), " Medicament deleted", Toast.LENGTH_SHORT).show();

        }
    }


    public LiveData<List<MEDICAMENTS>> getAllMedicamentsChoose() {

        if (network.isConnected()) {

            return allMedicamentsWS;

        } else {

            return allMedicaments;
        }
    }

    public LiveData<List<MEDICAMENTS>> getAllaboratoiresChoose() {

        if (network.isConnected()) {

            return allMedicamentslaboratoiresWS;
        } else {

            return allMedicamentslaboratoires;
        }
    }

    public LiveData<List<MEDICAMENTS>> getAllExpireChoose() {


        if (network.isConnected()) {

            return allMedicamentsExpireWS;
        } else {

            return allMedicamentsExpire;
        }
    }

    public LiveData<List<MEDICAMENTS>> getSearchMedicamentsChoose(String search) {

        if (network.isConnected()) {

            return rep.getSearchMedicamemts(getApplication(), search);
        } else {

            return repository.getSearchMedicamemts(search);
        }
    }

    public LiveData<Integer> getCount() {
        return count;
    }


    public void pull (LifecycleOwner k ) {

        allMedicaments.observe(k,
                new Observer<List<MEDICAMENTS>>() {
                    @Override
                    public void onChanged(@Nullable List<MEDICAMENTS> all){
                        System.out.println("slm ->> "+all.isEmpty());
                        System.out.println("slm ->> "+all.size());

                        if (!all.isEmpty()){
                            int i ;
                            for (i=0 ; i<all.size();i++) {

                                rep.insert(all.get(i));
                                repository.delete(all.get(i));
                            }
                        } }
                });



    }


}

