package com.techyourchance.dagger2course.common.dependencyInjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    private val screenNavigator by lazy {
        ScreenNavigator(activity)
    }

    @Provides
    fun activity() = activity

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

    @Provides
    fun screensNavigator(activity: AppCompatActivity) = screenNavigator

}