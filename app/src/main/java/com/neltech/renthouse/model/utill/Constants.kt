package com.neltech.renthouse.model.utill

import android.content.Context
import android.content.pm.ApplicationInfo


object UrlConstants{
    const val BASE_APPSCRIPT_URL = "https://script.google.com/"

    const val BASE_FIREBASE_URL = "https://script.google.com/macros/s/AKfycbxls_wGjNaFRozJDLwZyITi3lkL4I7EQQLZXAfU-OT5ggNrlxTlmQZviYuyf6uAqNDz/exec?action=insert"
    private const val APPSCRIPT_DEPLOY_KEY = "AKfycbxls_wGjNaFRozJDLwZyITi3lkL4I7EQQLZXAfU-OT5ggNrlxTlmQZviYuyf6uAqNDz"
    const val QUERY_API = "macros/s/${APPSCRIPT_DEPLOY_KEY}/exec"
}

object DebugMode{
    fun isDebug(context: Context) = (0 != context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE)
}