package br.com.beebetter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var buttonInitiate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        buttonInitiate = findViewById<Button>(R.id.button_iniciar)
        Toast.makeText(this, "Seja bem-vindo!", Toast.LENGTH_SHORT).show()
        buttonInitiate.setOnClickListener {
            init()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun init() {
    val initLogin = Intent(this, LoginActivity::class.java)
        startActivity(initLogin)
    }
}