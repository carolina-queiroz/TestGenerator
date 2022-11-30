package com.example.testgenerator.network

import io.reactivex.Observable
import retrofit2.http.GET

interface MainInterface {

    @GET("/")
    fun teste(): Observable<String>

}