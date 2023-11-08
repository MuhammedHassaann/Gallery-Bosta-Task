package com.muhammedhassaan.gallerytask.domain.usecase

import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(albumId: Int): Photos =
        repository.getPhotos(albumId)
}

typealias Photos = Flow<Result<List<Photo>>>