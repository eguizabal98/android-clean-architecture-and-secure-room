package com.example.secureroombase.di

import com.example.secureroombase.ui.create.CreatePersonViewModel
import com.example.secureroombase.ui.list.ListViewModel
import com.example.secureroombase.ui.update.UpdateViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel { CreatePersonViewModel(savePersonUseCase = get()) }
    viewModel { ListViewModel(getAllPersonUseCase = get()) }
    viewModel {
        UpdateViewModel(
            getPersonUseCase = get(),
            updatePersonUseCase = get(),
            deletePersonUseCase = get()
        )
    }
}