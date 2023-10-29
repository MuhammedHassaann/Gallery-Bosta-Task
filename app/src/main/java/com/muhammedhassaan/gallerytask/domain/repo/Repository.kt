package com.muhammedhassaan.gallerytask.domain.repo

import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.model.User

interface Repository {

    suspend fun getUser(): User

    suspend fun getAlbums(userId: Int): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>
}