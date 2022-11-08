package com.example.androidimpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidimpnote.ApiClient.Companion.getRetrofit
import com.example.androidimpnote.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.doneBtn.setOnClickListener {
            creteUser(mainBinding.nameEdt.text.toString(),mainBinding.jobEdt.text.toString())
        }

    }
    fun creteUser(name : String,job : String){

        var apiInterface = getRetrofit().create(ApiInterface::class.java)
        apiInterface.getUser(name, job).enqueue(object : Callback<ModelData> {
            override fun onResponse(call: Call<ModelData>, response: Response<ModelData>) {
                var msg = response.body()!!.data

                Log.e("TAG", "onResponse:${response.message()}", )
                Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ModelData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}