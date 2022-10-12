package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.ActivityCompositionRoot

open class BaseActivity : AppCompatActivity() {
    override fun getSupportFragmentManager(): FragmentManager {
        return super.getSupportFragmentManager()
    }
    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val compositionRoot get() = ActivityCompositionRoot(this, appCompositionRoot)
}