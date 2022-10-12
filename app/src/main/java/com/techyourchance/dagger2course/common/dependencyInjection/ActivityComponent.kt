package com.techyourchance.dagger2course.common.dependencyInjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
    fun layoutInflater(): LayoutInflater
    fun fragmentManager(): FragmentManager
    fun screenNavigator(): ScreenNavigator
    fun stackoverflowApi(): StackoverflowApi
}