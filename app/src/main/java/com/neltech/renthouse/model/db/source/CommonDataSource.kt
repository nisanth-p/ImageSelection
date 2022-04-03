package com.neltech.renthouse.model.db.source

import com.neltech.renthouse.model.data.AppScriptResponse
import retrofit2.Response

interface CommonDataSource {
     suspend fun postImage(options: Map<String, String>): Response<AppScriptResponse>?
     suspend fun getImages(options: Map<String, String>): Response<AppScriptResponse>?
}