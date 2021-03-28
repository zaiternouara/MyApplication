package com.example.myapplication.models;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "TABLE_MEDICAMENTS", indices = {
        @Index(value = "nom_Commercial", unique = true)
})
public class MEDICAMENTS {
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
    private String remboursable;
    private String codeB;


    public MEDICAMENTS(String classe_Therapeutique, String nom_Commercial, String laboratoire, String denominateur_De_Medicament, String forme_Pharmaceutique, String duree_De_Conservation, String remboursable, String lot, String date_De_Fabrication, String date_Peremption, String description_De_Composant, String prix, String quantite_En_Stock, String codeB) {
        this.classe_Therapeutique = classe_Therapeutique;
        this.nom_Commercial = nom_Commercial;
        this.laboratoire = laboratoire;
        this.denominateur_De_Medicament = denominateur_De_Medicament;
        this.forme_Pharmaceutique = forme_Pharmaceutique;
        this.duree_De_Conservation = duree_De_Conservation;
        this.remboursable = remboursable;
        this.lot = lot;
        this.date_De_Fabrication = date_De_Fabrication;
        this.date_Peremption = date_Peremption;
        this.description_De_Composant = description_De_Composant;
        this.prix = prix;
        this.quantite_En_Stock = quantite_En_Stock;
        this.codeB = codeB;
    }

    /*

public MEDICAMENTS(String classe_Therapeutique, String nom_Commercial, String laboratoire, String denominateur_De_Medicament, String forme_Pharmaceutique, String duree_De_Conservation, String lot, String date_De_Fabrication, String date_Peremption, String description_De_Composant, String prix, String quantite_En_Stock) {
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
*/
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

    public String getCodeB() {
        return codeB;
    }

    public void setCodeB(String codeB) {
        this.codeB = codeB;
    }

    public String getRemboursable() {
        return remboursable;
    }

    public void setRemboursable(String remboursable) {
        this.remboursable = remboursable;
    }
}