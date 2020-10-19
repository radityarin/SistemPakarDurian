package com.kelompoksatu.sistempakardurian.data.model


import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Prediction(
    @SerializedName("id_prediction")
    var idPrediction: Double,
    @SerializedName("cf")
    var cf: Double,
    @SerializedName("hasil_klasifikasi")
    var hasilKlasifikasi: String,
    @SerializedName("posterior")
    var posterior: Double
): Parcelable