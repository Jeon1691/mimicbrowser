package io.develicit.mimicbrowser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val experimentalLiveData = MutableLiveData<Boolean>()

    init {
        experimentalLiveData.value = false
    }

    fun showExperiments() {
        experimentalLiveData.value = true
    }

    fun getLiveData(): LiveData<Boolean> = experimentalLiveData
}