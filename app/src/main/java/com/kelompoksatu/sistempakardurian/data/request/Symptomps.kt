package com.kelompoksatu.sistempakardurian.data.request

import com.google.gson.annotations.SerializedName

data class Symptomps (
    @SerializedName("id_diagnosa")
    var idDiagnosys: String,
    @SerializedName("jenis")
    var type: String,
    @SerializedName("gejala")
    var listSymptomps: List<String>,
    @SerializedName("cf_user")
    var cfUser: List<Double>
)