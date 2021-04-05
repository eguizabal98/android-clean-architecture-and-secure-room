package com.example.domain.domain

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out R>(val value: R) : Result<R>()
    data class Failure(val e: Exception) : Result<Nothing>()
}
