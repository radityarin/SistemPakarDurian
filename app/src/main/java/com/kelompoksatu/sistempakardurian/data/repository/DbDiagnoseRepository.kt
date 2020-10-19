package com.kelompoksatu.sistempakardurian.data.repository

import android.content.Context
import com.kelompoksatu.sistempakardurian.data.dao.AppDatabase
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis

class DbDiagnoseRepository(context: Context) {

    private val db = AppDatabase.getInstance(context)?.diagnoseDao()

    suspend fun insertDiagnosis(data: Diagnosis) = db?.insertDiagnosis(data)

    fun getAllDiagnosis() = db?.getAllDiagnosis()

    suspend fun deleteAllDiagnosis() = db?.deleteAllDiagnosis()

}