package com.techyourchance.dagger2course.common.dependencyInjection

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun stackoverflowApi(): StackoverflowApi
    fun application():Application
}