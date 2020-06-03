package kz.example.arch

import android.app.Application
import kz.example.arch.data.appModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

open class App: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this,listOf(appModule))
        Timber.plant(Timber.DebugTree())
    }
}