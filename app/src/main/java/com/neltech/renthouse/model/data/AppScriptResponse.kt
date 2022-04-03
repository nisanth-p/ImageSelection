package com.neltech.renthouse.model.data

import com.google.gson.annotations.SerializedName

data class AppScriptResponse(

    @field:SerializedName("status_code")
    val statusCode: Int? = null,

    @field:SerializedName("success")
    val success: Boolean? = false,

    @field:SerializedName("message")
    val message: String? = null,

)