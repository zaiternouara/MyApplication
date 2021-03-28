package com.example.myapplication.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public interface GlobaleRepository {
    void insert(MEDICAMENTS medicament);

    void update(MEDICAMENTS medicament);

    void delete(MEDICAMENTS medicament);

    void deleteAllMedicaments();

    LiveData<List<MEDICAMENTS>> getAllMedicaments();

    LiveData<List<MEDICAMENTS>> getAllaboratoires();

    LiveData<List<MEDICAMENTS>> getAllExpire();

    LiveData<List<MEDICAMENTS>> getSearchMedicamemts(String search);

    LiveData<List<MEDICAMENTS>> getSearchMedicamemtsByCodeBare(String search);


    MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(Application application, String search);

    MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemtsByCodeBare(Application application, String search);
}
