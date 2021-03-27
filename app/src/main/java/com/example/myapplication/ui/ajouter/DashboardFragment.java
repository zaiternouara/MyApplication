package com.example.myapplication.ui.ajouter;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DashboardFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {


    public static final int ADD_NOTE_REQUEST = 1;
    private CoordinatorLayout coordinatorLayout;


    private ImageView logo;
    private TextView textView1;
    private EditText classeTh;
    private EditText nomM;
    private EditText labo;
    private EditText denom;
    private Spinner form;
    private EditText duree;
    private EditText lot;
    private EditText dateF;
    private EditText dateP;
    private EditText descr;
    private EditText prix;
    private EditText quant;
    private EditText codeB;
    private RadioButton boui;
    private RadioButton bnon;
    private Button ajout;
    final Calendar myCalendar = Calendar.getInstance();


    private MedicamentsViewModel medicamentSviewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        logo = (ImageView) root.findViewById(R.id.imageView);
        coordinatorLayout = root.findViewById(R.id.coordinatorLayout);

        textView1 = (TextView) root.findViewById(R.id.textView);
        classeTh = (EditText) root.findViewById(R.id.inputClass);
        nomM = (EditText) root.findViewById(R.id.inputNom);
        labo = (EditText) root.findViewById(R.id.inputLabo);
        denom = (EditText) root.findViewById(R.id.inputDenom);
        form = (Spinner) root.findViewById(R.id.inputForm);
        duree = (EditText) root.findViewById(R.id.inputDuree);
        dateF = (EditText) root.findViewById(R.id.inputDateF);
        dateP = (EditText) root.findViewById(R.id.inputDateP);
        descr = (EditText) root.findViewById(R.id.inputDescr);
        prix = (EditText) root.findViewById(R.id.inputPrix);
        quant = (EditText) root.findViewById(R.id.inputQuant);
        codeB = (EditText) root.findViewById(R.id.inputCode);
        lot = (EditText) root.findViewById(R.id.inputLot);

        boui = (RadioButton) root.findViewById(R.id.inputOui);
        bnon = (RadioButton) root.findViewById(R.id.inputNon);
       // String forme = form.getSelectedItem().toString();
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(getContext(),
                R.array.numbers, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        form.setAdapter(adap);
        form.setOnItemSelectedListener(this);
        DatePickerDialog.OnDateSetListener datefab =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelF();
            }
        };
        dateF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), datefab, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        DatePickerDialog.OnDateSetListener dateper = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabelP();
            }
        };
        dateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), dateper, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        ajout = (Button) root.findViewById(R.id.ajout);

        ajout.setOnClickListener(this);

        return root;
    }


    private void updateLabelP() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateP.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabelF() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateF.setText(sdf.format(myCalendar.getTime()));
    }

    public void ajouterM() {

        String NomCommercial = nomM.getText().toString();
        String classTH = classeTh.getText().toString();
        String description = descr.getText().toString();
        String laboratoire = labo.getText().toString();
        String denomination = denom.getText().toString();
        String lots = lot.getText().toString();
        String forme=form.getSelectedItem().toString();
        String dureee = duree.getText().toString();
        String dateFab = dateF.getText().toString();
        String datePer = dateP.getText().toString();
        String price = prix.getText().toString();
        String quantite = quant.getText().toString();
        String codeBarre = codeB.getText().toString();
        String remboursable = "1";
        if (boui.isChecked()) remboursable = "1";
                else {
        if (bnon.isChecked()) remboursable = "0";}

        if (NomCommercial.trim().isEmpty() || description.trim().isEmpty() || classTH.trim().isEmpty() || laboratoire.trim().isEmpty() || lots.trim().isEmpty() || denomination.trim().isEmpty() || forme.trim().isEmpty() || dureee.trim().isEmpty() || dateFab.trim().isEmpty() || datePer.trim().isEmpty() || price.trim().isEmpty() || quantite.trim().isEmpty() || codeBarre.trim().isEmpty()) {

            showSnackbar();
            return;
        }
        medicamentSviewModel = new ViewModelProvider(getActivity()).get(MedicamentsViewModel.class);
        MEDICAMENTS medicaments = new MEDICAMENTS(classTH, NomCommercial, laboratoire, denomination, forme, dureee,  remboursable, lots ,dateFab, datePer, description, price, quantite,codeBarre);
         medicamentSviewModel.insertChoose(medicaments);





    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ajout) {
            ajouterM();
            nomM.setText(null);
            classeTh.setText(null);
            descr.setText(null);
            lot.setText(null);
            // labo.setText(null);
            denom.setText(null);
            //form.setText(null);
            duree.setText(null);
            dateF.setText(null);
            dateP.setText(null);
            prix.setText(null);
            quant.setText(null);
            codeB.setText(null);


        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String formePh = form.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void showSnackbar() {

        Snackbar.make(getView(), "Entrez tous les champs", Snackbar.LENGTH_LONG)
                .setAction("D'accord", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }
}

