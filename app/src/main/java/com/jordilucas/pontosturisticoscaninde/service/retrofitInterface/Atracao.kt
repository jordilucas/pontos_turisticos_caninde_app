package com.jordilucas.pontosturisticoscaninde.service.retrofitInterface

import com.jordilucas.pontosturisticoscaninde.dto.Atracao
import retrofit2.Call
import retrofit2.http.GET

interface Atracao {

    @GET("atracoes")
    fun atracaoList() : Call<List<Atracao>>

}