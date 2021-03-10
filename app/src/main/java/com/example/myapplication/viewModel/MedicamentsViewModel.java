package com.example.myapplication.viewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;
import com.example.myapplication.Repository.MedicamentRepository;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

public class MedicamentsViewModel extends AndroidViewModel {

    private MedicamentRepository repository;
    private LiveData<List<MEDICAMENTS>> allMedicaments;
    private LiveData<List<MEDICAMENTS>> allMedicamentslaboratoires;
    private LiveData<List<MEDICAMENTS>> allMedicamentsPeremptions;


    public MedicamentsViewModel(@NonNull Application application) {
        super(application);
        repository = new MedicamentRepository(application);
        allMedicaments = repository.getAllMedicaments();
        allMedicamentslaboratoires= repository.getAllaboratoires();
        allMedicamentsPeremptions= repository.getAllMedicamentsPeremptions();


    }


        public void insert(MEDICAMENTS medicaments) {

        repository.insert(medicaments);
        }


        public void update(MEDICAMENTS medicaments) {

        repository.update(medicaments);
        }

        public void delete(MEDICAMENTS medicaments) {

        repository.delete(medicaments);
        }

        public void deleteAllMedicaments() {
            repository.deleteAllMedicaments();
        }

        public LiveData<List<MEDICAMENTS>> getAllMedicaments() {
            return allMedicaments;
        }
        public LiveData<List<MEDICAMENTS>> getAllaboratoires() { return allMedicamentslaboratoires; }
        public LiveData<List<MEDICAMENTS>> getAllPeremptions() { return allMedicamentsPeremptions; }
    }

