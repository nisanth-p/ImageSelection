package com.neltech.renthouse.view.base

import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.neltech.domain.common.NetworkHelper
import kotlinx.coroutines.DelicateCoroutinesApi


private const val TAG = "BaseLifecycleObserver"
@DelicateCoroutinesApi
class BaseLifecycleObserver(private val registry: ActivityResultRegistry,private val networkHelper: NetworkHelper) : BaseViewModel(networkHelper),DefaultLifecycleObserver {

    lateinit var getContent: ActivityResultLauncher<String>
    override fun onCreate(owner: LifecycleOwner) {
        getContent = registry.register("Rion", owner, ActivityResultContracts.GetContent()) { uri ->
            // Handle the returned Uri
            Log.i(TAG, "onCreate: uri = $uri")
        }
    }
    fun selectImage() {
        getContent.launch("image/*")
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
