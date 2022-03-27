package com.neltech.renthouse.view.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentHomeBinding
import com.neltech.renthouse.view.base.BaseFragment
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

@DelicateCoroutinesApi
@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(), CoroutineScope {
    val sharedViewModel by activityViewModels<BaseViewModel>()
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {

    }

    override fun layoutRes(): Int =R.layout.fragment_home
    override fun onDestroyView() {
        super.onDestroyView()
        job.cancel()
    }
}