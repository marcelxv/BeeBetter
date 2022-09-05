package br.com.beebetter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboard)

        val pesquisaCEP: Button = findViewById(R.id.pesquisaCEP)
        val cep: EditText = findViewById(R.id.cep)
        val progress_bar: ProgressBar = findViewById(R.id.progress_bar)
        val resultDisplay: TextView = findViewById(R.id.result)
        val listItems: LinearLayout = findViewById(R.id.listItems)

                pesquisaCEP.setOnClickListener {

                    progress_bar.visibility = View.VISIBLE

                    val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

                    call.enqueue(object : Callback<CEP> {

                        override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                            response.body()?.let {
                                Log.i("CEP", it.toString())
//                                Toast.makeText(this@OnboardActivity, it.toString(), Toast.LENGTH_LONG).show()
                                resultDisplay.visibility = View.VISIBLE
                                resultDisplay.text = it.logradouro+ '/' +it.bairro
                                progress_bar.visibility = View.INVISIBLE
                                listItems.visibility = View.VISIBLE
                            } ?: Toast.makeText(this@OnboardActivity, "CEP não localizado", Toast.LENGTH_LONG)
                                .show()

                        }

                        override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                            t?.message?.let { it1 -> Log.e("Erro", it1) }
                            progress_bar.visibility = View.INVISIBLE
                        }
                    })
                }
            }
    }