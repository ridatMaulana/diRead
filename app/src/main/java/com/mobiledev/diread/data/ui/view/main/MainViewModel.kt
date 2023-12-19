package com.mobiledev.diread.data.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobiledev.diread.data.ui.view.UserRepository
import com.mobiledev.diread.remote.retrofit.ApiConfig
import com.mobiledev.diread.remote.retrofit.ApiService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(repository: UserRepository): ViewModel {
    private val _listJurnal=MutableLiveData<List<ItemsItem>>()
    val listJurnal:LiveData<List<ItemsItem>> =_listJurnal
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUser(){
        _isLoading.postValue(true)
        val client=ApiConfig.getApiService().getJurnal()
        client.enquene(object :Callback<blabal>{
            override fun onResponse(
                call: Call<blabal>,
                response: Response<balabl>
            ){
                if(response.isSuccessful){
                    val balabla=response.body()
                    _listJurnal.postValue(balabla)
                }
                _isLoading.postValue(blabal)
            }
            override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                _isLoading.postValue(false)

            }
        })

    }
}