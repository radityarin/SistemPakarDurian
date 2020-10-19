package com.kelompoksatu.sistempakardurian.di

import com.kelompoksatu.sistempakardurian.data.repository.AppRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        AppRepository(get(),this.androidContext())
    }
}