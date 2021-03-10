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

    @Query("SELECT DISTINCT * FROM TABLE_MEDICAMENTS GROUP BY laboratoire")
    LiveData<List<MEDICAMENTS>> getAllaboratoires();

    @Query("SELECT DISTINCT * FROM TABLE_MEDICAMENTS WHERE DATE()>=date_Peremption")
    LiveData<List<MEDICAMENTS>> getAllPeremptioN();



}