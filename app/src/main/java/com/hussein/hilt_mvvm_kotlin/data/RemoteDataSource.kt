package com.hussein.hilt_mvvm_kotlin.data

import com.hussein.hilt_mvvm_kotlin.retrofit.RetrofitService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val retrofitService: RetrofitService) {
    suspend fun getImageData() =
        retrofitService.getImageData()
}