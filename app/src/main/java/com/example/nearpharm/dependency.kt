package com.example.nearpharm

import com.example.nearpharm.retrofit.NearPharmRetrofit
import org.koin.dsl.module

val nearPharmModule = module {
    single { NearPharmRetrofit.retrofit() }
//
//    viewModel { UserViewModel(get()) }
//    viewModel { LoginViewModel(get()) }
}