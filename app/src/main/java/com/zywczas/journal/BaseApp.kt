package com.zywczas.journal

import android.app.Application
import com.zywczas.journal.di.appKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(appKoinModules)
        }
    }
}
