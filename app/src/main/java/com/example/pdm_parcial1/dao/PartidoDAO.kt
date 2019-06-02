package com.example.pdm_parcial1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pdm_parcial1.Entities.Partido

@Dao
interface PartidoDAO {
    @Query("SELECT * FROM table_partido order by Id_Partido ASC")
    fun getAllPartido (): LiveData<List<Partido>>

    @Query("SELECT * FROM table_partido WHERE Id_Partido = :idPartido")
    fun getPartidoById(idPartido: Int): LiveData<List<Partido>>

    @Insert
    suspend fun insertPartido(partido : Partido)

    @Query("DELETE FROM table_partido")
    fun deleteAllPartido()
}