package com.example.androidimpnote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        var Base_url = "https://reqres.in/api/"

        fun getRetrofit(): Retrofit {
            var retrofit =
                Retrofit.Builder().baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit
        }
    }
}