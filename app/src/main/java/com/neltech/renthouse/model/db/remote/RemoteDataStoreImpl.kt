package com.neltech.renthouse.model.db.remote

import com.neltech.renthouse.model.data.AppScriptResponse
import com.neltech.renthouse.model.db.api.ApiService
import com.neltech.renthouse.model.db.source.CommonDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import javax.inject.Inject

class RemoteDataStoreImpl
    @Inject constructor(private val remote: ApiService,
                        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) :
    CommonDataSource {
    override suspend fun postImage( options: Map<String, String>): Response<AppScriptResponse> {
      return remote.postImages(options)
    }

    override suspend fun getImages(options: Map<String, String>): Response<AppScriptResponse>? {
       return remote.getImages(options)
    }

}