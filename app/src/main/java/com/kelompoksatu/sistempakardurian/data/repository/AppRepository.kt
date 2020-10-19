package com.kelompoksatu.sistempakardurian.data.repository

import android.util.Log
import com.google.gson.Gson
import com.kelompoksatu.sistempakardurian.data.ApiObserver
import com.kelompoksatu.sistempakardurian.data.request.Symptomps
import com.kelompoksatu.sistempakardurian.data.response.PredictionResponse
import com.kelompoksatu.sistempakardurian.data.source.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppRepository(private val api: Api) : Repository {
    private val compositeDisposable = CompositeDisposable()

    override fun diagnose(
        symtomps: Symptomps,
        onResult: (PredictionResponse) -> Unit
    ) {
        api.diagnose(idDiagnose = symtomps.idDiagnosys, type = symtomps.type, listSymtomps = Gson().toJsonTree(symtomps.listSymptomps).toString(), cfUser = Gson().toJsonTree(symtomps.cfUser).toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<PredictionResponse>(compositeDisposable) {
                override fun onApiSuccess(data: PredictionResponse) {
                    Log.d("cek",data.message)
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

}