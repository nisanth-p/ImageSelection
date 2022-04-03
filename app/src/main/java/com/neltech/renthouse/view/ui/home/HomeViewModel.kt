package com.neltech.renthouse.view.ui.home

import androidx.lifecycle.viewModelScope
import com.neltech.renthouse.model.db.remote.RemoteDataStoreImpl
import com.neltech.renthouse.model.utill.NetworkHelper
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remote: RemoteDataStoreImpl,
    private val networkHelper: NetworkHelper
) : BaseViewModel(networkHelper) {
    fun uploadImage( map:HashMap<String,String>){
        viewModelScope.launch {
            remote.postImage(map)
        }
    }
}