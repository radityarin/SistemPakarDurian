package com.kelompoksatu.sistempakardurian.data.repository

import com.kelompoksatu.sistempakardurian.data.request.Symptomps
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse

interface Repository {

    fun diagnose(
        symtomps: Symptomps,
        onResult: (PredictionResponse) -> Unit
    )
}