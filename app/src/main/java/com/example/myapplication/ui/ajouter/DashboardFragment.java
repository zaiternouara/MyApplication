package com.example.myapplication.ui.ajouter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

import static android.app.Activity.RESULT_OK;

public class DashboardFragment extends Fragment {
    public static final String EXTRA_classeThe =
            "com.example.myapplication.ui.ajouter.EXTRA_classeThe";
    public static final String EXTRA_nom =
            "com.example.myapplication.ui.ajouter.EXTRA_nom";
    public static final String EXTRA_labor =
            "com.example.myapplication.ui.ajouter.EXTRA_labor";
    public static final String EXTRA_denomi =
            "com.example.myapplication.ui.ajouter.EXTRA_denomi";
    public static final String EXTRA_formPh =
            "com.example.myapplication.ui.ajouter.EXTRA_formPh";
    public static final String EXTRA_dureeCon =
            "com.example.myapplication.ui.ajouter.EXTRA_dureeCon";
    public static final String EXTRA_dateFa =
            "com.example.myapplication.ui.ajouter.EXTRA_dateFa";
    public static final String EXTRA_datePe =
            "com.example.myapplication.ui.ajouter.EXTRA_datePe";
    public static final String EXTRA_descrC =
            "com.example.myapplication.ui.ajouter.EXTRA_descrC";
    public static final String EXTRA_loot =
            "com.example.myapplication.ui.ajouter.EXTRA_loot";
    public static final String EXTRA_pr =
            "com.example.myapplication.ui.ajouter.EXTRA_pr";
    public static final String EXTRA_Quantite =
            "com.example.myapplication.ui.ajouter.EXTRA_Quantite";
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
    private RadioGroup rembou;
    private TextView  quest;
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
        lot = (TextView) root.findViewById(R.id.inputLot);
        codeB = (TextView) root.findViewById(R.id.inputCode);
        quest = (TextView) root.findViewById(R.id.question);
        rembou = (RadioGroup) root.findViewById(R.id.inputRembou);
        boui = (RadioButton) root.findViewById(R.id.inputOui);
        bnon = (RadioButton) root.findViewById(R.id.inputNon);
        ajout=(Button) root.findViewById(R.id.ajout);





        /*dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }


    private int Remborsable;





}