package fr.epita.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.game.*
import java.util.*

class GameActivity : AppCompatActivity() {
    var turn : Int = (0..1).random()
    var topLeft = 100
    var topMid = 100
    var topRight = 100
    var midLeft = 100
    var midMid = 100
    var midRight = 100
    var botLeft = 100
    var botMid = 100
    var botRight = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)
        val name: String = intent.getStringExtra("name")
        val playerName : TextView = findViewById(R.id.player)
        playerName.text = "O ($name)"
        topLeft = 100
        topMid = 100
        topRight = 100
        midLeft = 100
        midMid = 100
        midRight = 100
        botLeft = 100
        botMid = 100
        botRight = 100
        caseTopLeft.setOnClickListener {
            if (topLeft == 100) {
                val case : TextView = findViewById(R.id.caseTopLeft)
                case.text = getTurn()
                topLeft = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseTopMid.setOnClickListener {
            if (topMid == 100) {
                val case : TextView = findViewById(R.id.caseTopMid)
                case.text = getTurn()
                topMid = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseTopRight.setOnClickListener {
            if (topRight == 100) {
                val case : TextView = findViewById(R.id.caseTopRight)
                case.text = getTurn()
                topRight = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseMidLeft.setOnClickListener {
            if (midLeft == 100) {
                val case : TextView = findViewById(R.id.caseMidLeft)
                case.text = getTurn()
                midLeft = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseMidMid.setOnClickListener {
            if (midMid == 100) {
                val case : TextView = findViewById(R.id.caseMidMid)
                case.text = getTurn()
                midMid = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseMidRight.setOnClickListener {
            if (midRight == 100) {
                val case : TextView = findViewById(R.id.caseMidRight)
                case.text = getTurn()
                midRight = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseBotLeft.setOnClickListener {
            if (botLeft == 100) {
                val case : TextView = findViewById(R.id.caseBotLeft)
                case.text = getTurn()
                botLeft = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseBotMid.setOnClickListener {
            if (botMid == 100) {
                val case : TextView = findViewById(R.id.caseBotMid)
                case.text = getTurn()
                botMid = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
        caseBotRight.setOnClickListener {
            if (botRight == 100) {
                val case : TextView = findViewById(R.id.caseBotRight)
                case.text = getTurn()
                botRight = turn
                changeTurn()
            } else {
                alertAlreadySet()
            }
        }
    }

    fun changeTurn() {
        turn = if (turn == 0) 1 else 0
    }

    fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) +  start

    fun getTurn(): String {
        return if (turn == 0) "o" else "x"
    }

    fun alertAlreadySet() {
        val toast = Toast.makeText(this@GameActivity, "You can write on this square", Toast.LENGTH_LONG)
        toast.show()
    }

    fun displayWinner(winner : Int) {
        if (winner != 100) {
            var winnerstr = ""
            if (winner == 0)
                winnerstr = "O"
            if (winner == 1)
                winnerstr = "X"
        }

    }

    fun checkWinner() : Int {
        if (topLeft + topMid + topRight == 0)
            return 0
        if (topLeft + topMid + topRight == 3)
            return 1
        if (midLeft + midMid + midRight == 0)
            return 0
        if (midLeft + midMid + midRight == 3)
            return 1
        if (botLeft + botMid + botRight == 0)
            return 0
        if (botLeft + botMid + botRight == 3)
            return 1
        if (topLeft + midLeft + botLeft == 0)
            return 0
        if (topLeft + midLeft + botLeft == 3)
            return 1
        if (topMid + midMid + botMid == 0)
            return 0
        if (topMid + midMid + botMid == 3)
            return 1
        if (topRight + midRight + botRight == 0)
            return 0
        if (topRight + midRight + botRight == 3)
            return 1
        if (topLeft + midMid + botRight == 0)
            return 0
        if (topLeft + midMid + botRight == 3)
            return 1
        if (topRight + midMid + botLeft == 0)
            return 0
        if (topRight + midMid + botLeft == 3)
            return 1
        return 100
    }

}