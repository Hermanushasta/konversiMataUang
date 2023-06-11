package org.d3if0043.konversimatauang.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0043.konversimatauang.model.Bendera
import org.d3if0043.konversimatauang.network.ApiStatus
import org.d3if0043.konversimatauang.network.BenderaApi

class MainViewModel : ViewModel() {
    private val data = MutableLiveData<List<Bendera>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue((BenderaApi.service.getBendera()))
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Bendera>> = data

    fun getStatus(): LiveData<ApiStatus> = status

}