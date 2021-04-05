package com.example.myapplication.ui.ajouter;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.CodeBare.CaptureAct;
import com.example.myapplication.CodeBare.IntentIntegratorClass;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {


    public static final int ADD_NOTE_REQUEST = 1;
    final Calendar myCalendar = Calendar.getInstance();
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
    private MedicamentsViewModel medicamentSviewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        logo = root.findViewById(R.id.imageView);
        coordinatorLayout = root.findViewById(R.id.coordinatorLayout);

        textView1 = root.findViewById(R.id.textView);
        classeTh = root.findViewById(R.id.inputClass);
        nomM = root.findViewById(R.id.inputNom);
        labo = root.findViewById(R.id.inputLabo);
        denom = root.findViewById(R.id.inputDenom);
        form = root.findViewById(R.id.inputForm);
        duree = root.findViewById(R.id.inputDuree);
        dateF = root.findViewById(R.id.inputDateF);
        dateP = root.findViewById(R.id.inputDateP);
        descr = root.findViewById(R.id.inputDescr);
        prix = root.findViewById(R.id.inputPrix);
        quant = root.findViewById(R.id.inputQuant);
        codeB = root.findViewById(R.id.inputCode);
        lot = root.findViewById(R.id.inputLot);

        boui = root.findViewById(R.id.inputOui);
        bnon = root.findViewById(R.id.inputNon);

        codeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }

        });
        String[] medoc = new String[]{
                "Forme Phamaceutique",
                "",
                "Comprimé",
                "",
                "Géllule",
                "",
                "Sachet",
                "",
                "Crème",
                "",
                "Gouttes"
        };
        final List<String> medicamentList = new ArrayList<>(Arrays.asList(medoc));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getContext(),android.R.layout.simple_spinner_item,medicamentList){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;            }

    };
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        form.setAdapter(spinnerArrayAdapter);
        form.setOnItemSelectedListener(this);

        DatePickerDialog.OnDateSetListener datefab = new DatePickerDialog.OnDateSetListener() {
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

        ajout = root.findViewById(R.id.ajout);

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
        String forme = form.getSelectedItem().toString();
        String dureee = duree.getText().toString();
        String dateFab = dateF.getText().toString();
        String datePer = dateP.getText().toString();
        String price = prix.getText().toString();
        String quantite = quant.getText().toString();
        String codeBarre = codeB.getText().toString();
        String remboursable = "1";
        if (boui.isChecked()) remboursable = "1";
        else {
            if (bnon.isChecked()) remboursable = "0";
        }

        if (NomCommercial.trim().isEmpty() || description.trim().isEmpty() || classTH.trim().isEmpty() || laboratoire.trim().isEmpty() || lots.trim().isEmpty() || denomination.trim().isEmpty() || forme.trim().isEmpty() || dureee.trim().isEmpty() || dateFab.trim().isEmpty() || datePer.trim().isEmpty() || price.trim().isEmpty() || quantite.trim().isEmpty() || codeBarre.trim().isEmpty()) {

            showSnackbar();
            return;
        }
        medicamentSviewModel = new ViewModelProvider(getActivity()).get(MedicamentsViewModel.class);
        MEDICAMENTS medicaments = new MEDICAMENTS(classTH, NomCommercial, laboratoire, denomination, forme, dureee, remboursable, lots, dateFab, datePer, description, price, quantite, codeBarre);
        medicamentSviewModel.insertChoose(medicaments);
        savedM();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ajout) {
            ajouterM();
            nomM.setText(null);
            classeTh.setText(null);
            descr.setText(null);
            lot.setText(null);
             labo.setText(null);
            denom.setText(null);
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

    private void scanCode() {
        IntentIntegratorClass integrator = new IntentIntegratorClass(getActivity(), this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Le code en cours de scanne");
        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {


            if (result.getContents() != null) {
                Toast.makeText(getContext(), result.getContents(), Toast.LENGTH_LONG).show();

                codeB.setText(result.getContents());


            } else {
                snackIntrouvable();
            }

        } else {
            //super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void snackIntrouvable() {

        Snackbar.make(getView(), "Médicament introuvable", Snackbar.LENGTH_LONG)
                .setAction("Dommage ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void savedM() {

        Snackbar.make(getView(), "Médicament enregistré", Snackbar.LENGTH_LONG)
                .setAction("Génial ! ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }


}

