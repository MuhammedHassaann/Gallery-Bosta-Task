package com.muhammedhassaan.gallerytask.domain.remote

import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.model.User

interface RemoteDataSource {

    suspend fun getRandomUser(): User

    suspend fun getAlbums(userId: Int): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>
}