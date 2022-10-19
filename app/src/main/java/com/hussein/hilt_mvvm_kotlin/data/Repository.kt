package com.hussein.hilt_mvvm_kotlin.data

import com.hussein.hilt_mvvm_kotlin.model.ImageResponse
import com.hussein.hilt_mvvm_kotlin.retrofit.BaseApiResponse
import com.hussein.hilt_mvvm_kotlin.retrofit.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {
    suspend fun getImageData(): Flow<NetworkResult<ImageResponse>> {
        return flow<NetworkResult<ImageResponse>> {
            emit(safeApiCall { remoteDataSource.getImageData() })
        }.flowOn(Dispatchers.IO)
    }
}