package com.kelompoksatu.sistempakardurian.data.response

import com.google.gson.annotations.SerializedName
import com.kelompoksatu.sistempakardurian.data.model.Prediction

data class PredictionResponse(
    @SerializedName("data")
    var prediction: Prediction,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean
)