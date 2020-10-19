package com.kelompoksatu.sistempakardurian.data.repository

import androidx.lifecycle.LiveData
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis
import com.kelompoksatu.sistempakardurian.data.request.DiagnosisRequest
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse

interface Repository {

    fun diagnose(
        symtomps: DiagnosisRequest,
        onResult: (PredictionResponse) -> Unit
    )

    fun diagnosisHistory(): LiveData<List<Diagnosis>>?
    suspend fun insertDiagnosis(symptomps: Diagnosis)
    suspend fun deleteDiagnosisHistory()
}