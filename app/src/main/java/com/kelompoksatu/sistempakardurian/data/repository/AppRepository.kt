package com.kelompoksatu.sistempakardurian.data.repository

import android.content.Context
import com.google.gson.Gson
import com.kelompoksatu.sistempakardurian.data.ApiObserver
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis
import com.kelompoksatu.sistempakardurian.data.request.DiagnosisRequest
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse
import com.kelompoksatu.sistempakardurian.data.source.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppRepository(private val api: Api, context: Context) : Repository {

    private val compositeDisposable = CompositeDisposable()
    private val db = DbDiagnoseRepository(context)

    override fun diagnose(
        symtomps: DiagnosisRequest,
        onResult: (PredictionResponse) -> Unit
    ) {
        api.diagnose(
            idDiagnose = symtomps.idDiagnosys,
            type = symtomps.type,
            listSymtomps = Gson().toJsonTree(symtomps.listSymptomps).toString(),
            cfUser = Gson().toJsonTree(symtomps.cfUser).toString()
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<PredictionResponse>(compositeDisposable) {
                override fun onApiSuccess(data: PredictionResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun diagnosisHistory() = db.getAllDiagnosis()

    override suspend fun insertDiagnosis(symptomps: Diagnosis) {
        db.insertDiagnosis(symptomps)
    }

    override suspend fun deleteDiagnosisHistory() {
        db.deleteAllDiagnosis()
    }

}
