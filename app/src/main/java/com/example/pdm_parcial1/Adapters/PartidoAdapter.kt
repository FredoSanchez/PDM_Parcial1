package com.example.pdm_parcial1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm_parcial1.Activities.PartidoDTO
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.R
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class PartidoAdapter(context: Context, val clickListener: (PartidoDTO) -> Unit)
    :RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partido = emptyList<PartidoDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return PartidoViewHolder(itemView)
    }

    override fun getItemCount() = partido.size

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partido[position]

        holder.bind(current,clickListener)
    }

    fun setPartido(partido: List<PartidoDTO>){
        this.partido = partido
    }

    inner class PartidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: PartidoDTO,clickListener: (PartidoDTO) -> Unit) = with(itemView){
            item_view_partido.text = item.equipoA + " vs " + item.equipoB
            this.setOnClickListener { clickListener(item) }
        }
    }

}