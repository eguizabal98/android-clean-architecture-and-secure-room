package com.example.data.repository

import com.example.domain.domain.Result
import java.io.IOException

abstract class BaseRepository {

    protected suspend fun <T : Any?> dbOperation(dbOperation: suspend () -> Result<T>): Result<T> {
        return try {
            dbOperation()
        } catch (e: IOException) {
            Result.Failure(Exception("The operation could not be executed"))
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }

}