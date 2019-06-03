package com.example.pdm_parcial1.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.pdm_parcial1.R
import kotlinx.android.synthetic.main.activity_new_partido.*

class NewPartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        init()
    }

    fun init(){

        var equiposBundle = Bundle()
        var equipos: PartidoDTO
        btn_iniciar.setOnClickListener {
            equipos = PartidoDTO(name_equipoA.text.toString(),name_equipoB.text.toString(),0,0)
            equiposBundle.putParcelable("equipos",equipos)
            startActivity(Intent(this, JuegoActivity::class.java).putExtras(equiposBundle))
            finish()
        }
    }
}
