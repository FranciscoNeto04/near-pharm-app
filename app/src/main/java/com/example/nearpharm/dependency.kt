package com.example.nearpharm

import com.example.nearpharm.repository.UserRepository
import com.example.nearpharm.retrofit.NearPharmRetrofit
import com.example.nearpharm.viewmodel.UserViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val nearPharmModule = module {
    single { NearPharmRetrofit.retrofit() }
    single { NearPharmRetrofit.user(get()) }
    single { UserRepository(get()) }
    viewModel { UserViewModel(get()) }
}