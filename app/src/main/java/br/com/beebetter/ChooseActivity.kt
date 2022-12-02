package br.com.beebetter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        include2.setOnClickListener {
            openRecycle()
        }
    }
    private fun openRecycle() {
        val intent = Intent(this, viacep::class.java);
        startActivity(intent);
    }
}