package com.example.testgenerator.repository

import com.example.testgenerator.network.HomeInterface
import io.reactivex.Observable

class HomeRepository(private val homeInterface: HomeInterface) {

    fun testeRepository(): Observable<String> {
        return Observable.just("Deu certo")
        /*homeInterface.teste()*/
    }

}