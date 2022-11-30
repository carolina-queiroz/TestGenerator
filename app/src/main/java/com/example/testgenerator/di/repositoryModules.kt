package com.example.testgenerator.di

import com.example.testgenerator.repository.HomeRepository
import com.example.testgenerator.repository.MainRepository
import io.reactivex.schedulers.Schedulers.single
import org.koin.dsl.module
import java.lang.reflect.Array.get

val repositoryModules = module {

    single { MainRepository(get()) }

    single { HomeRepository(get()) }

}