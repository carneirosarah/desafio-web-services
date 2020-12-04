package com.example.desafio_web_services.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_web_services.domain.HQ

class HQViewModel: ViewModel() {

    val hq = MutableLiveData<HQ>()

    fun setHQ (obj: HQ) {
        hq.value.let {
            hq.value = obj
        }
    }
}