package com.neltech.renthouse.view.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentHomeBinding
import com.neltech.renthouse.model.utill.IPref
import com.neltech.renthouse.view.base.BaseFragment
import com.neltech.renthouse.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@DelicateCoroutinesApi
@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(), CoroutineScope {
    val sharedViewModel by activityViewModels<BaseViewModel>()
    val viewModel by viewModels<HomeViewModel>()
    private var _viewBinding: FragmentHomeBinding? = null
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
val map:HashMap<String,String> = hashMapOf()
    @Inject
    lateinit var sharedPref: IPref
    override fun setup() {
        _viewBinding = binding
        _viewBinding!!.TIETittle.addTextChangedListener {
            map["uId"] =it.toString()
        }
        _viewBinding!!.TIEDescription.addTextChangedListener {
            map["uName"] =it.toString()
        }
        _viewBinding!!.BTSelectImage.setOnClickListener {
         takeImage(){
             map["uImage"] = sharedPref.str("IMAGE")
             Log.d("TAG", "setup:---> "+it)

         }
        }
        _viewBinding!!.FPChooseCamera.setOnClickListener {
            nav(R.id.action_homeFragment_to_imageSelectionFragment)
        }
        _viewBinding!!.BTSubmitImage.setOnClickListener {
            map["action"] = "insert"
            Log.d("TAG", "setup: $map    ${sharedPref.str("IMAGE")}")
            viewModel.uploadImage(map)
        }
    }

    override fun layoutRes(): Int =R.layout.fragment_home
    override fun onDestroyView() {
        super.onDestroyView()
        job.cancel()
    }
}