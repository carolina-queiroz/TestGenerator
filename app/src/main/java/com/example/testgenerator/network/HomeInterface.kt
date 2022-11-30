package com.example.testgenerator.network

import io.reactivex.Observable
import retrofit2.http.GET

interface HomeInterface {
    @GET("/")
    fun teste(): Observable<String>

}