package fr.epita.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextName : EditText? = findViewById(R.id.nameImput)
        startButton.setOnClickListener {
            if ((editTextName != null) && (editTextName.text.trim().isNotEmpty())) {
                val explicitIntent = Intent(this@MainActivity, GameActivity::class.java)
                explicitIntent.putExtra("name", editTextName.text.toString())
                startActivity(explicitIntent)
            } else {
                val toast = Toast.makeText(this@MainActivity, "Name can't be null", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}