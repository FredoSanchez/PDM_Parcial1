package com.example.pdm_parcial1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdm_parcial1.Database.PartidoRoomDatabase
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.Repository.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application){
    private val partidoRepository: PartidoRepository

    val allPartidos : LiveData<List<Partido>>

    init {
        val partidosDao = PartidoRoomDatabase.getDatabase(application, viewModelScope).partidoDao()
        partidoRepository = PartidoRepository(partidosDao)
        allPartidos = partidoRepository.allPartido
    }

    fun insertPartido(partido: Partido) = viewModelScope.launch(Dispatchers.IO){
        partidoRepository.insertPartido(partido)
    }

    /*
    fun getPartidoById(idPartido: Int): LiveData<List<Partido>>{
        return partidoRepository.getPartidoById(idPartido)
    }
    */
}