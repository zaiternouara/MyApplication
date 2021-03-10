package com.example.myapplication.ui.ajouter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.ui.ajouter.DashboardFragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import static android.app.Activity.RESULT_OK;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    public static final String EXTRA_NomC =
            "com.example.myapplication.ui.ajouter.EXTRA_NomC";
    public static final String EXTRA_classeTH =
            "com.example.myapplication.ui.ajouter.EXTRA_classeTH";
    public static final String EXTRA_DESCRIPTION =
            "com.codinginflow.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_Labo =
            "com.example.myapplication.ui.ajouter.EXTRA_Labo";
    public static final String EXTRA_Denom =
            "com.example.myapplication.ui.ajouter.EXTRA_Denom";
    public static final String EXTRA_form =
            "com.example.myapplication.ui.ajouter.EXTRA_form";
    public static final String EXTRA_duree =
            "com.example.myapplication.ui.ajouter.EXTRA_duree";
    public static final String EXTRA_dateF =
            "com.example.myapplication.ui.ajouter.EXTRA_dateF";
    public static final String EXTRA_dateP =
            "com.example.myapplication.ui.ajouter.EXTRA_dateP";
    public static final String EXTRA_Price =
            "com.codinginflow.architectureexample.EXTRA_Price";
    public static final String EXTRA_quant =
            "com.example.myapplication.ui.ajouter.EXTRA_quant";
    public static final String EXTRA_codeB =
            "com.example.myapplication.ui.ajouter.EXTRA_codeB";
    public static final String EXTRA_oui =
            "com.example.myapplication.ui.ajouter.EXTRA_oui";
    public static final String EXTRA_non =
            "com.example.myapplication.ui.ajouter.EXTRA_non";
    public static final String EXTRA_lot =
            "com.example.myapplication.ui.ajouter.EXTRA_lot";
    public static final int ADD_NOTE_REQUEST = 1;
    private MedicamentsViewModel medicamentSviewModel;
    // public static final int ADD_NOTE_REQUEST = 1;
    private ImageView logo;
    private TextView textView1;
    private  TextView classeTh;
    private TextView  nomM;
    private TextView  labo;
    private TextView  denom;
    private TextView  form;
    private TextView  duree;
    private TextView  lot;
    private TextView  dateF;
    private TextView  dateP;
    private TextView  descr;
    private TextView  prix;
    private TextView  quant;
    private TextView  codeB;
    private RadioButton boui;
    private RadioButton bnon;
    private Button ajout;


    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        logo=(ImageView) root.findViewById(R.id.imageView);

        textView1=(TextView) root.findViewById(R.id.textView);
        classeTh = (TextView) root.findViewById(R.id.inputClass);
        nomM = (TextView) root.findViewById(R.id.inputNom);
        labo = (TextView) root.findViewById(R.id.inputLabo);
        denom = (TextView) root.findViewById(R.id.inputDenom);
        form = (TextView) root.findViewById(R.id.inputForm);
        duree = (TextView) root.findViewById(R.id.inputDuree);
        dateF = (TextView) root.findViewById(R.id.inputDateF);
        dateP = (TextView) root.findViewById(R.id.inputDateP);
        descr = (TextView) root.findViewById(R.id.inputDescr);
        prix = (TextView) root.findViewById(R.id.inputPrix);
        quant = (TextView) root.findViewById(R.id.inputQuant);
        codeB = (TextView) root.findViewById(R.id.inputCode);

        boui = (RadioButton) root.findViewById(R.id.inputOui);
        bnon = (RadioButton) root.findViewById(R.id.inputNon);
        lot= (TextView) root.findViewById(R.id.inputLot);
        ajout=(Button)root.findViewById(R.id.ajout);
    ajout.setOnClickListener(this);






        /*dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
    private void ajouterM(){

        String NomCommercial = nomM.getText().toString();
        String classTH = classeTh.getText().toString();
        String description = descr.getText().toString();
        String laboratoire = labo.getText().toString();
        String denomination = denom.getText().toString();
        String lots = lot.getText().toString();
        String formePharmaceutique = form.getText().toString();
        String dureee = duree.getText().toString();
        String dateFab = dateF.getText().toString();
        String datePer = dateP.getText().toString();
        String price = prix.getText();
        String quantite = quant.getText().toString();
        String codeBarre = codeB.getText().toString();
        String oui = boui.getText().toString();
        String non = bnon.getText().toString();
        if (NomCommercial.trim().isEmpty() || description.trim().isEmpty()|| classTH.trim().isEmpty()|| laboratoire.trim().isEmpty()|| lots.trim().isEmpty()|| denomination.trim().isEmpty()|| formePharmaceutique.trim().isEmpty()|| dureee.trim().isEmpty()|| dateFab.trim().isEmpty()|| datePer.trim().isEmpty()|| price.trim().isEmpty()|| quantite.trim().isEmpty()|| codeBarre.trim().isEmpty()|| oui.trim().isEmpty()|| non.trim().isEmpty()) {
            Toast.makeText(getContext(), "Entrez tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }
        /*Intent data = new Intent();

        data.getStringExtra(EXTRA_NomC);
        String classTH = data.getStringExtra(EXTRA_classeTH);
        String labo = data.getStringExtra(EXTRA_Labo);
        String description = data.getStringExtra(EXTRA_DESCRIPTION);
        String denom = data.getStringExtra(EXTRA_Denom);
        String formePH = data.getStringExtra(EXTRA_form);
        String dure = data.getStringExtra(EXTRA_duree);
        String dateF = data.getStringExtra(EXTRA_dateF);
        String dateP = data.getStringExtra(EXTRA_dateP);
        String price = data.getStringExtra(EXTRA_Price);
        String quant = data.getStringExtra(EXTRA_quant);
        String codeB = data.getStringExtra(EXTRA_codeB);
        String oui = data.getStringExtra(EXTRA_oui);
        String non = data.getStringExtra(EXTRA_non);
        String lots = data.getStringExtra(EXTRA_lot);*/


        MEDICAMENTS medicaments = new MEDICAMENTS(classTH, NomCommercial, laboratoire,denomination,formePharmaceutique ,dureee,oui,non,lots,dateFab,datePer ,description,price,quantite);
        medicamentSviewModel.insert(medicaments);
    } /*else {
        Toast.makeText(this, "medicament not saved", Toast.LENGTH_SHORT).show();
    }

        /*getActivity().setResult(RESULT_OK, data);
        getActivity().finish();
        medicamentSviewModel.insert(data);
    }*/


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ajout){
            ajouterM();
        }
    }
}