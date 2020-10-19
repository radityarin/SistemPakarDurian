package com.kelompoksatu.sistempakardurian.data.source

import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("diagnose")
    fun diagnose(
        @Field("id_diagnosa") idDiagnose: String,
        @Field("jenis") type: String,
        @Field("gejala") listSymtomps: String,
        @Field("cf_user") cfUser: String
    ): Observable<PredictionResponse>
}