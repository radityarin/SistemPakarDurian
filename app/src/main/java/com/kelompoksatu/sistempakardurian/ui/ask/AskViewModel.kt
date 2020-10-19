package com.kelompoksatu.sistempakardurian.ui.ask

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelompoksatu.sistempakardurian.data.model.Prediction
import com.kelompoksatu.sistempakardurian.data.repository.AppRepository
import com.kelompoksatu.sistempakardurian.data.repository.DbDiagnoseRepository
import com.kelompoksatu.sistempakardurian.data.request.Symptomps
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse
import kotlinx.coroutines.launch

class AskViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    var prediction: MutableLiveData<PredictionResponse> = MutableLiveData()
    var allData: MutableLiveData<List<Prediction>> = MutableLiveData()

    fun diagnose(symptomps: Symptomps) {
        repository.diagnose(symptomps) {
            prediction.postValue(it)
        }
    }

    fun insertDiagnose(context: Context, symptomps: Prediction) = viewModelScope.launch {
        val db = DbDiagnoseRepository(context)
        db.insertDiagnose(symptomps)
    }

    fun getAllDiagnose(context: Context) = DbDiagnoseRepository(context).getAllDiagnose()


}