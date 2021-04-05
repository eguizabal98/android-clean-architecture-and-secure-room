package com.example.data.di

import com.example.data.repository.PersonRepositoryImpl
import com.example.domain.repository.PersonRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PersonRepository> { PersonRepositoryImpl(personDao = get()) }
}