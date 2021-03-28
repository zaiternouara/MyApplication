package com.example.myapplication.ui.afficherTous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class SearchCodeBareResults extends Fragment {
    private MedicamentsViewModel medicamentSviewModel;

    public SearchCodeBareResults() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search_code_bare_results, container, false);


        RecyclerView recyclerView = root.findViewById(R.id.recycle_view);


        String result = getArguments().getString("result");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);

        final MedicamentAdapter adapter = new MedicamentAdapter(getContext());
        recyclerView.setAdapter(adapter);


        medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);

        medicamentSviewModel.getSearchByCodeBareMedicamentsChoose(result).observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

            @Override
            public void onChanged(List<MEDICAMENTS> medicament) {
                if (medicament.isEmpty()) {

                    showSnackbar();
                } else {
                    adapter.setMedicament(medicament);
                }

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
                medicamentSviewModel.deleteChoose(adapter.getMedicamentAt(viewHolder.getAdapterPosition()));
                suppSnackbar();
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
                String rembou = medicaments.getRemboursable();


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
                i.putString("remboursable", rembou);
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
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.homeFragment
                                , fragment)
                        .addToBackStack(null)
                        .commit();


            }
        });

        return root;
    }

    public void showSnackbar() {

        Snackbar.make(getView(), "Médicament introuvable", Snackbar.LENGTH_LONG)
                .setAction("Dommage ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void suppSnackbar() {

        Snackbar.make(getView(), "Médicament supprimé", Snackbar.LENGTH_LONG)
                .setAction("D'accord", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

}