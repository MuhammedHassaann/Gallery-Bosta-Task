package com.muhammedhassaan.gallerytask.domain.usecase

import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlbumsWithPhotoUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(userId: Int): AlbumsWithPhoto =
        repository.getAlbumWithImage(userId)
}

typealias AlbumsWithPhoto = Flow<Result<List<Triple<Album, String, Int>>>>
typealias Albums = Flow<Result<List<Album>>>