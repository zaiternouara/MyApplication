package com.example.myapplication.OperationsSQLite;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.models.MEDICAMENTS;

import java.util.List;

@Dao

public interface MedicamentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MEDICAMENTS medicament);

    @Update
    void update(MEDICAMENTS medicament);

    @Delete
    void delete(MEDICAMENTS medicament);

    @Query("DELETE FROM TABLE_MEDICAMENTS")
    void deleteAllMEDICAMENTS();

    @Query("SELECT  * FROM TABLE_MEDICAMENTS ORDER BY Nom_Commercial DESC")
    LiveData<List<MEDICAMENTS>> getAllMEDICAMENTS();

    @Query("SELECT * FROM TABLE_MEDICAMENTS GROUP BY laboratoire ORDER BY laboratoire DESC")
    LiveData<List<MEDICAMENTS>> getAllaboratoires();

    @Query("SELECT * FROM TABLE_MEDICAMENTS WHERE '2020/09/06'>=date_Peremption ORDER BY Nom_Commercial DESC")
    LiveData<List<MEDICAMENTS>> getAllPeremptioN();

    @Query("SELECT * FROM TABLE_MEDICAMENTS WHERE Nom_Commercial = :search OR denominateur_De_Medicament = :search ORDER BY Nom_Commercial DESC")

    LiveData<List<MEDICAMENTS>> SearchMedicamemts(String search);



}