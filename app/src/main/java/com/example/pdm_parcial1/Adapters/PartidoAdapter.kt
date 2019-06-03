package com.example.pdm_parcial1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.R

class PartidoAdapter internal constructor(context: Context) : RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val partidoItemView : TextView = itemView.findViewById(R.id.tv_Equipos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PartidoViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder.partidoItemView.text = current.EquipoA
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = partidos.size

}