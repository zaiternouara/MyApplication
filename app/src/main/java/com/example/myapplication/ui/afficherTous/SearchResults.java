package com.example.myapplication.ui.afficherTous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Repository.TestConnectionStatu;
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

       // if (TestConnectionStatu.getConnectionStatus(getContext()) != true) {
            medicamentSviewModel.getSearchMedicaments(result).observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

                @Override
                public void onChanged(List<MEDICAMENTS> medicaments) {
                    adapter.setMedicament(medicaments);
                }
            });
        /*} else {
            medicamentSviewModel.getSearchMedicamentsWS(result).observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

                @Override
                public void onChanged(List<MEDICAMENTS> medicaments) {
                    adapter.setMedicament(medicaments);
                }
            });
        }*/


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

                String classTH = medicaments.getClasse_Therapeutique();
                String nomC = medicaments.getNom_Commercial();
                String prix = medicaments.getPrix();
                String denom = medicaments.getDenominateur_De_Medicament();
                String lot = medicaments.getLot();
                String forme = medicaments.getForme_Pharmaceutique();
                String dateF = medicaments.getDate_De_Fabrication();
                String dateP = medicaments.getDate_Peremption();
                String duree = medicaments.getDuree_De_Conservation();
                String quant = medicaments.getQuantite_En_Stock();
                String desc = medicaments.getDescription_De_Composant();
                String labo = medicaments.getLaboratoire();
                String codeB = medicaments.getCodeB();


                Bundle i = new Bundle();
                i.putString("classe therapeutique", classTH);
                i.putString("Nom commercial", nomC);
                i.putString("prix", prix);
                i.putString("denominateur", denom);
                i.putString("lot", lot);
                i.putString("duree de conservation", duree);
                i.putString("forme pharmaceutique", forme);
                i.putString("date de fabrication", dateF);
                i.putString("date de peremption", dateP);
                i.putString("quantite de stock", quant);
                i.putString("description", desc);
                i.putString("laboratoire", labo);
                i.putString("code barre", codeB);

                fragment.setArguments(i);
                System.out.println(fragment);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.affichertous
                                , fragment)
                        .addToBackStack(null)
                        .commit();


            }
        });

        return root;
    }


}