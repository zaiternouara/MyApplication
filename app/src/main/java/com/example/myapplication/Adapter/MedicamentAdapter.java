package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;

import java.util.ArrayList;
import java.util.List;

public class MedicamentAdapter extends RecyclerView.Adapter<MedicamentAdapter.medicamentHolder> {
    Context context;
    private List<MEDICAMENTS> medicament = new ArrayList<>();
    private OnItemClickListener listener;

    public MedicamentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public medicamentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//creation de viewholder
        View itemView = LayoutInflater.from(context)//liaison java et xml (inflater)
                .inflate(R.layout.medicament_item, parent, false);
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
        if (medicament != null) {
            return medicament.size();
        } else
            return 0;
    }

    public void setMedicament(List<MEDICAMENTS> medicament) {
        this.medicament = medicament;
        notifyDataSetChanged();
    }

    public MEDICAMENTS getMedicamentAt(int position) {
        return medicament.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClick(MEDICAMENTS medicaments);
    }

    public class medicamentHolder extends RecyclerView.ViewHolder {//liaison entre interface graphique et code JAVA
        private final TextView nomCom;
        private final TextView classTH;
        private final TextView price;
       /* private TextView lot;
        private TextView denom;
        private TextView duree;
        private TextView desc;
        private TextView dateF;
        private TextView dateP;
        private TextView form;
        private TextView codeB;
        private TextView quant;*/

        public medicamentHolder(@NonNull View itemView) {
            super(itemView);
            nomCom = itemView.findViewById(R.id.text_view_NomC);
            classTH = itemView.findViewById(R.id.text_view_Class);
            price = itemView.findViewById(R.id.text_view_Prix);
            // lot =itemView.findViewById(R.id.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.OnItemClick(medicament.get(position));

                    }
                }
            });


        }


    }


}
