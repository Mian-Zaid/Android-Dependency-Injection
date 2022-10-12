package com.techyourchance.dagger2course.screens.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}