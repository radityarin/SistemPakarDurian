package com.kelompoksatu.sistempakardurian.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "prediction")
data class Prediction(
    @PrimaryKey
    @SerializedName("id_prediction")
    var idPrediction: String,
    @SerializedName("cf")
    var cf: Double,
    @SerializedName("hasil_klasifikasi")
    var hasilKlasifikasi: String,
    @SerializedName("posterior")
    var posterior: Double
)