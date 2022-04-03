package com.neltech.renthouse.view.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.ActivityMainBinding
import com.neltech.renthouse.view.base.BaseActivity
import com.neltech.renthouse.view.base.NavigationHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationHost {
    private var viewBinding: ActivityMainBinding? = null
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        viewBinding = binding
 /*       // Request camera permissions
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }*/
    }



    override fun layoutRes(): Int =R.layout.activity_main

    override fun findNavControl(): NavController? {
        TODO("Not yet implemented")
    }

    override fun hideNavigation(animate: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showNavigation(animate: Boolean) {
        TODO("Not yet implemented")
    }


}