package com.muhammedhassaan.gallerytask.domain.usecase

import android.accounts.NetworkErrorException
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import com.muhammedhassaan.gallerytask.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Result<User>> = flow {
        try {
            emit(Result.Loading())
            val user = repository.getUser()
            emit(Result.Success(data = user))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.message ?: "Unexpected Error Occurred"))
        }
    }
}