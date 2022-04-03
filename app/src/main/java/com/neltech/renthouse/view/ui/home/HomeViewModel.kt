package com.neltech.renthouse.view.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.neltech.renthouse.model.data.AppScriptResponse
import com.neltech.renthouse.model.db.remote.RemoteDataStoreImpl
import com.neltech.renthouse.model.utill.NetworkHelper
import com.neltech.renthouse.model.utill.responcehelper.Resource
import com.neltech.renthouse.model.utill.responcehelper.Resource.Companion.loading
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@DelicateCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remote: RemoteDataStoreImpl,
    private val networkHelper: NetworkHelper
) : BaseViewModel(networkHelper) {
    fun uploadImage( map:HashMap<String,String>){
        viewModelScope.launch {
            _res.postValue(Resource.loading(null))
            try {
                remote.postImage(map).let {
                    if (it.isSuccessful) {
                        Log.i(TAG, "registerUserData: isSuccessful = ${it.body()}")
                        _res.postValue(Resource.success(it.body()))
                    } else {
                        Log.i(TAG, "registerUserData: isFail = ${it.errorBody().toString()}")
                        _res.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            }catch (ex: Exception) {
                Log.i(TAG, "registerUserData: Exception = ${ex.message.toString()}")
                _res.postValue(Resource.error(ex.message.toString(), null))
            }
        }
    }

    /** Remote Response */

    private val _res = MutableLiveData<Resource<AppScriptResponse>>()

    val res: LiveData<Resource<AppScriptResponse>>
        get() = _res
}