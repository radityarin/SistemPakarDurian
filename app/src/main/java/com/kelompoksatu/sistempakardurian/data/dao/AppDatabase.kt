package com.kelompoksatu.sistempakardurian.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kelompoksatu.sistempakardurian.data.model.Diagnosis
import com.kelompoksatu.sistempakardurian.util.Constant.DB_NAME
import com.kelompoksatu.sistempakardurian.util.Converters

@Database(entities = [Diagnosis::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun diagnoseDao(): DaoDiagnosis

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }

}