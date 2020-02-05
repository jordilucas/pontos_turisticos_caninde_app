package com.jordilucas.pontosturisticoscaninde.service

import com.jordilucas.pontosturisticoscaninde.service.retrofitInterface.Atracao
import com.jordilucas.pontosturisticoscaninde.service.retrofitInterface.PontosTuristicos
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ponto-turisticos.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun atracaoService() = retrofit.create(Atracao::class.java)

}