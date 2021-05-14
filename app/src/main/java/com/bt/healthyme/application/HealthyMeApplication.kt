package com.bt.healthyme.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import androidx.work.Configuration
import com.bt.healthyme.di.koin_modules.adaptersModule
import com.bt.healthyme.di.koin_modules.managersModule
import com.bt.healthyme.di.koin_modules.viewModelModule
import org.koin.android.ext.koin.androidContext

/**
 * Created by ArtemLampa on 26.04.2021.
 */
class HealthyMeApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }
    private fun startKoin(){
        org.koin.core.context.startKoin {
            androidContext(this@HealthyMeApplication)
            modules(
                viewModelModule,
                managersModule,
                adaptersModule
            )
        }
    }
}