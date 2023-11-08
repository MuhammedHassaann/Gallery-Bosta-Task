package com.muhammedhassaan.gallerytask.domain.usecase

import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): RandomUser =
        repository.getUser()
}

typealias RandomUser = Flow<Result<User>>