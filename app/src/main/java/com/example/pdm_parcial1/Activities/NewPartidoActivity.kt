package com.example.pdm_parcial1.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import com.example.pdm_parcial1.R
import kotlinx.android.synthetic.main.activity_new_partido.*

class NewPartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        val button = findViewById<Button>(R.id.bt_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if(TextUtils.isEmpty(et_TeamAName.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val teamAName = et_TeamAName.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, teamAName)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
