package com.muhammedhassaan.gallerytask.domain.usecase

import android.accounts.NetworkErrorException
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import com.muhammedhassaan.gallerytask.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(albumId: Int): Flow<Photos> = flow {
        try {
            emit(Result.Loading())
            val photos = repository.getPhotos(albumId)
            emit(Result.Success(data = photos))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.message ?: "Unexpected Error Occurred"))
        }
    }
}

typealias Photos = Result<List<Photo>>