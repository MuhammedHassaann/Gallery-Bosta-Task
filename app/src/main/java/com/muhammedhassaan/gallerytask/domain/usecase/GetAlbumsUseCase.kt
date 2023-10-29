package com.muhammedhassaan.gallerytask.domain.usecase

import android.accounts.NetworkErrorException
import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import com.muhammedhassaan.gallerytask.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(userId: Int): Flow<Albums> = flow {
        try {
            emit(Result.Loading())
            val albums = repository.getAlbums(userId)
            emit(Result.Success(data = albums))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.message ?: "Unexpected Error Occurred"))
        }
    }
}

typealias Albums = Result<List<Album>>