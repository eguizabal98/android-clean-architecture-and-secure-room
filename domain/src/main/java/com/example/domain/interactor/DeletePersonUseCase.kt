package com.example.domain.interactor

import com.example.domain.domain.Result

interface DeletePersonUseCase {
    suspend operator fun invoke(id: Int): Result<Boolean>
}