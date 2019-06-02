package com.example.pdm_parcial1.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.dao.PartidoDAO

class PartidoRepository(private val partidoDao: PartidoDAO){

    val allPartido : LiveData<List<Partido>> = partidoDao.getAllPartido()

    //@WorkerThread
    //fun  getPartidoById(idPartido:Int): LiveData<List<Partido>> = partidoDao.getPartidoById(idPartido)

    @WorkerThread
    suspend fun insertPartido(partido:Partido) {
        partidoDao.insertPartido(partido)
    }
}