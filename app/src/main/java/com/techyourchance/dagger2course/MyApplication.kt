package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyInjection.AppModule
import com.techyourchance.dagger2course.common.dependencyInjection.DaggerAppComponent

class MyApplication : Application() {


    val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}