package com.example.mvvm_architecture_with_kotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()
  fun getPopularMovies() {
      RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object  :
          Callback<CatList> {
          override fun onResponse(call: Call<CatList>, response: Response<CatList>) {
                    if (response.body()!=null){
                        movieLiveData.value = response.body()!!.results
                    }
              else{
                  return
                    }
          }
          override fun onFailure(call: Call<CatList>, t: Throwable) {
                Log.d("TAG",t.message.toString())
          }
      })
  }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}