package com.example.pdm_parcial1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.activity_juego.*

class JuegoActivity : AppCompatActivity() {

    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var partidoViewModel: PartidoViewModel
    private lateinit var partidoInfo: PartidoDTO
    private lateinit var auxPartido: Partido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        partidoInfo = intent?.extras?.getParcelable("equipos")?:PartidoDTO()

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        teamA.setText(partidoInfo.equipoA)
        teamB.setText(partidoInfo.equipoB)

        displayScore(
            tv_score_team_a,
            partidoInfo.puntosEquipoA
        )

        displayScore(
            tv_score_team_b,
            partidoInfo.puntosEquipoB
        )
    }

    fun addOneTeamA(v: View) {
        displayScore(
            tv_score_team_a,
            ++scoreViewModel.scoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
            tv_score_team_b,
            ++scoreViewModel.scoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun saveScores(v: View) {

        auxPartido = Partido(partidoInfo.equipoA,
            partidoInfo.equipoB,
            scoreViewModel.scoreTeamA,
            scoreViewModel.scoreTeamB)
        partidoViewModel.insertPartido(auxPartido)

        finish()
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}
