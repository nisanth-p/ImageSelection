package com.neltech.renthouse.view.ui.show

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentImageSelectionBinding
import com.neltech.renthouse.view.base.BaseFragment
import com.neltech.renthouse.view.base.BaseViewModel
import com.neltech.renthouse.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
@DelicateCoroutinesApi
@AndroidEntryPoint
class ShowImagesFragment : BaseFragment<FragmentImageSelectionBinding>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    private var _viewBinding: FragmentImageSelectionBinding? = null
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentImageSelectionBinding
        get() = FragmentImageSelectionBinding::inflate
    val sharedViewModel by activityViewModels<BaseViewModel>()
    val viewModel by viewModels<ShowImagesViewModel>()
    override fun setup() {

    }

    override fun layoutRes(): Int =R.layout.show_images_fragment

    override fun onDestroyView() {
        super.onDestroyView()
    }
}