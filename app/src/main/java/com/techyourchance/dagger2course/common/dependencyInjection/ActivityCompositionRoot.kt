package com.techyourchance.dagger2course.common.dependencyInjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreenNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {
    val screenNavigator by lazy {
        ScreenNavigator(activity)
    }

    val layoutInflater get() = LayoutInflater.from(activity)
    val fragmentManager get() = activity.supportFragmentManager
    val stackoverflowApi get() = appCompositionRoot.stackoverflowApi


}