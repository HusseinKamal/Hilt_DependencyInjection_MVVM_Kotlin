package com.hussein.hilt_mvvm_kotlin.retrofit

import com.hussein.hilt_mvvm_kotlin.model.ImageResponse
import com.hussein.hilt_mvvm_kotlin.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET(Constants.RANDOM_URL)
    suspend fun getImageData(): Response<ImageResponse>
}