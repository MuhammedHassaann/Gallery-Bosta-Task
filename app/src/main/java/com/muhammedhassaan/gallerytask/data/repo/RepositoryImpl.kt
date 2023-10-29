package com.muhammedhassaan.gallerytask.data.repo

import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.domain.remote.RemoteDataSource
import com.muhammedhassaan.gallerytask.domain.repo.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override suspend fun getUser(): User =
        remoteDataSource.getRandomUser()


    override suspend fun getAlbums(userId: Int): List<Album> =
        remoteDataSource.getAlbums(userId)

    override suspend fun getPhotos(albumId: Int): List<Photo> =
        remoteDataSource.getPhotos(albumId)

}