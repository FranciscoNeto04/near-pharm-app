package com.example.nearpharm

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nearPharmModule = module {
    single { "RetrofitJustgeek.retrofit()" }
    single { "UserRepository(get())" }
//    viewModel { UserViewModel(get()) }
}