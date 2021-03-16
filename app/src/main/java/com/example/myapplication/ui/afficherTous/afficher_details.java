package com.example.myapplication.ui.afficherTous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.viewModel.MedicamentsViewModel;

public class afficher_details extends Fragment {

    private MedicamentsViewModel medicamentSviewModel;


    public afficher_details() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_afficher_details, container, false);
        TextView classthe = root.findViewById(R.id.text_view_Class);
        TextView nomC = root.findViewById(R.id.text_view_NomC);
        TextView prix = root.findViewById(R.id.text_view_Prix);
        TextView desc = root.findViewById(R.id.text_view_desc);
        TextView dateF = root.findViewById(R.id.text_view_dateF);
        TextView dateP = root.findViewById(R.id.text_view_dateP);
        TextView form = root.findViewById(R.id.text_view_form);
        TextView lot = root.findViewById(R.id.text_view_Lot);
        TextView quant = root.findViewById(R.id.text_view_quant);
        TextView duree = root.findViewById(R.id.textViewDure);
        TextView labo = root.findViewById(R.id.text_view_Labo);


        String classTH = getArguments().getString("classe therapeutique");
        classthe.setText(classTH);

        String nom = getArguments().getString("Nom commercial");
        nomC.setText(nom);

        String price = getArguments().getString("prix");
        prix.setText(price);

        String nlot = getArguments().getString("lot");
        lot.setText(nlot);

        String dure = getArguments().getString("duree de conservation");
        duree.setText(dure);

        String forme = getArguments().getString("forme pharmaceutique");
        form.setText(forme);

        String dateFa = getArguments().getString("date de fabrication");
        dateF.setText(dateFa);

        String datePe = getArguments().getString("date de peremption");
        dateP.setText(datePe);

        String quantite = getArguments().getString("quantite de stock");
        quant.setText(quantite);

        String descri = getArguments().getString("description");
        desc.setText(descri);

        String lab = getArguments().getString("laboratoire");
        labo.setText(lab);


        return root;
    }
}