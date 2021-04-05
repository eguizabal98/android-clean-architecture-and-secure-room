package com.example.domain.di

import com.example.domain.interactor.*
import org.koin.dsl.module

val domainModule = module {
    factory<SavePersonUseCase> { SavePersonUseCaseImpl(personRepository = get()) }
    factory<GetPersonUseCase> { GetPersonUseCaseImpl(personRepository = get()) }
    factory<GetAllPersonUseCase> { GetAllPersonUseCaseImpl(personRepository = get()) }
    factory<UpdatePersonUseCase> { UpdatePersonUseCaseImpl(personRepository = get()) }
    factory<DeletePersonUseCase> { DeletePersonUseCaseImpl(personRepository = get()) }
}