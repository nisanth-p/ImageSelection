package com.neltech.renthouse.model.db.api

import com.neltech.renthouse.model.data.AppScriptResponse
import com.neltech.renthouse.model.utill.UrlConstants
import retrofit2.Response
import retrofit2.http.*

interface ApiService{
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST(UrlConstants.QUERY_API)
    suspend fun postImages(@FieldMap options: Map<String, String> ): Response<AppScriptResponse>

    @FormUrlEncoded
    @GET(UrlConstants.QUERY_API)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun getImages(@FieldMap options: Map<String, String> ): Response<AppScriptResponse>
}