package com.example.myapplication.models;


import android.os.Parcel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TABLE_MEDICAMENTS")
public class MEDICAMENTS  {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Classe_Therapeutique;
    private String Nom_Commercial;
    private String Laboratoire;
    private String Denominateur_De_Medicament;
    private String Forme_Pharmaceutique;
    private int Duree_De_Conservation;
    private int Remborsable;
    private String Lot;
    private String Date_De_Fabrication;
    private String Date_Peremption;
    private String Description_De_Composant;
    private double Prix;
    private int Quantite_En_Stock;


    public MEDICAMENTS(String Classe_Therapeutique, String Nom_Commercial, int Duree_De_Conservation) {
        this.Classe_Therapeutique = Classe_Therapeutique;
        this.Laboratoire = Laboratoire;
        this.Denominateur_De_Medicament = Denominateur_De_Medicament;
        this.Forme_Pharmaceutique = Forme_Pharmaceutique;
        this.Duree_De_Conservation = Duree_De_Conservation;
        this.Remborsable = Remborsable;
        this.Lot = Lot;
        this.Date_De_Fabrication = Date_De_Fabrication;
        this.Date_Peremption = Date_Peremption;
        this.Description_De_Composant = Description_De_Composant;
        this.Prix= Prix;
        this.Quantite_En_Stock = Quantite_En_Stock;

    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
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

    public String getClasse_Therapeutique() {
        return Classe_Therapeutique;
    }

    public String getNom_Commercial() {
        return Nom_Commercial;
    }

    public String getLaboratoire() {
        return Laboratoire;
    }

    public String getDenominateur_De_Medicament() {
        return Denominateur_De_Medicament;
    }

    public String getForme_Pharmaceutique() {
        return Forme_Pharmaceutique;
    }

    public int getDuree_De_Conservation() {
        return Duree_De_Conservation;
    }

    public int getRemborsable() {
        return Remborsable;
    }

    public String getLot() {
        return Lot;
    }

    public String getDate_De_Fabrication() {
        return Date_De_Fabrication;
    }

    public String getDate_Peremption() {
        return Date_Peremption;
    }

    public String getDescription_De_Composant() {
        return Description_De_Composant;
    }

    public double getPrix() {
        return Prix;
    }

    public int getQuantite_En_Stock() {
        return Quantite_En_Stock;
    }

    public void setClasse_Therapeutique(String classe_Therapeutique) {
        Classe_Therapeutique = classe_Therapeutique;
    }

    public void setNom_Commercial(String nom_Commercial) {
        Nom_Commercial = nom_Commercial;
    }

    public void setLaboratoire(String laboratoire) {
        Laboratoire = laboratoire;
    }

    public void setDenominateur_De_Medicament(String denominateur_De_Medicament) {
        Denominateur_De_Medicament = denominateur_De_Medicament;
    }

    public void setForme_Pharmaceutique(String forme_Pharmaceutique) {
        Forme_Pharmaceutique = forme_Pharmaceutique;
    }

    public void setDuree_De_Conservation(int duree_De_Conservation) {
        Duree_De_Conservation = duree_De_Conservation;
    }

    public void setRemborsable(int remborsable) {
        Remborsable = remborsable;
    }

    public void setLot(String lot) {
        Lot = lot;
    }

    public void setDate_De_Fabrication(String date_De_Fabrication) {
        Date_De_Fabrication = date_De_Fabrication;
    }

    public void setDate_Peremption(String date_Peremption) {
        Date_Peremption = date_Peremption;
    }

    public void setDescription_De_Composant(String description_De_Composant) {
        Description_De_Composant = description_De_Composant;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public void setQuantite_En_Stock(int quantite_En_Stock) {
        Quantite_En_Stock = quantite_En_Stock;
    }
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