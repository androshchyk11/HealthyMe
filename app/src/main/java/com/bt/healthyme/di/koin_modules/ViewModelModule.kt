package com.bt.healthyme.di.koin_modules

import com.bt.healthyme.viewModels.SignInViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { SignInViewModel(get()) }
}