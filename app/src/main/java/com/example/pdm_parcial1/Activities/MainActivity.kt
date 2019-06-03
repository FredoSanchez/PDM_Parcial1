package com.example.pdm_parcial1.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    private val newPartidoActivityRequestCode = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PartidoAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        partidoViewModel.allPartidos.observe(this, Observer { partidos ->
            partidos?.let { adapter.setPartidos(it) }
        })

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPartidoActivity::class.java)
            startActivityForResult(intent, newPartidoActivityRequestCode)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPartidoActivityRequestCode && resultCode == Activity.RESULT_OK){
            intentData?.let { data ->

                //Aqui es donde debo pasar los datos de los put extra
                val partido = Partido(1,data.getStringExtra(NewPartidoActivity.EXTRA_REPLY),"ascaf",23,32)
                partidoViewModel.insertPartido(partido)
            }

            }else {
            Toast.makeText(applicationContext,"Nada...",Toast.LENGTH_LONG).show()
        }

    }
}
