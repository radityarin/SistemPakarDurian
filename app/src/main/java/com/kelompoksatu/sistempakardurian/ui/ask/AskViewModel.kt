package com.kelompoksatu.sistempakardurian.ui.ask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelompoksatu.sistempakardurian.data.repository.AppRepository
import com.kelompoksatu.sistempakardurian.data.request.Symptomps
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse

class AskViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    var prediction: MutableLiveData<PredictionResponse> = MutableLiveData()

    fun diagnose(symptomps: Symptomps) {
        repository.diagnose(symptomps) {
            prediction.postValue(it)
        }
    }
//
//    fun insertDiagnose(context: Context, symptomps: Prediction) = viewModelScope.launch {
//        val db = DbDiagnoseRepository(context)
//        db.insertDiagnose(symptomps)
//    }
//
//    fun getAllDiagnose(context: Context) {
//        val db = DbDiagnoseRepository(context)
//        db.getAllDiagnose()
//    }


}