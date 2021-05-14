package com.bt.healthyme.di.koin_modules

import com.bt.healthyme.view.adapters.StatisticsAdapter
import com.bt.healthyme.view.adapters.TrainingsAdapter
import org.koin.dsl.module

val adaptersModule = module {
    factory { TrainingsAdapter() }
    factory { StatisticsAdapter() }
}