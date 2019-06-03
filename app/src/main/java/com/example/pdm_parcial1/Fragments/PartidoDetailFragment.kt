package com.example.pdm_parcial1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pdm_parcial1.Activities.PartidoDTO
import com.example.pdm_parcial1.R
import kotlinx.android.synthetic.main.fragment_partido_detail.view.*

class PartidoDetailFragment : Fragment() {
    private var partido = PartidoDTO()
    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_partido_detail, container, false)
        fragmentView = view

        bindData()

        return view
    }

    fun bindData(){

        fragmentView.equipoA.text = partido.equipoA
        fragmentView.equipoB.text = partido.equipoB
        fragmentView.puntos_equipoA.text = partido.puntosEquipoA.toString()
        fragmentView.puntos_equipoB.text = partido.puntosEquipoB.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(partido: PartidoDTO):PartidoDetailFragment{
            val newFragment = PartidoDetailFragment()
            newFragment.partido = partido

            return newFragment
        }
    }
}