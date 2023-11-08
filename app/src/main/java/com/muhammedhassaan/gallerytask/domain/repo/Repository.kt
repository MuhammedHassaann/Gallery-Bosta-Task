package com.muhammedhassaan.gallerytask.domain.repo

import com.muhammedhassaan.gallerytask.domain.usecase.Albums
import com.muhammedhassaan.gallerytask.domain.usecase.AlbumsWithPhoto
import com.muhammedhassaan.gallerytask.domain.usecase.Photos
import com.muhammedhassaan.gallerytask.domain.usecase.RandomUser

interface Repository {

    suspend fun getUser(): RandomUser

    suspend fun getAlbums(userId: Int): Albums

    suspend fun getPhotos(albumId: Int): Photos

    suspend fun getAlbumWithImage(userId: Int): AlbumsWithPhoto
}