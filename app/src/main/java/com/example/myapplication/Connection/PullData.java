package com.example.myapplication.Connection;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class PullData {

    private static int size;
    private static MedicamentsViewModel medicamentSviewModel;





    public static void send() {
        size = medicamentSviewModel.count();
        LiveData<List<MEDICAMENTS>> all = medicamentSviewModel.getAllMedicaments();


        if (0 != size) {
            int i;
            for (i = 0; i <= size; i++) {
                MEDICAMENTS medicaments = new MEDICAMENTS(all.getValue().get(i).getClasse_Therapeutique(), all.getValue().get(i).getNom_Commercial(), all.getValue().get(i).getLaboratoire(), all.getValue().get(i).getDenominateur_De_Medicament(), all.getValue().get(i).getForme_Pharmaceutique(), all.getValue().get(i).getDuree_De_Conservation(), all.getValue().get(i).getLot(),all.getValue().get(i).getRemboursable() ,all.getValue().get(i).getDate_De_Fabrication(), all.getValue().get(i).getDate_Peremption(), all.getValue().get(i).getDescription_De_Composant(), all.getValue().get(i).getPrix(), all.getValue().get(i).getQuantite_En_Stock(), all.getValue().get(i).getCodeB());
                medicamentSviewModel.insertWS(medicaments);
                medicamentSviewModel.delete(medicaments);


            }


        }

    }
}


