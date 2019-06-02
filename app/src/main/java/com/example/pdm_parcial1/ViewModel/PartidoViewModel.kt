package com.example.pdm_parcial1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pdm_parcial1.Database.PartidoRoomDatabase
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.Repository.PartidoRepository

class PartidoViewModel(application: Application) : AndroidViewModel(application){
    private val partidoRepository: PartidoRepository

    val allPartidos : LiveData<List<Partido>>

    init {
        val partidosDao = PartidoRoomDatabase.getDatabase(application).partidoDao()
        partidoRepository = PartidoRepository(partidosDao)
        allPartidos = partidoRepository.allPartido
    }



}