package com.example.myapplication.models;


import android.os.Parcel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TABLE_MEDICAMENTS")
public class MEDICAMENTS  {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String classe_Therapeutique;
    private String nom_Commercial;
    private String laboratoire;
    private String denominateur_De_Medicament;
    private String forme_Pharmaceutique;
    private String duree_De_Conservation;

    private String lot;
    private String date_De_Fabrication;
    private String date_Peremption;
    private String description_De_Composant;
    private String prix;
    private String quantite_En_Stock;

    public MEDICAMENTS(String classe_Therapeutique, String nom_Commercial, String laboratoire, String denominateur_De_Medicament, String forme_Pharmaceutique, String duree_De_Conservation,  String lot, String date_De_Fabrication, String date_Peremption, String description_De_Composant, String prix, String quantite_En_Stock) {

        this.classe_Therapeutique = classe_Therapeutique;
        this.nom_Commercial = nom_Commercial;
        this.laboratoire = laboratoire;
        this.denominateur_De_Medicament = denominateur_De_Medicament;
        this.forme_Pharmaceutique = forme_Pharmaceutique;
        this.duree_De_Conservation = duree_De_Conservation;

        this.lot = lot;
        this.date_De_Fabrication = date_De_Fabrication;
        this.date_Peremption = date_Peremption;
        this.description_De_Composant = description_De_Composant;
        this.prix = prix;
        this.quantite_En_Stock = quantite_En_Stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasse_Therapeutique() {
        return classe_Therapeutique;
    }

    public void setClasse_Therapeutique(String classe_Therapeutique) {
        this.classe_Therapeutique = classe_Therapeutique;
    }

    public String getNom_Commercial() {
        return nom_Commercial;
    }

    public void setNom_Commercial(String nom_Commercial) {
        this.nom_Commercial = nom_Commercial;
    }

    public String getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(String laboratoire) {
        this.laboratoire = laboratoire;
    }

    public String getDenominateur_De_Medicament() {
        return denominateur_De_Medicament;
    }

    public void setDenominateur_De_Medicament(String denominateur_De_Medicament) {
        this.denominateur_De_Medicament = denominateur_De_Medicament;
    }

    public String getForme_Pharmaceutique() {
        return forme_Pharmaceutique;
    }

    public void setForme_Pharmaceutique(String forme_Pharmaceutique) {
        this.forme_Pharmaceutique = forme_Pharmaceutique;
    }

    public String getDuree_De_Conservation() {
        return duree_De_Conservation;
    }

    public void setDuree_De_Conservation(String duree_De_Conservation) {
        this.duree_De_Conservation = duree_De_Conservation;
    }




    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getDate_De_Fabrication() {
        return date_De_Fabrication;
    }

    public void setDate_De_Fabrication(String date_De_Fabrication) {
        this.date_De_Fabrication = date_De_Fabrication;
    }

    public String getDate_Peremption() {
        return date_Peremption;
    }

    public void setDate_Peremption(String date_Peremption) {
        this.date_Peremption = date_Peremption;
    }

    public String getDescription_De_Composant() {
        return description_De_Composant;
    }

    public void setDescription_De_Composant(String description_De_Composant) {
        this.description_De_Composant = description_De_Composant;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQuantite_En_Stock() {
        return quantite_En_Stock;
    }

    public void setQuantite_En_Stock(String quantite_En_Stock) {
        this.quantite_En_Stock = quantite_En_Stock;
    }


/*protected MEDICAMENTS(Parcel in){
        Classe_Therapeutique=in.readString();
        Laboratoire=in.readString();
        Denominateur_De_Medicament =in.readString();
        Forme_Pharmaceutique =in.readString();
        Duree_De_Conservation =in.readInt();
        Remborsable =in.readInt();
        Lot =in.readString();
        Date_De_Fabrication = in.readString();
        Date_Peremption =in.readString();
        Description_De_Composant =in.readString();
        Prix =in.readDouble();
        Quantite_En_Stock =in.readInt();
    }*/
    /*public static final Creator<MEDICAMENTS> CREATOR = new Creator<MEDICAMENTS>() {
        @Override
        public MEDICAMENTS createFromParcel(Parcel source) {
            return new MEDICAMENTS(source);
        }

        @Override
        public MEDICAMENTS[] newArray(int size) {
            return new MEDICAMENTS[size];
        }
    }*/





/**
 * Describe the kinds of special objects contained in this Parcelable
 * instance's marshaled representation. For example, if the object will
 * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
 * the return value of this method must include the
 * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
 *
 * @return a bitmask indicating the set of special object types marshaled
 * by this Parcelable object instance.
 */
    /*@Override
    public int describeContents() {
        return 0;
    }*/

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    /*@Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeToParcel(Classe_Therapeutique);
            parcel.writeToParcel(Nom_Commercial);
            parcel.writeToParcel(Laboratoire);
            parcel.writeToParcel(Denominateur_De_Medicament);
            parcel.writeToParcel(Forme_Pharmaceutique);
            parcel.writeToParcel(Duree_De_Conservation);
            parcel.writeToParcel(Remborsable);
            parcel.writeToParcel(Lot);
            parcel.writeToParcel(Date_De_Fabrication);
            parcel.writeToParcel(Date_Peremption);
            parcel.writeToParcel(Description_De_Composant);
            parcel.writeToParcel(Prix);
            parcel.writeToParcel(Quantite_En_Stock);



    }*/


}