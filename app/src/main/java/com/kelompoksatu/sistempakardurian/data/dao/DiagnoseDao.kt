package com.kelompoksatu.sistempakardurian.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kelompoksatu.sistempakardurian.data.model.Prediction

@Dao
interface DiagnoseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiagnoseData(model: Prediction)

    @Query("SELECT * FROM prediction")
    fun getAllDiagnose(): LiveData<List<Prediction>>
//
//    @Query("DELETE FROM prediction")
//    suspend fun deleteAllTickets()
//
//    @Update
//    suspend fun update(data: Prediction)

}