package com.example.nearpharm.retrofit

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import java.lang.ref.WeakReference

object ContextProvider : Application.ActivityLifecycleCallbacks {

    private var _currentContext: WeakReference<Context>? = null

    fun initialContext(context: Context) {
        _currentContext = WeakReference(context)
    }

    val currentContext: Context?
        get() = _currentContext?.get()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        _currentContext = WeakReference(activity)
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
        _currentContext = WeakReference(activity)
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}