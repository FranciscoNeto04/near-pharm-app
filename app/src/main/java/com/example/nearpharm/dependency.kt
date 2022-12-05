package com.example.nearpharm

import com.example.nearpharm.repository.LoginRepository
import com.example.nearpharm.repository.UserRepository
import com.example.nearpharm.retrofit.NearPharmRetrofit
import com.example.nearpharm.viewmodel.LoginViewModel
import com.example.nearpharm.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nearPharmModule = module {
    single { NearPharmRetrofit.retrofit() }
//
//    viewModel { UserViewModel(get()) }
//    viewModel { LoginViewModel(get()) }
}