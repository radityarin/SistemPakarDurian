package com.kelompoksatu.sistempakardurian.di

import com.kelompoksatu.sistempakardurian.ui.diagnosis.viewmodel.AskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AskViewModel(
            get()
        )
    }
}