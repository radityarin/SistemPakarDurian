package com.kelompoksatu.sistempakardurian.data.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "prediction")
data class Prediction(
    @SerializedName("id_prediction")
    var idPrediction: Double,
    @SerializedName("cf")
    var cf: Double,
    @SerializedName("hasil_klasifikasi")
    var hasilKlasifikasi: String,
    @SerializedName("posterior")
    var posterior: Double
)