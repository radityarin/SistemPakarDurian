package com.kelompoksatu.sistempakardurian.data.response

import com.google.gson.annotations.SerializedName
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis

data class PredictionResponse(
    @SerializedName("data")
    var diagnosis: Diagnosis,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean
)