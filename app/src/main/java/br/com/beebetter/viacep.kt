package br.com.beebetter

import CEP
import RetrofitFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class viacep : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viacep)

        val buttonSearch: Button = findViewById(R.id.button3)
        val cep: EditText = findViewById(R.id.editText)

        buttonSearch.setOnClickListener {

            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.body()?.let {
                        Log.i("CEP", it.toString())
                        Toast.makeText(this@viacep, it.toString(), Toast.LENGTH_LONG).show()
                    } ?: Toast.makeText(this@viacep, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()

                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }
            })
        }
    }
}