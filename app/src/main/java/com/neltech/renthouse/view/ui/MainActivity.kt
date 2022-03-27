package com.neltech.renthouse.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.ActivityMainBinding
import com.neltech.renthouse.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var viewBinding: ActivityMainBinding? = null
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        viewBinding = binding
    }

    override fun layoutRes(): Int =R.layout.activity_main

}