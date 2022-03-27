package com.neltech.renthouse.view.base

import androidx.annotation.IdRes
import androidx.navigation.NavController


interface NavigationHost {
  fun moviesEnabled(): Boolean
  fun findNavControl(): NavController?
  fun hideNavigation(animate: Boolean)
  fun showNavigation(animate: Boolean)
  fun openTab(@IdRes navigationId: Int)
  fun openDiscoverTab()
}
