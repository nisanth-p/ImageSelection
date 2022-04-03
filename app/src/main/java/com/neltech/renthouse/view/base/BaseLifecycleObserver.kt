package com.neltech.renthouse.view.base

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.neltech.renthouse.model.utill.NetworkHelper
import com.neltech.renthouse.model.utill.PrefImpl
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


private const val TAG = "BaseLifecycleObserver"
@DelicateCoroutinesApi
class BaseLifecycleObserver(private val context: Activity, private val registry: ActivityResultRegistry, private val networkHelper: NetworkHelper) : BaseViewModel(networkHelper),DefaultLifecycleObserver {

      var sharedPref: PrefImpl=PrefImpl(context = context)

    lateinit var getContent: ActivityResultLauncher<String>
    override fun onCreate(owner: LifecycleOwner) {
        getContent = registry.register("IMAGE", owner, ActivityResultContracts.GetContent()) { uri ->
            // Handle the returned Uri
            Log.i(TAG, "onCreate: uri = $uri")

            sharedPref.put("IMAGE",uri.toString())
            image_uri.value=uri.toString()
        }
    }
    fun selectImage(func:(file:Any)->Any) {
        func(getContent.launch("image/*"))
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.i(TAG, "onResume: ")
        super<BaseViewModel>.onResume(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.i(TAG, "onDestroy: ")
        super<BaseViewModel>.onDestroy(owner)
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.i(TAG, "onStart: ")
        super<BaseViewModel>.onStart(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i(TAG, "onStop: ")
        super<BaseViewModel>.onStop(owner)
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared: ")
        super.onCleared()
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i(TAG, "onPause: ")
        super <BaseViewModel>.onPause(owner)
    }
}
