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


    private void saveMedicament(){
        //93dte remborsble m3blich kifh ndirha
        String classeThe = classeTh.getText().toString();
        String nom = nomM.getText().toString();
        String labor = labo.getText().toString();
        String denomi = denom.getText().toString();
        String formPh = form.getText().toString();
        int dureeCon = duree.getValue();
        String dateFa = dateF.getText().toString();
        String datePe = dateP.getText().toString();
        String descrC = descr.getText().toString();
        String loot = lot.getText().toString();
        int pr = prix.getValue();
        int Quantite =  quant .getValue();

        if (classeThe.trim().isEmpty() || nom.trim().isEmpty()|| labor.trim().isEmpty()||denomi.trim().isEmpty()||formPh.trim().isEmpty()|| descrC.trim().isEmpty()||loot.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_classeThe, classeThe);
        data.putExtra(EXTRA_nom , nom );
        data.putExtra(EXTRA_labor, labor);
        data.putExtra(EXTRA_denomi,denomi);
        data.putExtra(EXTRA_formPh, formPh);
        data.putExtra(EXTRA_dureeCon, dureeCon);
        data.putExtra(EXTRA_dateFa, dateFa);
        data.putExtra(EXTRA_datePe,datePe);
        data.putExtra(EXTRA_descrC, descrC);
        data.putExtra(EXTRA_loot, loot);
        data.putExtra(EXTRA_pr,pr);
        data.putExtra(EXTRA_Quantite, Quantite);
        setResult(RESULT_OK, data);
        finish();

    }
//hnaya m3rftch washno R hdik dylo
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(....,
                menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.ajout :
                saveMedicament();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}