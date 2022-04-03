package com.neltech.renthouse.view.ui.show

import androidx.lifecycle.ViewModel
import com.neltech.renthouse.model.db.remote.RemoteDataStoreImpl
import com.neltech.renthouse.model.utill.NetworkHelper
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class ShowImagesViewModel  @Inject constructor(
    private val remote: RemoteDataStoreImpl,
private val networkHelper: NetworkHelper
): BaseViewModel(networkHelper){

}