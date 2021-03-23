//package com.example.myapplication.Connection;

/*import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class PullData {

    private int size;
    private MedicamentsViewModel medicamentSviewModel;


    public void send(MedicamentsViewModel medicamentSviewModel) {

        //medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);


        List<MEDICAMENTS> all = medicamentSviewModel.allMedicaments;

        if (all.size() != 0) {
            int i;
            for (i = 1; i <= all.size(); i++) {
                MEDICAMENTS medicaments = new MEDICAMENTS(

                        all.get(i).getClasse_Therapeutique(),
                        all.get(i).getNom_Commercial(),
                        all.get(i).getLaboratoire(),
                        all.get(i).getDenominateur_De_Medicament(),
                        all.get(i).getForme_Pharmaceutique(),
                        all.get(i).getDuree_De_Conservation(),
                        all.get(i).getLot(),
                        all.get(i).getRemboursable(),
                        all.get(i).getDate_De_Fabrication(),
                        all.get(i).getDate_Peremption(),
                        all.get(i).getDescription_De_Composant(),
                        all.get(i).getPrix(),
                        all.get(i).getQuantite_En_Stock(),
                        all.get(i).getCodeB());
                System.out.println(medicaments);
                medicamentSviewModel.insertChoose(medicaments);
                medicamentSviewModel.deleteChoose(medicaments);


            }
        }


    }


}

*/
