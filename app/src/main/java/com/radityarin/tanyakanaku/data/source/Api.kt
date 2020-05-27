package com.radityarin.tanyakanaku.data.source

import com.radityarin.tanyakanaku.data.response.AnswerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@JvmSuppressWildcards
interface Api {

    @GET("soekarno/ask")
    fun getAnswers(
        @Query(
            value = "query",
            encoded = true
        ) query: String
    ): Call<AnswerResponse>

}