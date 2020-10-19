package com.kelompoksatu.sistempakardurian.ui.diagnosis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis
import com.kelompoksatu.sistempakardurian.data.repository.AppRepository
import com.kelompoksatu.sistempakardurian.data.request.DiagnosisRequest
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse
import kotlinx.coroutines.launch

class AskViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    var prediction: MutableLiveData<PredictionResponse> = MutableLiveData()

    fun diagnose(diagnosisRequest: DiagnosisRequest) {
        repository.diagnose(diagnosisRequest) {
            prediction.postValue(it)
        }
    }

    fun insertDiagnosis(symptomps: Diagnosis) = viewModelScope.launch {
        repository.insertDiagnosis(symptomps)
    }

    fun getDiagnosisHistory() = repository.diagnosisHistory()

    fun deleteDiagnosisHistory() = viewModelScope.launch {
        repository.deleteDiagnosisHistory()
    }


}