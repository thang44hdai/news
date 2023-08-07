package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.apiRequest
import com.example.myapplication.model.news
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewModel : ViewModel() {
    val data: MutableLiveData<news> = MutableLiveData()
    fun get_data(): MutableLiveData<news>{
        apiRequest.api.getNew().enqueue(object : Callback<news>{
            override fun onResponse(call: Call<news>, response: Response<news>) {
                data.postValue(response.body()!!)
            }
            override fun onFailure(call: Call<news>, t: Throwable) {
            }

        })
        return data
    }
}