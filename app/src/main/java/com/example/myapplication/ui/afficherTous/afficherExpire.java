package com.example.myapplication.ui.afficherTous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class afficherExpire extends Fragment {


    private MedicamentsViewModel medicamentSviewModel;

    public afficherExpire() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_afficher_tous_medoc, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);


        final MedicamentAdapter adapter = new MedicamentAdapter(getContext());
        recyclerView.setAdapter(adapter);

        NetworkConnection network = new NetworkConnection(getContext());
        medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);
        //medicamentSviewModel.insert(new MEDICAMENTS("ju","paralgan","bayer","jp","3mois","oui","23","21/09/2019","21/09/2022","bienn","12euros","89"));
        medicamentSviewModel.getAllPeremptions().observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

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
                if (network.isConnected()){
                    medicamentSviewModel.deleteWS(adapter.getMedicamentAt(viewHolder.getAdapterPosition()));
                }else{
                    medicamentSviewModel.delete(adapter.getMedicamentAt(viewHolder.getAdapterPosition()));
                    Toast.makeText(getContext(), "Medicament deleted", Toast.LENGTH_SHORT).show();

                }}
        }).attachToRecyclerView(recyclerView);
        return root;

    }
}
