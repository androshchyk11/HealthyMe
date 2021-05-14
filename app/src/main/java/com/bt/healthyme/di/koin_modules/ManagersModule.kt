package com.bt.healthyme.di.koin_modules

import com.bt.healthyme.managers.SharedPreferencesManager
import org.koin.dsl.module

val managersModule = module {

    single { SharedPreferencesManager(get()) }
}