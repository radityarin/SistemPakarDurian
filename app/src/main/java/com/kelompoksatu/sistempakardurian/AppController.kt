package com.kelompoksatu.sistempakardurian

import android.app.Application
import com.kelompoksatu.sistempakardurian.di.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class AppController : Application() {

    private val calConfig: CalligraphyConfig by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppController)
            modules(appModule)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
        }

        CalligraphyConfig.initDefault(calConfig)

    }

}