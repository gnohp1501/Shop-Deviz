package com.example.shopdeviz.presentation.di

import com.example.shopdeviz.Application
import com.example.shopdeviz.data.di.apiModules
import com.example.shopdeviz.presentation.viewmodel.ProductViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModules = module {
    single { androidApplication() as Application }
}

val viewModelModules = module {
    factory { ProductViewModel(get()) }
}

val diModules = listOf(
    appModules, apiModules, viewModelModules
)