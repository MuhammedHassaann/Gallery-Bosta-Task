package com.muhammedhassaan.gallerytask.data.repo

import android.accounts.NetworkErrorException
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.domain.remote.RemoteDataSource
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import com.muhammedhassaan.gallerytask.domain.usecase.Albums
import com.muhammedhassaan.gallerytask.domain.usecase.AlbumsWithPhoto
import com.muhammedhassaan.gallerytask.domain.usecase.Photos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override suspend fun getUser(): Flow<Result<User>> = flow {
        try {
            emit(Result.Loading())
            val user = remoteDataSource.getRandomUser()
            emit(Result.Success(data = user))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.localizedMessage ?: EndString.UNEXPECTED_ERROR_OCCURRED))
        }
    }

    override suspend fun getAlbums(userId: Int): Albums = flow {
        try {
            emit(Result.Loading())
            val albums = remoteDataSource.getAlbums(userId)
            emit(Result.Success(data = albums))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.localizedMessage ?: EndString.UNEXPECTED_ERROR_OCCURRED))
        }
    }

    override suspend fun getPhotos(albumId: Int): Photos = flow {
        try {
            emit(Result.Loading())
            val photos = remoteDataSource.getPhotos(albumId)
            emit(Result.Success(data = photos))
        } catch (e: NetworkErrorException) {
            emit(Result.Error(message = e.message ?: EndString.UNEXPECTED_ERROR_OCCURRED))
        }
    }

    override suspend fun getAlbumWithImage(userId: Int): AlbumsWithPhoto = flow {
        try {
            emit(Result.Loading())
            val albumsWithPhoto = remoteDataSource.getAlbumWithImage(userId)
            emit(Result.Success(albumsWithPhoto))
        }catch (e: NetworkErrorException){
            emit(Result.Error(message = e.localizedMessage ?: EndString.UNEXPECTED_ERROR_OCCURRED))
        }
    }

}