package com.example.testgenerator.repository

import com.example.testgenerator.network.MainInterface
import io.reactivex.Observable

class MainRepository(private val mainInterface: MainInterface) {

    fun testeRepository(): Observable<String> {
        return Observable.just("Deu certo")
        /*mainInterface.teste()*/
    }

}