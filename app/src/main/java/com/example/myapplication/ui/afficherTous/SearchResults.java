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


public class SearchResults extends Fragment {

    private MedicamentsViewModel medicamentSviewModel;

    public SearchResults() {
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_search_results, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycle_view);


        String result = getArguments().getString("result");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);


        final MedicamentAdapter adapter = new MedicamentAdapter(getContext());
        recyclerView.setAdapter(adapter);


        medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);

        NetworkConnection network = new NetworkConnection(getContext());

        // Check network connection
        if (network.isConnected()){
            Toast.makeText(getContext(), "Network connection is available", Toast.LENGTH_SHORT).show();
            medicamentSviewModel.getSearchMedicamentsWS(result).observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

                @Override
                public void onChanged(List<MEDICAMENTS> medicaments) {
                    adapter.setMedicament(medicaments);
                }
            });
        }else{
            Toast.makeText(getContext(), "Network connection is not available", Toast.LENGTH_SHORT).show();
            medicamentSviewModel.getSearchMedicaments(result).observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

                @Override
                public void onChanged(List<MEDICAMENTS> medicaments) {
                    adapter.setMedicament(medicaments);
                }
            });
        }



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