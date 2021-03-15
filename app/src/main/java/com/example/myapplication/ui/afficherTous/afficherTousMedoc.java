package com.example.myapplication.ui.afficherTous;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class afficherTousMedoc extends Fragment  {


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
        //recherche=root.findViewById(R.id.);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);


        final MedicamentAdapter adapter= new MedicamentAdapter(getContext());
        recyclerView.setAdapter(adapter);



        medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);
        //medicamentSviewModel.insert(new MEDICAMENTS("ju","paralgan","bayer","jp","comprimé","3mois","23","21/09/2019","2019/09/06","bienn","12euros","89"));
        medicamentSviewModel.getAllMedicaments().observe(getViewLifecycleOwner(),new Observer<List<MEDICAMENTS>>(){

            @Override
            public void onChanged(List<MEDICAMENTS> medicaments) {
                adapter.setMedicament(medicaments);
            }
        });
        medicamentSviewModel.getAllMedicamentsWS().observe(getViewLifecycleOwner(),new Observer<List<MEDICAMENTS>>(){

            @Override
            public void onChanged(List<MEDICAMENTS> medicaments) {
                adapter.setMedicament(medicaments);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                medicamentSviewModel.delete(adapter.getMedicamentAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getContext(), "Medicament deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(new MedicamentAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(MEDICAMENTS medicaments) {
                Fragment fragment = new afficher_details();

               // String rechercher = recherche.getText().toString();
                //String oui = boui.getText().toString();
                //String non = bnon.getText().toString();
                if (rechercher.trim().isEmpty() ) {

                    Toast.makeText(getContext(), "Entrez le champs", Toast.LENGTH_SHORT).show();

                    return;
                }
                Bundle i = new Bundle();
                i.putString("result", rechercher);


                fragment.setArguments(i);
                System.out.println(fragment);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.afficher
                                , fragment)
                        .commit();
            }
        });
        return root;

    }

}
