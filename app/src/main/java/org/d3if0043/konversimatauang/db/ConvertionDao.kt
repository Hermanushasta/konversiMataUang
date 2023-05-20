package org.d3if0043.konversimatauang.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConvertionDao {

    @Insert
    fun insert(convertion: ConvertionEntity)

    @Query("SELECT * FROM convertion ORDER BY id DESC LIMIT 1")
    fun getLastConvertion(): LiveData<List<ConvertionEntity>>

    @Query("DELETE FROM convertion")
    fun clearData()
}