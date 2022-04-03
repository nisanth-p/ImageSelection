package com.neltech.renthouse.view.ui.show

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentImageSelectionBinding
import com.neltech.renthouse.model.utill.responcehelper.Status
import com.neltech.renthouse.view.base.BaseFragment
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

private const val TAG = "ShowImagesFragment"
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
    private val viewModel by viewModels<ShowImagesViewModel>()
    override fun setup() {
viewModel.getImages()
        bindViews()
    }

    private fun bindViews() {
        viewModel.res.observe(this){
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d(TAG, "bindViews: SUCCESS")

                }
                Status.LOADING -> {
                    Log.d(TAG, "bindViews: LOADING")
                }
                Status.ERROR -> {
                    Log.d(TAG, "bindViews: ERROR")
                    nav(R.id.action_homeFragment_to_showImagesFragment)
                }
            }
        }
    }

    override fun layoutRes(): Int =R.layout.show_images_fragment

    override fun onDestroyView() {
        super.onDestroyView()
    }
}