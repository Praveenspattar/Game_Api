package com.myapps.saple_game_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.mmobomb.com/api1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)

        val response = retrofit.getApiData()

        response.enqueue(object : Callback<game_data>{
            override fun onResponse(call: Call<game_data>, response: Response<game_data> ){
                val responseBody = response.body()
                val result_data  = responseBody

                Log.d("praveen" , "onCreate: ${result_data}")

            }

            override fun onFailure(call: Call<game_data>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}