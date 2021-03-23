package com.example.myapplication.viewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.myapplication.Connection.NetworkConnection;
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


    public  boolean pull () {
        boolean done=false;
        LiveData<List<MEDICAMENTS>> all =  getAllMedicamentsChoose() ;
        System.out.println(all.hasObservers());

         /*if (!all.isEmpty()){
             int i ;
             for (i=0 ; i<=all.size();i++){
                 MEDICAMENTS medicaments = new MEDICAMENTS(

                         all.get(i).getClasse_Therapeutique(),
                         all.get(i).getNom_Commercial(),
                         all.get(i).getLaboratoire(),
                         all.get(i).getDenominateur_De_Medicament(),
                         all.get(i).getForme_Pharmaceutique(),
                         all.get(i).getDuree_De_Conservation(),
                         all.get(i).getLot(),
                         all.get(i).getRemboursable(),
                         all.get(i).getDate_De_Fabrication(),
                         all.get(i).getDate_Peremption(),
                         all.get(i).getDescription_De_Composant(),
                         all.get(i).getPrix(),
                         all.get(i).getQuantite_En_Stock(),
                         all.get(i).getCodeB());
                 insertChoose(medicaments);
                 deleteChoose(medicaments);
                 done = true ;
               }

         }*/

         return done;

    }

}

