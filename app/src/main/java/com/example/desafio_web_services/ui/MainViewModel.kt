package com.example.desafio_web_services.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio_web_services.domain.HQ
import com.example.desafio_web_services.services.Repository
import com.example.desafio_web_services.services.repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel (repository: Repository): ViewModel() {

    val hqs = MutableLiveData<ArrayList<HQ>>()

    fun popListHqs(offset: Int) {
        try {
            viewModelScope.launch {
                hqs.value = repository.getResults(
                        offset,
                        15,
                        "1",
                        "f326731ea4c3b87d5692ceb79f6cca25",
                        "fd5ae999bbb427980b6cb3e3631152ff"
                ).data.results
                Log.i("DATA", hqs.value.toString())
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", e.toString())
        }
    }
}