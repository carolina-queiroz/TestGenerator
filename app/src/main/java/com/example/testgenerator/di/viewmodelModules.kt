package com.example.testgenerator.di

import com.example.keyaccounts.viewmodel.*
import com.example.testgenerator.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.lang.reflect.Array.get

val viewmodelModules = module {

    viewModel { MainViewModel(get()) }

    viewModel { HomeViewModel(get()) }

}