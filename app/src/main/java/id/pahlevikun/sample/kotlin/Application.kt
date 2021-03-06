package id.pahlevikun.sample.kotlin

import android.app.Application
import id.pahlevikun.jotter.Jotter
import id.pahlevikun.jotter.event.ActivityEvent
import id.pahlevikun.jotter.event.FragmentEvent
import id.pahlevikun.sample.kotlin.listener.ActivityLifecycleListener
import id.pahlevikun.sample.kotlin.listener.JotterListener

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        // This is for registering the listener object
        // listenWithActivityLifecycleCallback()
        // init Jotter for listening to all event
        listenWithJotter()
    }

    private fun listenWithJotter() {
        Jotter
            .Builder(this)
            .setLogEnable(true)
            .setActivityEventFilter(listOf(ActivityEvent.CREATE, ActivityEvent.DESTROY))
            .setFragmentEventFilter(listOf(FragmentEvent.VIEW_CREATE, FragmentEvent.PAUSE))
            .setJotterListener(JotterListener)
            .build()
            .startListening()
    }

    private fun listenWithActivityLifecycleCallback() {
        registerActivityLifecycleCallbacks(ActivityLifecycleListener)
    }
}