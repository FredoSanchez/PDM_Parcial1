package com.example.pdm_parcial1.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm_parcial1.Adapters.PartidoAdapter
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.ViewModel.PartidoViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var partidoViewModel: PartidoViewModel

    companion object {
        const val newPartidoActivityRequestCode = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        val partidos: LiveData<List<Partido>> = partidoViewModel.getAllPartidos()

        val partidoObserver = Observer<List<Partido>>{ lista ->
            if(lista.size > 0){
                setUpView(getDTOList(lista))
            }else{
                Log.d("prueba","no hay tags")
            }
        }

        partidos.observe(this,partidoObserver)

        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, NewPartidoActivity::class.java)
            startActivityForResult(intent, newPartidoActivityRequestCode)
        }
    }

    fun getDTOList(partidos: List<Partido>): ArrayList<PartidoDTO>{
        val partidoDTOList = ArrayList<PartidoDTO>()

        for(i in partidos){
            partidoDTOList.add(PartidoDTO(i.EquipoA,i.EquipoB,i.PuntosEquipoA,i.PuntosEquipoB))
        }

        return partidoDTOList
    }

    fun setUpView(partido: ArrayList<PartidoDTO>){

        var viewManager = LinearLayoutManager(this)

        lateinit var viewAdapter: PartidoAdapter

        viewAdapter = PartidoAdapter(this,{ partidoItem: PartidoDTO -> itemClickedPortrait(partidoItem)})

        viewAdapter.setPartido(partido)

        partido_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun itemClickedPortrait(partido: PartidoDTO){

        val partidoBundle = Bundle()
        partidoBundle.putParcelable("partido",partido)

        startActivity(Intent(this, PartidoDetailActivity::class.java).putExtras(partidoBundle))
    }
}
