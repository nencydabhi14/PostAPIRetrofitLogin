package com.example.androidimpnote

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("users")
    fun getUser(@Field("name") name : String, @Field("job") job : String) : Call<ModelData>
}