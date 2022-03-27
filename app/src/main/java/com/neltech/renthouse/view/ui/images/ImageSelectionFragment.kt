package com.neltech.renthouse.view.ui.images

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentImageSelectionBinding
import com.neltech.renthouse.view.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

@DelicateCoroutinesApi
class ImageSelectionFragment : BaseFragment<FragmentImageSelectionBinding>(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentImageSelectionBinding
        get() = FragmentImageSelectionBinding::inflate

    override fun setup() {

    }

    override fun layoutRes(): Int =R.layout.fragment_image_selection
}