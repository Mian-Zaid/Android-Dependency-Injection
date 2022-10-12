package com.techyourchance.dagger2course.screens.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.PresentationModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot))
            .build()
    }
    val injector get() = Injector(presentationComponent)
}