package com.example.pdm_parcial1.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_partido")
data class Partido(
    @ColumnInfo(name = "EquipoA") val EquipoA: String,
    @ColumnInfo(name = "EquipoB") val EquipoB: String,
    @ColumnInfo(name = "PuntosEquipoA") val PuntosEquipoA: Int,
    @ColumnInfo(name = "PuntosEquipoB") val PuntosEquipoB: Int
){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id_Partido") val Id_Partido: Int = 0
}