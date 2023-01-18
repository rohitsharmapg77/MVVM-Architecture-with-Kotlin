package com.example.mvvm_architecture_with_kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
      @GET("popular?")
      fun getPopularMovies(@Query("api_key") api_key : String) : Call<CatList>
}