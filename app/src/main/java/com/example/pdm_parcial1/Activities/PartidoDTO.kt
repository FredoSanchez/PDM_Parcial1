package com.example.pdm_parcial1.Activities

import android.os.Parcel
import android.os.Parcelable

class PartidoDTO(
    val equipoA:String = "N/A",
    val equipoB:String = "N/A",
    val puntosEquipoA:Int = 0,
    val puntosEquipoB:Int = 0
): Parcelable {
    constructor(parcel: Parcel):this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(equipoA)
        parcel.writeString(equipoB)
        parcel.writeInt(puntosEquipoA)
        parcel.writeInt(puntosEquipoB)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PartidoDTO> {
        override fun createFromParcel(parcel: Parcel): PartidoDTO {
            return PartidoDTO(parcel)
        }

        override fun newArray(size: Int): Array<PartidoDTO?> {
            return arrayOfNulls(size)
        }
    }
}