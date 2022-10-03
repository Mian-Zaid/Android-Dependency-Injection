package com.techyourchance.dagger2course.screens.common.viewMvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

open class BaseViewMvc<LISTENER_TYPE>(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    @LayoutRes private val layoutID: Int
) {
    protected val listeners = HashSet<LISTENER_TYPE>()

    val rootView: View = layoutInflater.inflate(layoutID, parent, false)

    protected val context: Context get() = rootView.context


    //Register listener
    fun registerListener(listener: LISTENER_TYPE) {
        this.listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_TYPE) {
        this.listeners.remove(listener)
    }

    protected fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

}