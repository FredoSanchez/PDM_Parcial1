package com.example.pdm_parcial1.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_partido")
class Partido(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id_Partido") val Id_Partido: Int = 0,
    @ColumnInfo(name = "EquipoA") val EquipoA: String,
    @ColumnInfo(name = "EquipoB") val EquipoB: String,
    @ColumnInfo(name = "PuntosA") val PuntosEquipoA: Int,
    @ColumnInfo(name = "PuntosA") val PuntosEquipoB: Int
)