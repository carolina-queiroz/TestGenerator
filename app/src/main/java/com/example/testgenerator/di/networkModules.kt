package com.example.testgenerator.di

import com.example.testgenerator.BuildConfig
import com.example.testgenerator.network.ApiInterface
import com.example.testgenerator.network.HomeInterface
import com.example.testgenerator.network.MainInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
    logging.level = HttpLoggingInterceptor.Level.BODY

    val httpClient = OkHttpClient.Builder()
// add your other interceptors …

// add logging as last interceptor
// add your other interceptors …

// add logging as last interceptor
    httpClient.addInterceptor(logging)

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    single { get<Retrofit>().create(ApiInterface::class.java) }

    single { get<Retrofit>().create(MainInterface::class.java) }

    single { get<Retrofit>().create(HomeInterface::class.java) }

}

