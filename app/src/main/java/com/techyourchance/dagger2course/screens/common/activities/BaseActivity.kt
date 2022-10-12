package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.*

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appComponent

    private val activityModule by lazy {
        ActivityModule(this, appCompositionRoot)
    }

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(activityModule)
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }
    val injector get() = Injector(presentationComponent)


}