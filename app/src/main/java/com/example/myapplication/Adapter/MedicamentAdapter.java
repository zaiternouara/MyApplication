package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.myapplication.R;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.MEDICAMENTS;

import java.util.ArrayList;
import androidx.annotation.NonNull;

import java.util.List;

public class MedicamentAdapter extends RecyclerView.Adapter<MedicamentAdapter.medicamentHolder> {
   private List<MEDICAMENTS> medicament=new ArrayList<>();
   Context context;

    public MedicamentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public medicamentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//creation de viewholder
        View itemView=LayoutInflater.from(context)//liaison java et xml (inflater)
                .inflate(R.layout.medicament_item,parent, false);
        return new medicamentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull medicamentHolder holder, int position) {//liaison entre l'object viewholder et l'élément qui va être afficher dans la liste , la position est la pos d'element de la liste
     MEDICAMENTS currentMedoc = medicament.get(position);
     holder.nomCom.setText(currentMedoc.getNom_Commercial());
     holder.classTH.setText(currentMedoc.getClasse_Therapeutique());
     holder.price.setText(currentMedoc.getPrix());

    }

    @Override
    public int getItemCount() {//retourner la taille de la liste des medicaments
        if(medicament!=null){
        return medicament.size();
    } else
    return 0;
    }
    public void setMedicament(List<MEDICAMENTS> medicament){
        this.medicament=medicament;
        notifyDataSetChanged();
    }
    public MEDICAMENTS getMedicamentAt(int position) {
        return medicament.get(position);
    }


    class medicamentHolder extends RecyclerView.ViewHolder{//liaison entre interface graphique et code JAVA
        private TextView nomCom;
        private TextView classTH;
        private TextView price;

        public medicamentHolder(@NonNull View itemView) {
            super(itemView);
            nomCom = itemView.findViewById(R.id.text_view_NomC);
            classTH = itemView.findViewById(R.id.text_view_Class);
            price = itemView.findViewById(R.id.text_view_Prix);

        }
    }


}
