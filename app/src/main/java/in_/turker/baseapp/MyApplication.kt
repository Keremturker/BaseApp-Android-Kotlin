package in_.turker.baseapp

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@HiltAndroidApp
class MyApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}