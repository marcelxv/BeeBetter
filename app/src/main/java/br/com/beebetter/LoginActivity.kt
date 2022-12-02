package br.com.beebetter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        button_email.setOnClickListener {
            openActivities()
        }

    }

    private fun openActivities() {
        val intent = Intent(this, ChooseActivity::class.java);
        startActivity(intent);
    }

}