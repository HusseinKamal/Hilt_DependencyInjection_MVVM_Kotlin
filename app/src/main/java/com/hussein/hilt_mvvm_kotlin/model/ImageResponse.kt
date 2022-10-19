package com.hussein.hilt_mvvm_kotlin.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)