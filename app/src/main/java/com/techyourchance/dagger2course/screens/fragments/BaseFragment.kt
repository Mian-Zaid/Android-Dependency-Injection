package com.techyourchance.dagger2course.screens.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.PresentationCompositionRoot
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {
    private val compositionRoot by lazy {
        PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot)
    }

    val injector get() = Injector(compositionRoot)
}