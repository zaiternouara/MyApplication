package com.example.myapplication.Connection;

public class PullData {

    private int size;
    //private MedicamentsViewModel medicamentSviewModel;


    /*public void send(MedicamentsViewModel medicamentSviewModel) {

        //medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);


        //List<MEDICAMENTS> all = medicamentSviewModel.getAllMedicaments().getValue();

        medicamentSviewModel.getAllMedicaments().observe(getViewLifecycleOwner(), new Observer<List<MEDICAMENTS>>() {

            @Override
            public void onChanged(List<MEDICAMENTS> medicaments) {
                adapter.setMedicament(medicaments);

            }
        });

        medicamentSviewModel.getCount().observe(getViewLifecycleOwner(), new Observer<Integer>() {

            @Override
            public void onChanged(Integer j) {
                if(j != 0){
                    int i;
                    for (i = 1; i <= j; i++) {
                        MEDICAMENTS medicaments = new MEDICAMENTS(medicamentSviewModel.allMedicaments.getValue().get(i).getClasse_Therapeutique(), medicamentSviewModel.allMedicaments.getValue().get(i).getNom_Commercial(), medicamentSviewModel.allMedicaments.getValue().get(i).getLaboratoire(), medicamentSviewModel.allMedicaments.getValue().
                                get(i).getDenominateur_De_Medicament(), medicamentSviewModel.allMedicaments.getValue().get(i).getForme_Pharmaceutique(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getDuree_De_Conservation(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getLot(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getRemboursable(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getDate_De_Fabrication(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getDate_Peremption(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getDescription_De_Composant(), medicamentSviewModel.allMedicaments.getValue().get(i).getPrix(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getQuantite_En_Stock(),
                                medicamentSviewModel.allMedicaments.getValue().get(i).getCodeB());
                        System.out.println(medicaments);
                        medicamentSviewModel.insertWS(medicaments);
                        medicamentSviewModel.delete(medicaments);


                    }
                }
            }
        });

    }*/


}


