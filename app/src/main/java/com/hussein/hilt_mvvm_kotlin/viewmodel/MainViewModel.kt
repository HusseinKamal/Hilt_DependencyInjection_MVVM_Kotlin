package com.hussein.hilt_mvvm_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hussein.hilt_mvvm_kotlin.data.Repository
import com.hussein.hilt_mvvm_kotlin.model.ImageResponse
import com.hussein.hilt_mvvm_kotlin.retrofit.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val repository: Repository,application: Application) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<ImageResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ImageResponse>> = _response

    fun fetchImageResponse() = viewModelScope.launch {
        repository.getImageData().collect { values ->
            _response.value = values
        }
    }
}