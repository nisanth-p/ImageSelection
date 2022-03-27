package com.neltech.renthouse.view.ui.login
import com.neltech.domain.common.NetworkHelper
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val networkHelper: NetworkHelper
) : BaseViewModel(networkHelper){
}