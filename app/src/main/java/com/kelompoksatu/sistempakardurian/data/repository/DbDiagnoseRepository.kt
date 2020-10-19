package com.kelompoksatu.sistempakardurian.data.repository

import android.content.Context
import com.kelompoksatu.sistempakardurian.data.dao.AppDatabase
import com.kelompoksatu.sistempakardurian.data.model.Prediction

class DbDiagnoseRepository(context: Context) {

    private val db = AppDatabase.getInstance(context)?.diagnoseDao()

    suspend fun insertDiagnose(data: Prediction) = db?.insertDiagnoseData(data)

    fun getAllDiagnose() = db?.getAllDiagnose()
//
//    suspend fun deleteAllTickets() = db?.deleteAllTickets()
//
//    suspend fun update(data: Ticket) = db?.update(data)
//
//    suspend fun deleteSelectedTicket(id: String) = db?.deleteSelectedItem(id)

}