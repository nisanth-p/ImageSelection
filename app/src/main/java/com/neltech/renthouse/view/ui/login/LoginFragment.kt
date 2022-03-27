package com.neltech.renthouse.view.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentLoginBinding
import com.neltech.renthouse.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
@DelicateCoroutinesApi
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(), CoroutineScope{
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    override fun setup() {

    }

    override fun layoutRes(): Int =R.layout.fragment_login

}