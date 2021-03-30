package com.example.myapplication.viewModel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.R;
import com.example.myapplication.Repository.LocalRep;
import com.example.myapplication.Repository.WebServiceRep;
import com.example.myapplication.models.MEDICAMENTS;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

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
    public List<MEDICAMENTS> all;
    public LiveData<Integer> count;
    //WEBSERVICE
    public WebServiceRep rep;

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

    }

    public void insertChoose(MEDICAMENTS medicaments) {


        if (network.isConnected()) {

            rep.insert(medicaments);

        } else {
            repository.insert(medicaments);

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

    public LiveData<List<MEDICAMENTS>> getSearchByCodeBareMedicamentsChoose(String search) {

        if (network.isConnected()) {

            return rep.getSearchMedicamemtsByCodeBare(getApplication(), search);
        } else {

            return repository.getSearchMedicamemtsByCodeBare(search);
        }
    }

    public void pull(LifecycleOwner O) {

        allMedicaments.observe(O,
                new Observer<List<MEDICAMENTS>>() {
                    @Override
                    public void onChanged(@Nullable List<MEDICAMENTS> all) {


                        if (!all.isEmpty()) {
                            int i;
                            for (i = 0; i < all.size(); i++) {

                                rep.insert(all.get(i));
                                repository.delete(all.get(i));
                            }
                        }
                    }
                });

    }


}




