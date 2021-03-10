package com.example.myapplication.ui.afficherTous;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class afficherTousMedoc extends Fragment {


    private MedicamentsViewModel medicamentSviewModel;

    public afficherTousMedoc() {}

    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_afficher_tous_medoc, container, false);
        RecyclerView recyclerView=root.findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);


        final MedicamentAdapter adapter= new MedicamentAdapter(getContext());
        recyclerView.setAdapter(adapter);


        medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);
        medicamentSviewModel.insert(new MEDICAMENTS(45,"ju","paralgan","bayer","jp","comprimé","3mois","oui","non","23","21/09/2019","21/09/2022","bienn","12euros","89"));
        medicamentSviewModel.getAllMedicaments().observe(getViewLifecycleOwner(),new Observer<List<MEDICAMENTS>>(){

            @Override
            public void onChanged(List<MEDICAMENTS> medicaments) {
                adapter.setMedicament(medicaments);
            }
        });
        return root;

    }
    }
