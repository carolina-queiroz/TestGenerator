package com.example.testgenerator.network

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/aluno")
    fun getAluno(): Observable<AlunoResponse>

    @GET("/materias")
    fun getMaterias(): Observable<MateriasResponse>

    @GET("/questao")
    fun getQuestao(): Observable<QuestaoResponse>

    @POST("/prova")
    fun postProva(@Body provaRequest: ProvaRequest):Observable<ProvaResponse>

}