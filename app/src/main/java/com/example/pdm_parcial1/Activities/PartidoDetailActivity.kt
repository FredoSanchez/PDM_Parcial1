package com.example.pdm_parcial1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pdm_parcial1.Fragments.PartidoDetailFragment
import com.example.pdm_parcial1.R

class PartidoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido_detail)
        var partidoInfo: PartidoDTO = intent?.extras?.getParcelable("partido")?:PartidoDTO()

        initActivity(partidoInfo)
    }

    fun initActivity(partido:PartidoDTO){
        var fragment = PartidoDetailFragment.newInstance(partido)
        changeFragment(R.id.content,fragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(id, frag)
            .commit()
    }
}
