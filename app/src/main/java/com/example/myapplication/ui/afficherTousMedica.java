package com.example.myapplication.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.ui.ajouter.DashboardFragment;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class afficherTousMedica extends AppCompatActivity {
    private MedicamentsViewModel medicamentSviewModel;
  // public static final int ADD_NOTE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_tous_medica);
      /*  Button buttonAddMedoc = findViewById(R.id.ajout);
        buttonAddMedoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(afficherTousMedica.this,DashboardFragment.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });*/

    RecyclerView recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//comment les infos sont afficher
        recyclerView.setHasFixedSize(true);


        final MedicamentAdapter adapter= new MedicamentAdapter(this);
        recyclerView.setAdapter(adapter);


        medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);
        medicamentSviewModel.insert(new MEDICAMENTS(1,"paracetamol","paralgan","bayer","jp","comprimé","3mois","oui","non","23","21/09/2019","21/09/2022","bienn","12euros","89"));
        medicamentSviewModel.getAllMedicaments().observe(this,new Observer<List<MEDICAMENTS>>(){

            @Override
            public void onChanged(List<MEDICAMENTS> medicaments) {
                System.out.println("1");
            adapter.setMedicament(medicaments);
            System.out.println(medicaments);
            }
        });
        }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            int id;
            String nomC = data.getStringExtra(DashboardFragment.EXTRA_NomC);
            String classTH = data.getStringExtra(DashboardFragment.EXTRA_classeTH);
            String labo = data.getStringExtra(DashboardFragment.EXTRA_Labo);
            String description = data.getStringExtra(DashboardFragment.EXTRA_DESCRIPTION);
            String denom = data.getStringExtra(DashboardFragment.EXTRA_Denom);
            String formePH = data.getStringExtra(DashboardFragment.EXTRA_form);
            String dure = data.getStringExtra(DashboardFragment.EXTRA_duree);
            String dateF = data.getStringExtra(DashboardFragment.EXTRA_dateF);
            String dateP = data.getStringExtra(DashboardFragment.EXTRA_dateP);
            String price = data.getStringExtra(DashboardFragment.EXTRA_Price);
            String quant = data.getStringExtra(DashboardFragment.EXTRA_quant);
            String codeB = data.getStringExtra(DashboardFragment.EXTRA_codeB);
            String oui = data.getStringExtra(DashboardFragment.EXTRA_oui);
            String non = data.getStringExtra(DashboardFragment.EXTRA_non);
            String lots = data.getStringExtra(DashboardFragment.EXTRA_lot);

            MEDICAMENTS medicaments = new MEDICAMENTS(4,classTH, nomC, labo,denom,formePH,dure,oui,non,lots,dateF,dateP,description,price,quant);
            medicamentSviewModel.insert(medicaments);
            Toast.makeText(this, "medicament saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "medicament not saved", Toast.LENGTH_SHORT).show();
        }
    }*/
}
